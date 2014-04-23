package com.android.myapp;

import android.view.View;



public interface DragSource {
	 void setDragController(DragController dragger);
	    void onDropCompleted(View target, boolean success);
}
