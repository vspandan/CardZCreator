package com.android.myapp;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.view.WindowManager;


public class DragController {
	 private static final String TAG = "DragController";

	    /** Indicates the drag is a move.  */
	    public static int DRAG_ACTION_MOVE = 0;

	    /** Indicates the drag is a copy.  */
	    public static int DRAG_ACTION_COPY = 1;

	    private static final int VIBRATE_DURATION = 35;

	    private static final boolean PROFILE_DRAWING_DURING_DRAG = false;

	    private Context mContext;
	    private Vibrator mVibrator;

	    // temporaries to avoid gc thrash
	    private Rect mRectTemp = new Rect();
	    private final int[] mCoordinatesTemp = new int[2];

	    /** Whether or not we're dragging. */
	    private boolean mDragging;

	    /** X coordinate of the down event. */
	    private float mMotionDownX;

	    /** Y coordinate of the down event. */
	    private float mMotionDownY;

	    /** Info about the screen for clamping. */
	    private DisplayMetrics mDisplayMetrics = new DisplayMetrics();

	    /** Original view that is being dragged.  */
	    private View mOriginator;

	    /** X offset from the upper-left corner of the cell to where we touched.  */
	    private float mTouchOffsetX;

	    /** Y offset from the upper-left corner of the cell to where we touched.  */
	    private float mTouchOffsetY;

	    /** Where the drag originated */
	    private DragSource mDragSource;

	    /** The data associated with the object being dragged */
	    private Object mDragInfo;

	    /** The view that moves around while you drag.  */
	    private DragView mDragView;

	    /** Who can receive drop events */
	    private ArrayList<DropTarget> mDropTargets = new ArrayList<DropTarget>();

	    private DragListener mListener;

	    /** The window token used as the parent for the DragView. */
	    private IBinder mWindowToken;

	    private View mMoveTarget;

	    private DropTarget mLastDropTarget;

	    private InputMethodManager mInputMethodManager;

	    /**
	     * Interface to receive notifications when a drag starts or stops
	     */
	    interface DragListener {
	        
	        /**
	         * A drag has begun
	         * 
	         * @param source An object representing where the drag originated
	         * @param info The data associated with the object that is being dragged
	         * @param dragAction The drag action: either {@link DragController#DRAG_ACTION_MOVE}
	         *        or {@link DragController#DRAG_ACTION_COPY}
	         */
	        void onDragStart(DragSource source, Object info, int dragAction);
	        
	        /**
	         * The drag has eneded
	         */
	        void onDragEnd();
	    }
	    
	    /**
	     * Used to create a new DragLayer from XML.
	     *
	     * @param context The application's context.
	     */
	    public DragController(Context context) {
	        mContext = context;
	        mVibrator = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);

	    }

	    /**
	     * Starts a drag. 
	     * It creates a bitmap of the view being dragged. That bitmap is what you see moving.
	     * The actual view can be repositioned if that is what the onDrop handle chooses to do.
	     * 
	     * @param v The view that is being dragged
	     * @param source An object representing where the drag originated
	     * @param dragInfo The data associated with the object that is being dragged
	     * @param dragAction The drag action: either {@link #DRAG_ACTION_MOVE} or
	     *        {@link #DRAG_ACTION_COPY}
	     */
	    public void startDrag(View v, DragSource source, Object dragInfo, int dragAction) {
	        mOriginator = v;

	        Bitmap b = getViewBitmap(v);

	        if (b == null) {
	            // out of memory?
	            return;
	        }

	        int[] loc = mCoordinatesTemp;
	        v.getLocationOnScreen(loc);
	        int screenX = loc[0];
	        int screenY = loc[1];

	        startDrag(b, screenX, screenY, 0, 0, b.getWidth(), b.getHeight(),
	                source, dragInfo, dragAction);

	        b.recycle();

	        if (dragAction == DRAG_ACTION_MOVE) {
	            v.setVisibility(View.GONE);
	        }
	    }

	    /**
	     * Starts a drag.
	     * 
	     * @param b The bitmap to display as the drag image.  It will be re-scaled to the
	     *          enlarged size.
	     * @param screenX The x position on screen of the left-top of the bitmap.
	     * @param screenY The y position on screen of the left-top of the bitmap.
	     * @param textureLeft The left edge of the region inside b to use.
	     * @param textureTop The top edge of the region inside b to use.
	     * @param textureWidth The width of the region inside b to use.
	     * @param textureHeight The height of the region inside b to use.
	     * @param source An object representing where the drag originated
	     * @param dragInfo The data associated with the object that is being dragged
	     * @param dragAction The drag action: either {@link #DRAG_ACTION_MOVE} or
	     *        {@link #DRAG_ACTION_COPY}
	     */
	    public void startDrag(Bitmap b, int screenX, int screenY,
	            int textureLeft, int textureTop, int textureWidth, int textureHeight,
	            DragSource source, Object dragInfo, int dragAction) {
	        if (PROFILE_DRAWING_DURING_DRAG) {
	            android.os.Debug.startMethodTracing("Launcher");
	        }

	        // Hide soft keyboard, if visible
	        if (mInputMethodManager == null) {
	            mInputMethodManager = (InputMethodManager)
	                    mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
	        }
	        mInputMethodManager.hideSoftInputFromWindow(mWindowToken, 0);

	        if (mListener != null) {
	            mListener.onDragStart(source, dragInfo, dragAction);
	        }

	        int registrationX = ((int)mMotionDownX) - screenX;
	        int registrationY = ((int)mMotionDownY) - screenY;

	        mTouchOffsetX = mMotionDownX - screenX;
	        mTouchOffsetY = mMotionDownY - screenY;

	        mDragging = true;
	        mDragSource = source;
	        mDragInfo = dragInfo;

	        mVibrator.vibrate(VIBRATE_DURATION);
	        DragView dragView = mDragView = new DragView(mContext, b, registrationX, registrationY,
	                textureLeft, textureTop, textureWidth, textureHeight);
	        dragView.show(mWindowToken, (int)mMotionDownX, (int)mMotionDownY);
	    }

	    /**
	     * Draw the view into a bitmap.
	     */
	    private Bitmap getViewBitmap(View v) {
	        v.clearFocus();
	        v.setPressed(false);

	        boolean willNotCache = v.willNotCacheDrawing();
	        v.setWillNotCacheDrawing(false);

	        // Reset the drawing cache background color to fully transparent
	        // for the duration of this operation
	        int color = v.getDrawingCacheBackgroundColor();
	        v.setDrawingCacheBackgroundColor(0);

	        if (color != 0) {
	            v.destroyDrawingCache();
	        }
	        v.buildDrawingCache();
	        Bitmap cacheBitmap = v.getDrawingCache();
	        if (cacheBitmap == null) {
	            //Log.e(TAG, "failed getViewBitmap(" + v + ")", new RuntimeException());
	            return null;
	        }

	        Bitmap bitmap = Bitmap.createBitmap(cacheBitmap);

	        // Restore the view
	        v.destroyDrawingCache();
	        v.setWillNotCacheDrawing(willNotCache);
	        v.setDrawingCacheBackgroundColor(color);

	        return bitmap;
	    }

	    /**
	     * Call this from a drag source view like this:
	     *
	     * <pre>
	     *  @Override
	     *  public boolean dispatchKeyEvent(KeyEvent event) {
	     *      return mDragController.dispatchKeyEvent(this, event)
	     *              || super.dispatchKeyEvent(event);
	     * </pre>
	     */
	    public boolean dispatchKeyEvent(KeyEvent event) {
	        return mDragging;
	    }

	    /**
	     * Stop dragging without dropping.
	     */
	    public void cancelDrag() {
	        endDrag();
	    }

	    private void endDrag() {
	        if (mDragging) {
	            mDragging = false;
	            if (mOriginator != null) {
	                mOriginator.setVisibility(View.VISIBLE);
	            }
	            if (mListener != null) {
	                mListener.onDragEnd();
	            }
	            if (mDragView != null) {
	                mDragView.remove();
	                mDragView = null;
	            }
	        }
	    }

	    /**
	     * Call this from a drag source view.
	     */
	    public boolean onInterceptTouchEvent(MotionEvent ev) {
	        final int action = ev.getAction();

	        if (action == MotionEvent.ACTION_DOWN) {
	            recordScreenSize();
	        }

	        final int screenX = clamp((int)ev.getRawX(), 0, mDisplayMetrics.widthPixels);
	        final int screenY = clamp((int)ev.getRawY(), 0, mDisplayMetrics.heightPixels);

	        switch (action) {
	            case MotionEvent.ACTION_MOVE:
	                break;

	            case MotionEvent.ACTION_DOWN:
	                // Remember location of down touch
	                mMotionDownX = screenX;
	                mMotionDownY = screenY;
	                mLastDropTarget = null;
	                break;

	            case MotionEvent.ACTION_CANCEL:
	            case MotionEvent.ACTION_UP:
	                if (mDragging) {
	                    drop(screenX, screenY);
	                }
	                endDrag();
	                break;
	        }

	        return mDragging;
	    }

	    /**
	     * Sets the view that should handle move events.
	     */
	    void setMoveTarget(View view) {
	        mMoveTarget = view;
	    }    

	    public boolean dispatchUnhandledMove(View focused, int direction) {
	        return mMoveTarget != null && mMoveTarget.dispatchUnhandledMove(focused, direction);
	    }

	    /**
	     * Call this from a drag source view.
	     */
	    public boolean onTouchEvent(MotionEvent ev) {
	        if (!mDragging) {
	            return false;
	        }

	        final int action = ev.getAction();
	        final int screenX = clamp((int)ev.getRawX(), 0, mDisplayMetrics.widthPixels);
	        final int screenY = clamp((int)ev.getRawY(), 0, mDisplayMetrics.heightPixels);

	        switch (action) {
	        case MotionEvent.ACTION_DOWN:
	            // Remember where the motion event started
	            mMotionDownX = screenX;
	            mMotionDownY = screenY;
	            break;
	        case MotionEvent.ACTION_MOVE:
	            // Update the drag view.  Don't use the clamped pos here so the dragging looks
	            // like it goes off screen a little, intead of bumping up against the edge.
	            mDragView.move((int)ev.getRawX(), (int)ev.getRawY());
	            // Drop on someone?
	            final int[] coordinates = mCoordinatesTemp;
	            DropTarget dropTarget = findDropTarget(screenX, screenY, coordinates);
	            if (dropTarget != null) {
	                if (mLastDropTarget == dropTarget) {
	                    dropTarget.onDragOver(mDragSource, coordinates[0], coordinates[1],
	                        (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo);
	                } else {
	                    if (mLastDropTarget != null) {
	                        mLastDropTarget.onDragExit(mDragSource, coordinates[0], coordinates[1],
	                            (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo);
	                    }
	                    dropTarget.onDragEnter(mDragSource, coordinates[0], coordinates[1],
	                        (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo);
	                }
	            } else {
	                if (mLastDropTarget != null) {
	                    mLastDropTarget.onDragExit(mDragSource, coordinates[0], coordinates[1],
	                        (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo);
	                }
	            }
	            mLastDropTarget = dropTarget;

	           
	            break;
	        case MotionEvent.ACTION_UP:
	            if (mDragging) {
	                drop(screenX, screenY);
	            }
	            endDrag();

	            break;
	        case MotionEvent.ACTION_CANCEL:
	            cancelDrag();
	        }

	        return true;
	    }

	    private boolean drop(float x, float y) {

	        final int[] coordinates = mCoordinatesTemp;
	        DropTarget dropTarget = findDropTarget((int) x, (int) y, coordinates);

	        if (dropTarget != null) {
	            dropTarget.onDragExit(mDragSource, coordinates[0], coordinates[1],
	                    (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo);
	            if (dropTarget.acceptDrop(mDragSource, coordinates[0], coordinates[1],
	                    (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo)) {
	                dropTarget.onDrop(mDragSource, coordinates[0], coordinates[1],
	                        (int) mTouchOffsetX, (int) mTouchOffsetY, mDragView, mDragInfo);
	                mDragSource.onDropCompleted((View) dropTarget, true);
	                return true;
	            } else {
	                mDragSource.onDropCompleted((View) dropTarget, false);
	                return true;
	            }
	        }
	        return false;
	    }

	    private DropTarget findDropTarget(int x, int y, int[] dropCoordinates) {
	        final Rect r = mRectTemp;

	        final ArrayList<DropTarget> dropTargets = mDropTargets;
	        final int count = dropTargets.size();
	        for (int i=count-1; i>=0; i--) {
	            final DropTarget target = dropTargets.get(i);
	            target.getHitRect(r);
	            target.getLocationOnScreen(dropCoordinates);
	            r.offset(dropCoordinates[0] - target.getLeft(), dropCoordinates[1] - target.getTop());
	            if (r.contains(x, y)) {
	                dropCoordinates[0] = x - dropCoordinates[0];
	                dropCoordinates[1] = y - dropCoordinates[1];
	                return target;
	            }
	        }
	        return null;
	    }

	    /**
	     * Get the screen size so we can clamp events to the screen size so even if
	     * you drag off the edge of the screen, we find something.
	     */
	    private void recordScreenSize() {
	        ((WindowManager)mContext.getSystemService(Context.WINDOW_SERVICE))
	                .getDefaultDisplay().getMetrics(mDisplayMetrics);
	    }

	    /**
	     * Clamp val to be &gt;= min and &lt; max.
	     */
	    private static int clamp(int val, int min, int max) {
	        if (val < min) {
	            return min;
	        } else if (val >= max) {
	            return max - 1;
	        } else {
	            return val;
	        }
	    }

	    public void setWindowToken(IBinder token) {
	        mWindowToken = token;
	    }

	    /**
	     * Sets the drag listner which will be notified when a drag starts or ends.
	     */
	    public void setDragListener(DragListener l) {
	        mListener = l;
	    }

	    /**
	     * Remove a previously installed drag listener.
	     */
	    public void removeDragListener(DragListener l) {
	        mListener = null;
	    }

	    /**
	     * Add a DropTarget to the list of potential places to receive drop events.
	     */
	    public void addDropTarget(DropTarget target) {
	        mDropTargets.add(target);
	    }

	    /**
	     * Don't send drop events to <em>target</em> any more.
	     */
	    public void removeDropTarget(DropTarget target) {
	        mDropTargets.remove(target);
	    }


}
