package com.android.myapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class help extends Activity {
    /** Called when the activity is first created. */
	private Button back;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.help);
        this.back = (Button)this.findViewById(R.id.htempb);
        this.back.setOnClickListener(new OnClickListener() {
          @Override
          public void onClick(View v) {
        	  startActivity(new Intent(help.this,menu.class));
            finish();
          }
        });
    }
}