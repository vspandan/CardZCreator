package com.android.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class myappmain extends Activity {
    /** Called when the activity is first created. */
	private Button conti;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome);
        this.conti = (Button)this.findViewById(R.id.cont);
        this.conti.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(myappmain.this,menu.class));
            finish();
          }
        });
        
    }
}