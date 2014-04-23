package com.android.myapp;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class gtemp1 extends Activity{
	private AbsoluteLayout abs;
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        Bundle bundle = this.getIntent().getExtras();
	        String temp = (String)bundle.get("template");
	        if(temp.equalsIgnoreCase("one"))
	        	setContentView(R.layout.gtemp1);
	        else if(temp.equalsIgnoreCase("two"))
	        	setContentView(R.layout.gtemp2);
	        else if(temp.equalsIgnoreCase("three"))
	        	setContentView(R.layout.gtemp3);
	        else if(temp.equalsIgnoreCase("four"))
	        	setContentView(R.layout.gtemp4);
	        else if(temp.equalsIgnoreCase("five"))
	        	setContentView(R.layout.gtemp5);
	        else if(temp.equalsIgnoreCase("six"))
	        	setContentView(R.layout.gtemp6);
	        else if(temp.equalsIgnoreCase("seven"))
	        	setContentView(R.layout.gtemp7);
	        else if(temp.equalsIgnoreCase("eight"))
	        	setContentView(R.layout.gtemp8);
	        abs=(AbsoluteLayout)findViewById(R.id.abslyt);
	 }
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	     MenuInflater inflater = getMenuInflater();
	     inflater.inflate(R.menu.menu, menu);
	     return true;
	 }
	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {
	     switch (item.getItemId()) {
	         case R.id.back:   
	        	 			final Dialog dialog = new Dialog(gtemp1.this);
	        	 			LinearLayout.LayoutParams params2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);
	        	 			LinearLayout l=new LinearLayout(gtemp1.this);
	        	 			l.setOrientation(LinearLayout.VERTICAL);
	        	 			TextView t1=new TextView(gtemp1.this);
	        	 			t1.setLayoutParams(params2);
	        	 			t1.setText("Sure? Any unsaved");
	        	 			l.addView(t1);
	        	 			TextView t2=new TextView(gtemp1.this);
	        	 			t2.setLayoutParams(params2);
	        	 			t2.setText("data will be lost ");
	        	 			l.addView(t2);
	        	 			final Button b1=new Button(gtemp1.this);
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
	        	 					startActivity(new Intent(gtemp1.this,gcard.class));
	        	 					finish();
	        	 				}
	        	 			});
	        	 			break;
	        	 			
	         case R.id.save:     final Dialog dialog3 = new Dialog(gtemp1.this);
         	LinearLayout.LayoutParams params3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);
        	LinearLayout l3=new LinearLayout(gtemp1.this);
        	l3.setOrientation(LinearLayout.VERTICAL);
        	final EditText q3=new EditText(gtemp1.this);
        	q3.setLayoutParams(params3);
        	l3.addView(q3);
        	final Button b3=new Button(gtemp1.this);
        	b3.setLayoutParams(params3);
        	b3.setText("Save as PNG");
        	l3.addView(b3);
        	final Button b4=new Button(gtemp1.this);
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
        			if(filename.length()<1)
        				return;
        			Bitmap screenBitmap = Bitmap.createBitmap(abs.getMeasuredWidth(),abs.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
        				Canvas canvas = new Canvas(screenBitmap);
        				abs.draw(canvas);
        			
        				
                        	try{
                        		String state = Environment.getExternalStorageState();
                        			String path = Environment.getExternalStorageDirectory().toString();
                        			FileOutputStream fOut = null;
                        			File file = new File(path,filename+".png");
                        			fOut = new FileOutputStream(file);
                        			screenBitmap.compress(Bitmap.CompressFormat.PNG, 100, fOut);
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
        			if(filename.length()<1)
        				return;
        			Bitmap screenBitmap = Bitmap.createBitmap(abs.getMeasuredWidth(),abs.getMeasuredHeight(),Bitmap.Config.ARGB_8888);
        				Canvas canvas = new Canvas(screenBitmap);
        				abs.draw(canvas);
        			
        				
                        	try{
                        		String state = Environment.getExternalStorageState();
                        			String path = Environment.getExternalStorageDirectory().toString();
                        			FileOutputStream fOut = null;
                        			File file = new File(path,filename+".jpeg");
                        			fOut = new FileOutputStream(file);
                        			screenBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
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
	         case R.id.help:     final Dialog dialog1 = new Dialog(gtemp1.this);
	 			LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT,0.0F);
	 			LinearLayout l1=new LinearLayout(gtemp1.this);
	 			l1.setOrientation(LinearLayout.VERTICAL);
	 			TextView t3=new TextView(gtemp1.this);
	 			t3.setLayoutParams(params);
	 			t3.setText("Sure? Any unsaved");
	 			l1.addView(t3);
	 			TextView t4=new TextView(gtemp1.this);
	 			t4.setLayoutParams(params);
	 			t4.setText("data will be lost ");
	 			l1.addView(t4);
	 			final Button b2=new Button(gtemp1.this);
	 			b2.setLayoutParams(params);
	 			b2.setText("Help");
	 			l1.addView(b2);
	 			dialog1.setContentView(l1);
	 			dialog1.setTitle("Help");
	 			dialog1.show();
	 			b2.setOnClickListener(new OnClickListener(){
	 				@Override 
	 				public void onClick(View v)
	 				{
	 					dialog1.dismiss();
	 					startActivity(new Intent(gtemp1.this,help.class));
	 					finish();
	 				}
	 			});
	 			break;
	     }
	     return true;
	 }

}

