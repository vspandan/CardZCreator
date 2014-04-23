package com.android.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class gcard extends Activity {
    /** Called when the activity is first created. */
	private Button back;
	private Button help;
	private Button gtemp1;
	private Button gtemp2;
	private Button gtemp3;
	private Button gtemp4;
	private Button gtemp5;
	private Button gtemp6;
	private Button gtemp7;
	private Button gtemp8;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gcard);
        this.back = (Button)this.findViewById(R.id.gtempb);
        this.back.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(gcard.this,menu.class));
            finish();
          }
        });
        this.help = (Button)this.findViewById(R.id.gtemph);
        this.help.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(gcard.this,help.class));
            finish();
          }
        });
        this.gtemp1 = (Button)this.findViewById(R.id.gtemp1);
        this.gtemp1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","one");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp2 = (Button)this.findViewById(R.id.gtemp2);
        this.gtemp2.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","two");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp3 = (Button)this.findViewById(R.id.gtemp3);
        this.gtemp3.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","three");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp4 = (Button)this.findViewById(R.id.gtemp4);
        this.gtemp4.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","four");
        	  
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp5 = (Button)this.findViewById(R.id.gtemp5);
        this.gtemp5.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","five");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp6 = (Button)this.findViewById(R.id.gtemp6);
        this.gtemp6.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","six");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp7 = (Button)this.findViewById(R.id.gtemp7);
        this.gtemp7.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","seven");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.gtemp8 = (Button)this.findViewById(R.id.gtemp8);
        this.gtemp8.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","eight");
        	  Intent newIntent = new Intent(gcard.this,gtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        
    }
}