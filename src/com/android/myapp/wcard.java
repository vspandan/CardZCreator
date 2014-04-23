package com.android.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class wcard extends Activity {
    /** Called when the activity is first created. */
	private Button back;
	private Button help;
	private Button wtemp1;
	private Button wtemp2;
	private Button wtemp3;
	private Button wtemp4;
	private Button wtemp5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wcard);
        this.back = (Button)this.findViewById(R.id.wtempb);
        this.back.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(wcard.this,menu.class));
            finish();
          }
        });
        this.help = (Button)this.findViewById(R.id.wtemph);
        this.help.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(wcard.this,help.class));
            finish();
          }
        });
        this.wtemp1 = (Button)this.findViewById(R.id.wtemp1);
        this.wtemp1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","one");
        	  Intent newIntent = new Intent(wcard.this,wtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.wtemp2 = (Button)this.findViewById(R.id.wtemp2);
        this.wtemp2.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","two");
        	  Intent newIntent = new Intent(wcard.this,wtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.wtemp3 = (Button)this.findViewById(R.id.wtemp3);
        this.wtemp3.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","three");
        	  Intent newIntent = new Intent(wcard.this,wtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.wtemp4 = (Button)this.findViewById(R.id.wtemp4);
        this.wtemp4.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","four");
        	  
        	  Intent newIntent = new Intent(wcard.this,wtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.wtemp5 = (Button)this.findViewById(R.id.wtemp5);
        this.wtemp5.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","five");
        	  Intent newIntent = new Intent(wcard.this,wtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
    }
}