package com.android.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class vcard extends Activity {
    /** Called when the activity is first created. */
	private Button back;
	private Button help;
	private Button vtemp1;
	private Button vtemp2;
	private Button vtemp3;
	private Button vtemp4;
	private Button vtemp5;
	private Button vtemp6;
	private Button vtemp7;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vcard);
        this.back = (Button)this.findViewById(R.id.tempb);
        this.back.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(vcard.this,menu.class));
            finish();
          }
        });
        this.help = (Button)this.findViewById(R.id.temph);
        this.help.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(vcard.this,help.class));
            finish();
          }
        });
        this.vtemp1 = (Button)this.findViewById(R.id.vtemp1);
        this.vtemp1.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","one");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.vtemp2 = (Button)this.findViewById(R.id.vtemp2);
        this.vtemp2.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","two");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.vtemp3 = (Button)this.findViewById(R.id.vtemp3);
        this.vtemp3.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","three");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.vtemp4 = (Button)this.findViewById(R.id.vtemp4);
        this.vtemp4.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","four");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.vtemp5 = (Button)this.findViewById(R.id.vtemp5);
        this.vtemp5.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","five");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.vtemp6 = (Button)this.findViewById(R.id.vtemp6);
        this.vtemp6.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","six");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
        this.vtemp7 = (Button)this.findViewById(R.id.vtemp7);
        this.vtemp7.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  Bundle bundle=new Bundle();
        	  bundle.putString("template","seven");
        	  Intent newIntent = new Intent(vcard.this,vtemp1.class);
        	  newIntent.putExtras(bundle);
        	  startActivityForResult(newIntent,0);
            finish();
          }
        });
    }
}