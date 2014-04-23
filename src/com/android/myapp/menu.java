package com.android.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class menu extends Activity {
    /** Called when the activity is first created. */
	private Button vcard;
	private Button gcard;
	private Button wcard;
	private Button ocard;
	private Button help;
	private Button exit;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        this.vcard = (Button)this.findViewById(R.id.vcard);
        this.vcard.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(menu.this,vcard.class));
            finish();
          }
        });
        this.gcard = (Button)this.findViewById(R.id.gcard);
        this.gcard.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(menu.this,gcard.class));
            finish();
          }
        });
        this.wcard = (Button)this.findViewById(R.id.wcard);
        this.wcard.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(menu.this,wcard.class));
            finish();
          }
        });
        this.ocard = (Button)this.findViewById(R.id.ocard);
        this.ocard.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(menu.this,ocard.class));
            finish();
          }
        });
        this.help = (Button)this.findViewById(R.id.help);
        this.help.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(menu.this,help.class));
            finish();
          }
        });
        this.exit = (Button)this.findViewById(R.id.exit);
        this.exit.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  
            finish();
            System.exit(0);
          }
        });
    }
}