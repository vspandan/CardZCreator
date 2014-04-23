package com.android.myapp;

import java.io.File;
import java.io.FileOutputStream;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;


public class ocard extends Activity implements OnLongClickListener , OnClickListener
{
    /** Called when the activity is first created. */
	private DragController mDragController;   
	private DragLayer mDragLayer;            

	public static final boolean Debugging = true;
	
	private final static int SET_HEIGHT=101;
	private final static int SET_WIDTH=102;
	private final static int SET_TEXT_FONT=103;
	private final static int SET_TEXT_SIZE=104;
	private final static int SET_TEXT_COLOR=105;
	private final static int SET_TEXT_STYLE=106;
	
	private final static int HONE=201;
	private final static int HTWO=202;
	private final static int HTHREE=203;
	private final static int HFOUR=204;
	private final static int HFIVE=205;
	private final static int HSIX=206;
	private final static int HSEVEN=207;
	private final static int HEIGHT=208;
	private final static int HNINE=209;
	private final static int HTEN=210;
	private final static int HELEVEN=211;
	private final static int HTWELVE=212;
	private final static int HTHIRTEEN=213;
	private final static int HFOURTEEN=214;
	private final static int HFIFTEEN=215;
	private final static int HSIXTEEN=216;
	private final static int HSEVENTEEN=217;
	private final static int HEIGHTEEN=218;
	private final static int HNINETEEN=219;
	private final static int HTWENTY=220;
	private final static int HTWENTYONE=221;
	private final static int HTWENTYTWO=222;
	private final static int HTWENTYTHREE=223;
	private final static int HTWENTYFOUR=224;
	private final static int HTWENTYFIVE=225;
	
	private final static int WONE=301;
	private final static int WTWO=302;
	private final static int WTHREE=303;
	private final static int WFOUR=304;
	private final static int WFIVE=305;
	private final static int WSIX=306;
	private final static int WSEVEN=307;
	private final static int WEIGHT=308;
	private final static int WNINE=309;
	private final static int WTEN=310;
	private final static int WELEVEN=311;
	private final static int WTWELVE=312;
	private final static int WTHIRTEEN=313;
	private final static int WFOURTEEN=314;
	private final static int WFIFTEEN=315;
	private final static int WSIXTEEN=316;
	private final static int WSEVENTEEN=317;
	private final static int WEIGHTEEN=318;
	private final static int WNINETEEN=319;
	private final static int WTWENTY=320;
	private final static int WTWENTYONE=321;
	private final static int WTWENTYTWO=322;
	private final static int WTWENTYTHREE=323;
	private final static int WTWENTYFOUR=324;
	private final static int WTWENTYFIVE=325;
	
	private final static int IHONE=801;
	private final static int IHTWO=802;
	private final static int IHTHREE=803;
	private final static int IHFOUR=804;
	private final static int IHFIVE=805;
	private final static int IHSIX=806;
	private final static int IHSEVEN=807;
	private final static int IHEIGHT=808;
	private final static int IHNINE=809;
	private final static int IHTEN=810;
	private final static int IHELEVEN=811;
	private final static int IHTWELVE=812;
	private final static int IHTHIRTEEN=813;
	private final static int IHFOURTEEN=814;
	private final static int IHFIFTEEN=815;
	private final static int IHSIXTEEN=816;
	private final static int IHSEVENTEEN=817;
	private final static int IHEIGHTEEN=818;
	private final static int IHNINETEEN=819;
	private final static int IHTWENTY=820;
	private final static int IHTWENTYONE=821;
	private final static int IHTWENTYTWO=822;
	private final static int IHTWENTYTHREE=823;
	private final static int IHTWENTYFOUR=824;
	private final static int IHTWENTYFIVE=825;
	
	private final static int IWONE=901;
	private final static int IWTWO=902;
	private final static int IWTHREE=903;
	private final static int IWFOUR=904;
	private final static int IWFIVE=905;
	private final static int IWSIX=906;
	private final static int IWSEVEN=907;
	private final static int IWEIGHT=908;
	private final static int IWNINE=909;
	private final static int IWTEN=910;
	private final static int IWELEVEN=911;
	private final static int IWTWELVE=912;
	private final static int IWTHIRTEEN=913;
	private final static int IWFOURTEEN=914;
	private final static int IWFIFTEEN=915;
	private final static int IWSIXTEEN=916;
	private final static int IWSEVENTEEN=917;
	private final static int IWEIGHTEEN=918;
	private final static int IWNINETEEN=919;
	private final static int IWTWENTY=920;
	private final static int IWTWENTYONE=921;
	private final static int IWTWENTYTWO=922;
	private final static int IWTWENTYTHREE=923;
	private final static int IWTWENTYFOUR=924;
	private final static int IWTWENTYFIVE=925;
	
	private final static int TIMES_NEW_ROMAN=401;
	private final static int ARIAL=402;
	private final static int COURIER=403;
	private final static int ODESSA=404;
	private final static int GOTHIC=405;
	private final static int CALIBRI=406;
	private final static int COMIC=407;
	private final static int EXPLETIVE_DELETED=408;
	private final static int GABRIOLA=409;
	private final static int IMPACT=410;
	private final static int LUCID=411;
	private final static int CORSIVA=412;
	private final static int SEGOE=413;
	private final static int TAHOMA=414;
	private final static int VERDANA=415;
	
	
	private final static int TONE=501;
	private final static int TTWO=502;
	private final static int TTHREE=503;
	private final static int TFOUR=504;
	private final static int TFIVE=505;
	private final static int TSIX=506;
	private final static int TSEVEN=507;
	private final static int TEIGHT=508;
	private final static int TNINE=509;
	private final static int TTEN=510;
	private final static int TELEVEN=511;
	private final static int TTWELVE=512;
	private final static int TTHIRTEEN=513;
	private final static int TFOURTEEN=514;
	private final static int TFIFTEEN=515;
	private final static int TSIXTEEN=516;
	private final static int TSEVENTEEN=517;
	private final static int TEIGHTEEN=518;
	private final static int TNINETEEN=519;
	private final static int TTWENTY=520;
	private final static int TTWENTYONE=521;
	private final static int TTWENTYTWO=522;
	private final static int TTWENTYTHREE=523;
	private final static int TTWENTYFOUR=524;
	private final static int TTWENTYFIVE=525;
	
	private final static int BLK=601;
	private final static int WHT=602;
	private final static int RD=603;
	private final static int GRN=604;
	private final static int BLU=605;
	private final static int CYN=606;
	private final static int GRY=607;
	private final static int LGRY=608;
	private final static int DGRY=609;
	private final static int MGNT=610;
	private final static int YELW=611;
	
	private final static int BOLD=701;
	private final static int ITALIC=702;
	private final static int BOLD_ITALIC=703;
	private final static int NORMAL=704;
	
	
	private Uri imageuri;
	private DragLayer.LayoutParams params;
    final EditText[] et=new EditText[10];
	final ImageView[] iv=new ImageView[10];
	int i=0;
	int j=0;
	int z=0;
	int w=0;
	
    @Override
    public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ocard);
        final Dialog dialog = new Dialog(ocard.this);
    	LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);
    	LinearLayout l=new LinearLayout(ocard.this);
    	l.setOrientation(LinearLayout.VERTICAL);
    	Button b1=new Button(ocard.this);
    	b1.setLayoutParams(params2);
    	b1.setText("visiting card (1.42)");
    	l.addView(b1);
    	Button b2=new Button(ocard.this);
    	b2.setLayoutParams(params2);
    	b2.setText("Greeting card (1.77)");
    	l.addView(b2);
    	Button b3=new Button(ocard.this);
    	b3.setLayoutParams(params2);
    	b3.setText("Wedding card (1.50)");
    	l.addView(b3);
    	dialog.setContentView(l);
    	dialog.setTitle("Choose Resolution");
    	dialog.show();
    	b1.setOnClickListener(new OnClickListener(){
    		@Override 
    		public void onClick(View v)
    		{
    			 RelativeLayout.LayoutParams p=new RelativeLayout.LayoutParams(384,270);
    		        mDragLayer.setLayoutParams(p);
    		        w=1;
    			dialog.dismiss();
    		}
    		});
    	b2.setOnClickListener(new OnClickListener(){
    		@Override 
    		public void onClick(View v)
    		{
    			 RelativeLayout.LayoutParams p=new RelativeLayout.LayoutParams(480,270);
    		        mDragLayer.setLayoutParams(p);
    		        w=2;
    			dialog.dismiss();
    		}
    		});
    	
    	b3.setOnClickListener(new OnClickListener(){
    		@Override 
    		public void onClick(View v)
    		{
    			 RelativeLayout.LayoutParams p=new RelativeLayout.LayoutParams(405,270);
    		        mDragLayer.setLayoutParams(p);
    		        w=3;
    			dialog.dismiss();
    		}
    		}); 

        mDragController = new DragController(this);
        DragController dragController = mDragController;
        mDragLayer = (DragLayer) findViewById(R.id.abs);
        mDragLayer.setDragController(dragController);
        dragController.addDropTarget (mDragLayer);
        params=new DragLayer.LayoutParams(100,50,60,60); 
       
    }
    @Override
	public boolean onCreateOptionsMenu(Menu menu) {
	     MenuInflater inflater = getMenuInflater();
	     inflater.inflate(R.menu.menu2, menu);
	     return true;
	 }
    @Override
	public boolean onOptionsItemSelected(MenuItem item) {
	     switch (item.getItemId()) {
	         case R.id.addtext: 
	        	 et[i]=new EditText(ocard.this);
	        	  et[i].setLayoutParams(params);
	      		 et[i].setText("ashish");
	      		 et[i].setBackgroundColor(0);
	      		mDragLayer.addView(et[i]);
	        	  registerForContextMenu(et[i]);
	        	  et[i].setOnLongClickListener(ocard.this);
	        	  et[i].setOnClickListener(ocard.this);
	        	  i++;
	        	  break;
	         case R.id.addimage: 
	        	 iv[j]=new ImageView(ocard.this);
	        	  mDragLayer.addView(iv[j]);
	        	  iv[j].setLayoutParams(params);
	        	  iv[j].setFocusable(true);
	        	  registerForContextMenu(iv[j]);
	        	  iv[j].setOnLongClickListener(ocard.this);
	        	  iv[j].setOnClickListener(ocard.this);
	              startActivityForResult(new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI), 100);
	              break;
	         case R.id.back:
	        	 final Dialog dialog = new Dialog(ocard.this);
 	 			LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);
 	 			LinearLayout l=new LinearLayout(ocard.this);
 	 			l.setOrientation(LinearLayout.VERTICAL);
 	 			TextView t1=new TextView(ocard.this);
 	 			t1.setLayoutParams(params2);
 	 			t1.setText("Sure? Any unsaved");
 	 			l.addView(t1);
 	 			TextView t2=new TextView(ocard.this);
 	 			t2.setLayoutParams(params2);
 	 			t2.setText("data will be lost ");
 	 			l.addView(t2);
 	 			final Button b1=new Button(ocard.this);
 	 			b1.setLayoutParams(params2);
 	 			b1.setText("Back");
 	 			l.addView(b1);
 	 			dialog.setContentView(l);
 	 			dialog.setTitle("Back");
 	 			dialog.show();
 	 			b1.setOnClickListener(new OnClickListener(){
 	 				@Override 
 	 				public void onClick(View v)
 	 				{
 	 					dialog.dismiss();
 	 					startActivity(new Intent(ocard.this,menu.class));
 	 					finish();
 	 				}
 	 			});
 	 			break;
	         case R.id.save: 
	        	 final Dialog dialog3 = new Dialog(ocard.this);
	          	LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);
	         	LinearLayout l3=new LinearLayout(ocard.this);
	         	l3.setOrientation(LinearLayout.VERTICAL);
	         	final EditText q3=new EditText(ocard.this);
	         	q3.setLayoutParams(params3);
	         	l3.addView(q3);
	         	final Button b3=new Button(ocard.this);
	         	b3.setLayoutParams(params3);
	         	b3.setText("Save as PNG");
	         	l3.addView(b3);
	         	final Button b4=new Button(ocard.this);
	         	b4.setLayoutParams(params3);
	         	b4.setText("Save as JPEG");
	         	l3.addView(b4);
	         	dialog3.setContentView(l3);
	         	dialog3.setTitle("Save Image As");
	         	dialog3.show();
	         	b3.setOnClickListener(new OnClickListener(){
	         		@Override
	         		public void onClick(View v2){
	         			String filename=q3.getText().toString();
	         			if(filename.length()<=1)
	         				return;
	         			Bitmap screenBitmap = Bitmap.createBitmap(mDragLayer.getMeasuredWidth(),mDragLayer.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
	         				Canvas canvas = new Canvas(screenBitmap);
	         				mDragLayer.draw(canvas);
	         				Bitmap screenBitmap2;
	         				
	         				if(w==1)
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 768, 540, true);
	         				else if(w==2)
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 960, 540, true);
	         				else if(w==3)
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 810, 540, true);
	         				else
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 480, 270, true);
	         				
	                         	try{
	                         		String state = Environment.getExternalStorageState();
	                         		Log.i("state",state);
	                         			String path = Environment.getExternalStorageDirectory().toString();
	                         			FileOutputStream fOut = null;
	                         			File file = new File(path,filename+".png");
	                         			fOut = new FileOutputStream(file);
	                         			screenBitmap2.compress(Bitmap.CompressFormat.PNG, 100, fOut);
	                         			fOut.flush();
	                         			fOut.close();
	                         			MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
	                         			dialog3.dismiss();
	                         		}
	                         	catch(Exception e)
	                         	{
	                         		Log.i("exception",e.toString());
	                         	} 
	         			
	         		}
	         	});
	         	b4.setOnClickListener(new OnClickListener(){
	         		@Override
	         		public void onClick(View v2){
	         			String filename=q3.getText().toString();
	         			if(filename.length()<=1)
	         				return;
	         			Bitmap screenBitmap = Bitmap.createBitmap(mDragLayer.getMeasuredWidth(),mDragLayer.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
	         				Canvas canvas = new Canvas(screenBitmap);
	         				mDragLayer.draw(canvas);
	         				Bitmap screenBitmap2;
	         				
	         				if(w==1)
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 768, 540, true);
	         				else if(w==2)
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 960, 540, true);
	         				else if(w==3)
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 810, 540, true);
	         				else
	         					screenBitmap2=Bitmap.createScaledBitmap(screenBitmap, 480, 270, true);
	         				
	                         	try{
	                         		String state = Environment.getExternalStorageState();
	                         		Log.i("state",state);
	                         			String path = Environment.getExternalStorageDirectory().toString();
	                         			FileOutputStream fOut = null;
	                         			File file = new File(path,filename+".jpeg");
	                         			fOut = new FileOutputStream(file);
	                         			screenBitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
	                         			fOut.flush();
	                         			fOut.close();
	                         			MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
	                         			dialog3.dismiss();
	                         		}
	                         	catch(Exception e)
	                         	{
	                         		Log.i("exception",e.toString());
	                         	} 
	         			
	         		}
	         	});
	 	       break;
	     }
	     return true;
    }
    @Override
	public
    void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){

    	super.onCreateContextMenu(menu, v, menuInfo);
    	v.requestFocus();
    	if(v instanceof ImageView)
    	{
    		for(z=0;z<j;z++)
    		{
    			if(iv[z]==v)
    			{
    				break;
    			}
    			else
    			{
    				Log.i("no match",""+z);
    			}
    				
    		}
    		SubMenu set_height = menu.addSubMenu(0, SET_HEIGHT, 0, "Set Height");
        	SubMenu set_width = menu.addSubMenu(0, SET_WIDTH, 0, "Set Width");
        	
        	set_height.add(0,IHONE,0,"1");
        	set_height.add(0,IHTWO,0,"2");
        	set_height.add(0,IHTHREE,0,"3");
        	set_height.add(0,IHFOUR,0,"4");
        	set_height.add(0,IHFIVE,0,"5");
        	set_height.add(0,IHSIX,0,"6");
        	set_height.add(0,IHSEVEN,0,"7");
        	set_height.add(0,IHEIGHT,0,"8");
        	set_height.add(0,IHNINE,0,"9");
        	set_height.add(0,IHTEN,0,"10");
        	set_height.add(0,IHELEVEN,0,"11");
        	set_height.add(0,IHTWELVE,0,"12");
        	set_height.add(0,IHTHIRTEEN,0,"13");
        	set_height.add(0,IHFOURTEEN,0,"14");
        	set_height.add(0,IHFIFTEEN,0,"15");
        	set_height.add(0,IHSIXTEEN,0,"16");
        	set_height.add(0,IHSEVENTEEN,0,"17");
        	set_height.add(0,IHEIGHTEEN,0,"18");
        	set_height.add(0,IHNINETEEN,0,"19");
        	set_height.add(0,IHTWENTY,0,"20");
        	set_height.add(0,IHTWENTYONE,0,"21");
        	set_height.add(0,IHTWENTYTWO,0,"22");
        	set_height.add(0,IHTWENTYTHREE,0,"23");
        	set_height.add(0,IHTWENTYFOUR,0,"24");
        	set_height.add(0,IHTWENTYFIVE,0,"25");
        	
        	set_width.add(0,IWONE,0,"1");
        	set_width.add(0,IWTWO,0,"2");
        	set_width.add(0,IWTHREE,0,"3");
        	set_width.add(0,IWFOUR,0,"4");
        	set_width.add(0,IWFIVE,0,"5");
        	set_width.add(0,IWSIX,0,"6");
        	set_width.add(0,IWSEVEN,0,"7");
        	set_width.add(0,IWEIGHT,0,"8");
        	set_width.add(0,IWNINE,0,"9");
        	set_width.add(0,IWTEN,0,"10");
        	set_width.add(0,IWELEVEN,0,"11");
        	set_width.add(0,IWTWELVE,0,"12");
        	set_width.add(0,IWTHIRTEEN,0,"13");
        	set_width.add(0,IWFOURTEEN,0,"14");
        	set_width.add(0,IWFIFTEEN,0,"15");
        	set_width.add(0,IWSIXTEEN,0,"16");
        	set_width.add(0,IWSEVENTEEN,0,"17");
        	set_width.add(0,IWEIGHTEEN,0,"18");
        	set_width.add(0,IWNINETEEN,0,"19");
        	set_width.add(0,IWTWENTY,0,"20");
        	set_width.add(0,IWTWENTYONE,0,"21");
        	set_width.add(0,IWTWENTYTWO,0,"22");
        	set_width.add(0,IWTWENTYTHREE,0,"23");
        	set_width.add(0,IWTWENTYFOUR,0,"24");
        	set_width.add(0,IWTWENTYFIVE,0,"25");
    	}
    	else
    	{
    	SubMenu set_height = menu.addSubMenu(0, SET_HEIGHT, 0, "Set Height");
    	SubMenu set_width = menu.addSubMenu(0, SET_WIDTH, 0, "Set Width");
    	
    	set_height.add(0,HONE,0,"1");
    	set_height.add(0,HTWO,0,"2");
    	set_height.add(0,HTHREE,0,"3");
    	set_height.add(0,HFOUR,0,"4");
    	set_height.add(0,HFIVE,0,"5");
    	set_height.add(0,HSIX,0,"6");
    	set_height.add(0,HSEVEN,0,"7");
    	set_height.add(0,HEIGHT,0,"8");
    	set_height.add(0,HNINE,0,"9");
    	set_height.add(0,HTEN,0,"10");
    	set_height.add(0,HELEVEN,0,"11");
    	set_height.add(0,HTWELVE,0,"12");
    	set_height.add(0,HTHIRTEEN,0,"13");
    	set_height.add(0,HFOURTEEN,0,"14");
    	set_height.add(0,HFIFTEEN,0,"15");
    	set_height.add(0,HSIXTEEN,0,"16");
    	set_height.add(0,HSEVENTEEN,0,"17");
    	set_height.add(0,HEIGHTEEN,0,"18");
    	set_height.add(0,HNINETEEN,0,"19");
    	set_height.add(0,HTWENTY,0,"20");
    	set_height.add(0,HTWENTYONE,0,"21");
    	set_height.add(0,HTWENTYTWO,0,"22");
    	set_height.add(0,HTWENTYTHREE,0,"23");
    	set_height.add(0,HTWENTYFOUR,0,"24");
    	set_height.add(0,HTWENTYFIVE,0,"25");
    	
    	set_width.add(0,WONE,0,"1");
    	set_width.add(0,WTWO,0,"2");
    	set_width.add(0,WTHREE,0,"3");
    	set_width.add(0,WFOUR,0,"4");
    	set_width.add(0,WFIVE,0,"5");
    	set_width.add(0,WSIX,0,"6");
    	set_width.add(0,WSEVEN,0,"7");
    	set_width.add(0,WEIGHT,0,"8");
    	set_width.add(0,WNINE,0,"9");
    	set_width.add(0,WTEN,0,"10");
    	set_width.add(0,WELEVEN,0,"11");
    	set_width.add(0,WTWELVE,0,"12");
    	set_width.add(0,WTHIRTEEN,0,"13");
    	set_width.add(0,WFOURTEEN,0,"14");
    	set_width.add(0,WFIFTEEN,0,"15");
    	set_width.add(0,WSIXTEEN,0,"16");
    	set_width.add(0,WSEVENTEEN,0,"17");
    	set_width.add(0,WEIGHTEEN,0,"18");
    	set_width.add(0,WNINETEEN,0,"19");
    	set_width.add(0,WTWENTY,0,"20");
    	set_width.add(0,WTWENTYONE,0,"21");
    	set_width.add(0,WTWENTYTWO,0,"22");
    	set_width.add(0,WTWENTYTHREE,0,"23");
    	set_width.add(0,WTWENTYFOUR,0,"24");
    	set_width.add(0,WTWENTYFIVE,0,"25");
    	
    	SubMenu set_text_font = menu.addSubMenu(0, SET_TEXT_FONT, 0, "Set Text Font");
    	SubMenu set_text_size = menu.addSubMenu(0, SET_TEXT_SIZE, 0, "Set Text Size");
    	SubMenu set_text_color = menu.addSubMenu(0, SET_TEXT_COLOR, 0, "Set Text Color");
    	SubMenu set_text_style = menu.addSubMenu(0, SET_TEXT_STYLE, 0, "Set Text Style");

    	
    	set_text_font.add(0,TIMES_NEW_ROMAN,0,"Times New Roman");
    	set_text_font.add(0,ARIAL,0,"Arial");
    	set_text_font.add(0,COURIER,0,"Courier");
    	set_text_font.add(0,ODESSA,0,"Odessa Script");
    	set_text_font.add(0,GOTHIC,0,"Gothic");
    	set_text_font.add(0,CALIBRI,0,"Calibri");
    	set_text_font.add(0,COMIC,0,"Comic");
    	set_text_font.add(0,EXPLETIVE_DELETED,0,"Expletive Deleted");
    	set_text_font.add(0,GABRIOLA,0,"Gabriola");
    	set_text_font.add(0,IMPACT,0,"Impact");
    	set_text_font.add(0,LUCID,0,"Lucid");
    	set_text_font.add(0,CORSIVA,0,"Corsiva");
    	set_text_font.add(0,SEGOE,0,"Segoe");
    	set_text_font.add(0,TAHOMA,0,"Tahoma");
    	set_text_font.add(0,VERDANA,0,"Verdana");
    	
    	set_text_size.add(0,TONE,0,"1");
    	set_text_size.add(0,TTWO,0,"2");
    	set_text_size.add(0,TTHREE,0,"3");
    	set_text_size.add(0,TFOUR,0,"4");
    	set_text_size.add(0,TFIVE,0,"5");
    	set_text_size.add(0,TSIX,0,"6");
    	set_text_size.add(0,TSEVEN,0,"7");
    	set_text_size.add(0,TEIGHT,0,"8");
    	set_text_size.add(0,TNINE,0,"9");
    	set_text_size.add(0,TTEN,0,"10");
    	set_text_size.add(0,TELEVEN,0,"11");
    	set_text_size.add(0,TTWELVE,0,"12");
    	set_text_size.add(0,TTHIRTEEN,0,"13");
    	set_text_size.add(0,TFOURTEEN,0,"14");
    	set_text_size.add(0,TFIFTEEN,0,"15");
    	set_text_size.add(0,TSIXTEEN,0,"16");
    	set_text_size.add(0,TSEVENTEEN,0,"17");
    	set_text_size.add(0,TEIGHTEEN,0,"18");
    	set_text_size.add(0,TNINETEEN,0,"19");
    	set_text_size.add(0,TTWENTY,0,"20");
    	set_text_size.add(0,TTWENTYONE,0,"21");
    	set_text_size.add(0,TTWENTYTWO,0,"22");
    	set_text_size.add(0,TTWENTYTHREE,0,"23");
    	set_text_size.add(0,TTWENTYFOUR,0,"24");
    	set_text_size.add(0,TTWENTYFIVE,0,"25");
    	
    	set_text_color.add(0,BLK,0,"Black");
    	set_text_color.add(0,WHT,0,"White");
    	set_text_color.add(0,RD,0,"Red");
    	set_text_color.add(0,GRN,0,"Green");
    	set_text_color.add(0,BLU,0,"Blue");
    	set_text_color.add(0,CYN,0,"Cyan");
    	set_text_color.add(0,YELW,0,"Yellow");
    	set_text_color.add(0,MGNT,0,"Magenta");
    	set_text_color.add(0,GRY,0,"Gray");
    	set_text_color.add(0,LGRY,0,"Light Gray");
    	set_text_color.add(0,DGRY,0,"Dark Gray");

    	set_text_style.add(0,BOLD,0,"Bold");
    	set_text_style.add(0,ITALIC,0,"Italic");
    	set_text_style.add(0,BOLD_ITALIC,0,"Bold Italic");
    	set_text_style.add(0,NORMAL,0,"Default");
    	}
    }
    @Override
    public boolean onContextItemSelected (MenuItem item) {

    	int k=0,l=z;
    		for(k=0;k<i;k++)
    			if(et[k].hasFocus())
    				break ;
    		
    	switch (item.getItemId())
    	{
    		case HONE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),10,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWO:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),20,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTHREE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),30,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HFOUR:
       			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),40,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HFIVE: 			
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),50,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HSIX:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),60,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HSEVEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),70,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HEIGHT:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),80,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HNINE:
       			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),90,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTEN: 			
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),100,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HELEVEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),110,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWELVE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),120,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTHIRTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),130,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HFOURTEEN:
       			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),140,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HFIFTEEN: 			
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),150,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HSIXTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),160,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HSEVENTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),170,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HEIGHTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),180,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HNINETEEN:
       			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),190,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWENTY: 			
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),200,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWENTYONE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),210,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWENTYTWO:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),220,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWENTYTHREE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),230,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWENTYFOUR:
       			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),240,et[k].getLeft(),et[k].getTop()));
    			return true;
    		case HTWENTYFIVE: 			
    			et[k].setLayoutParams( new DragLayer.LayoutParams(et[k].getMeasuredWidth(),250,et[k].getLeft(),et[k].getTop()));
    			return true;
    			
    		case IHONE:
				iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),10,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWO:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),20,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTHREE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),30,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHFOUR:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),40,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHFIVE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),50,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHSIX:
				iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),60,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHSEVEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),70,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHEIGHT:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),80,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHNINE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),90,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),100,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHELEVEN:
				iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),110,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWELVE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),120,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTHIRTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),130,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHFOURTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),140,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHFIFTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),150,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHSIXTEEN:
				iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),160,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHSEVENTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),170,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHEIGHTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),180,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHNINETEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),190,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWENTY:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),200,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWENTYONE:
				iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),210,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWENTYTWO:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),220,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWENTYTHREE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),230,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWENTYFOUR:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),240,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IHTWENTYFIVE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(iv[l].getMeasuredWidth(),250,iv[l].getLeft(),iv[l].getTop()));
    			return true;
    			
    		case WONE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(10,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWO:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(20,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTHREE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(30,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WFOUR:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(40,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WFIVE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(50,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WSIX:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(60,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WSEVEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(70,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WEIGHT:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(80,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WNINE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(90,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(100,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WELEVEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(110,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWELVE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(120,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTHIRTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(130,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WFOURTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(140,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WFIFTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(150,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WSIXTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(160,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WSEVENTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(170,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WEIGHTEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(180,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WNINETEEN:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(190,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWENTY:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(200,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWENTYONE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(210,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWENTYTWO:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(220,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWENTYTHREE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(230,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWENTYFOUR:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(240,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    		case WTWENTYFIVE:
    			et[k].setLayoutParams( new DragLayer.LayoutParams(250,et[k].getMeasuredHeight(),et[k].getLeft(),et[k].getTop()));
    			return true;
    			
    		case IWONE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(10,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWO:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(20,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTHREE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(30,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWFOUR:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(40,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWFIVE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(50,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWSIX:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(60,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWSEVEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(70,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWEIGHT:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(80,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWNINE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(90,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(100,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWELEVEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(110,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWELVE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(120,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTHIRTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(130,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWFOURTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(140,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWFIFTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(150,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWSIXTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(160,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWSEVENTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(170,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWEIGHTEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(180,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWNINETEEN:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(190,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWENTY:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(200,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWENTYONE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(210,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWENTYTWO:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(220,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWENTYTHREE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(230,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWENTYFOUR:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(240,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;
    		case IWTWENTYFIVE:
    			iv[l].setLayoutParams( new DragLayer.LayoutParams(250,iv[l].getMeasuredHeight(),iv[l].getLeft(),iv[l].getTop()));
    			return true;

    		case TONE:
    			et[k].setTextSize(2);
    			return true;
    		case TTWO:
    			et[k].setTextSize(4);
    			return true;
    		case TTHREE:
    			et[k].setTextSize(6);
    			return true;
    		case TFOUR:
    			et[k].setTextSize(8);
    			return true;
    		case TFIVE:
    			et[k].setTextSize(10);
    			return true;
    		case TSIX:
    			et[k].setTextSize(12);
    			return true;
    		case TSEVEN:
    			et[k].setTextSize(14);
    			return true;
    		case TEIGHT:
    			et[k].setTextSize(16);
    			return true;
    		case TNINE:
    			et[k].setTextSize(18);
    			return true;
    		case TTEN:
    			et[k].setTextSize(20);
    			return true;
    		case TELEVEN:
    			et[k].setTextSize(22);
    			return true;
    		case TTWELVE:
    			et[k].setTextSize(24);
    			return true;
    		case TTHIRTEEN:
    			et[k].setTextSize(26);
    			return true;
    		case TFOURTEEN:
    			et[k].setTextSize(28);
    			return true;
    		case TFIFTEEN:
    			et[k].setTextSize(30);
    			return true;
    		case TSIXTEEN:
    			et[k].setTextSize(32);
    			return true;
    		case TSEVENTEEN:
    			et[k].setTextSize(34);
    			return true;
    		case TEIGHTEEN:
    			et[k].setTextSize(36);
    			return true;
    		case TNINETEEN:
    			et[k].setTextSize(38);
    			return true;
    		case TTWENTY:
    			et[k].setTextSize(40);
    			return true;
    		case TTWENTYONE:
    			et[k].setTextSize(42);
    			return true;
    		case TTWENTYTWO:
    			et[k].setTextSize(44);
    			return true;
    		case TTWENTYTHREE:
    			et[k].setTextSize(46);
    			return true;
    		case TTWENTYFOUR:
    			et[k].setTextSize(48);
    			return true;
    		case TTWENTYFIVE:
    			et[k].setTextSize(50);
    			return true;
    			
    		case BLK:
    			et[k].setTextColor(Color.BLACK);
    			return true;
    		case WHT:
    			et[k].setTextColor(Color.WHITE);
    			return true;
    		case RD:
    			et[k].setTextColor(Color.RED);
    			return true;
    		case GRN:
    			et[k].setTextColor(Color.GREEN);
    			return true;
    		case BLU:
    			et[k].setTextColor(Color.BLUE);
    			return true;
    		case CYN:
    			et[k].setTextColor(Color.CYAN);
    			return true;
    		case GRY:
    			et[k].setTextColor(Color.GRAY);
    			return true;
    		case MGNT:
    			et[k].setTextColor(Color.MAGENTA);
    			return true;
    		case YELW:
    			et[k].setTextColor(Color.YELLOW);
    			return true;
    		case DGRY:
    			et[k].setTextColor(Color.DKGRAY);
    			return true;
    		case LGRY:
    			et[k].setTextColor(Color.LTGRAY);
    			return true;
    			
    		case BOLD:
    			et[k].setTypeface(Typeface.defaultFromStyle(Typeface.BOLD), Typeface.BOLD);
    			return true;
    		case ITALIC:
    			et[k].setTypeface(Typeface.defaultFromStyle(Typeface.ITALIC), Typeface.ITALIC);
    			return true;    			
    		case BOLD_ITALIC:
    			et[k].setTypeface(Typeface.defaultFromStyle(Typeface.BOLD_ITALIC), Typeface.BOLD_ITALIC);
    			return true;    			
    		case NORMAL:
    			et[k].setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL), Typeface.NORMAL);
    			return true;    			
    		
    		case TIMES_NEW_ROMAN:
    			Typeface font1=Typeface.createFromAsset(getAssets(), "Times_New_Roman.ttf");
    			et[k].setTypeface(font1);
    			return true;
    		case ARIAL:
    			Typeface font2=Typeface.createFromAsset(getAssets(), "ARIAL.TTF");
    			et[k].setTypeface(font2);
    			return true;
    		case COURIER:
    			Typeface font3=Typeface.createFromAsset(getAssets(), "Courier.ttf");
    			et[k].setTypeface(font3);
    			return true;
    		case ODESSA:
    			Typeface font4=Typeface.createFromAsset(getAssets(), "Odessa_Script.ttf");
    			et[k].setTypeface(font4);
    			return true;
    		case GOTHIC:
    			Typeface font5=Typeface.createFromAsset(getAssets(), "GothicRus_Medium.ttf");
    			et[k].setTypeface(font5);
    			return true;
    		case CALIBRI:
    			Typeface font6=Typeface.createFromAsset(getAssets(), "CALIBRI.TTF");
    			et[k].setTypeface(font6);
    			return true;
    		case COMIC:
    			Typeface font7=Typeface.createFromAsset(getAssets(), "COMIC.TTF");
    			et[k].setTypeface(font7);
    			return true;
    		case EXPLETIVE_DELETED:
    			Typeface font8=Typeface.createFromAsset(getAssets(), "expletivedeleted.ttf");
    			et[k].setTypeface(font8);
    			return true;
    		case GABRIOLA:
    			Typeface font9=Typeface.createFromAsset(getAssets(), "GABRIOLA.TTF");
    			et[k].setTypeface(font9);
    			return true;
    		case IMPACT:
    			Typeface font10=Typeface.createFromAsset(getAssets(), "IMPACT.TTF");
    			et[k].setTypeface(font10);
    			return true;
    		case LUCID:
    			Typeface font11=Typeface.createFromAsset(getAssets(), "lucon>ttf");
    			et[k].setTypeface(font11);
    			return true;
    		case CORSIVA:
    			Typeface font12=Typeface.createFromAsset(getAssets(), "MTCORSVA.TTF");
    			et[k].setTypeface(font12);
    			return true;
    		case SEGOE:
    			Typeface font13=Typeface.createFromAsset(getAssets(), "SEGOESC.TTF");
    			et[k].setTypeface(font13);
    			return true;
    		case TAHOMA:
    			Typeface font14=Typeface.createFromAsset(getAssets(),"TAHOMA.TTF");
    			et[k].setTypeface(font14);
    			return true;
    		case VERDANA:
    			Typeface font15=Typeface.createFromAsset(getAssets(), "VERDANA.TTF");
    			et[k].setTypeface(font15);
    			return true;
    	
    		default:
    			return true;
    	

    	 }

    	} 
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) 
    {
    	super.onActivityResult(requestCode, resultCode, data);
    	switch(requestCode) 
    	{
    		case 100: 
    			if(resultCode == Activity.RESULT_OK) 
    			{ 
    				imageuri = data.getData();
    				iv[j].setMaxHeight(40);
    				iv[j].setMaxWidth(40);
    				iv[j].setClickable(true);
    				iv[j].setImageURI(imageuri);
    				iv[j].setScaleType(ScaleType.FIT_XY);
    				j++;
    			}
    	}
    
    }
	@Override
	public boolean onLongClick(View v) {
		// TODO Auto-generated method stub
		if (!v.isInTouchMode()) {
		       return false;
		    }
		    return startDrag (v);
	}
	public boolean startDrag (View v)
	{
	    Object dragInfo = v;
	    mDragController.startDrag (v, mDragLayer, dragInfo, DragController.DRAG_ACTION_MOVE);
	    return true;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		v.showContextMenu();
		
	}
	
}



