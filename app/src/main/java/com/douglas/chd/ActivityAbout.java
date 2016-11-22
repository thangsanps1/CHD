package com.douglas.chd;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityAbout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_about);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/myfont.ttf");
        TextView tv1 = (TextView)findViewById(R.id.tvAb1);
       TextView tv2 = (TextView)findViewById(R.id.tvAb2);
        tv1.setTypeface(face);
        tv2.setTypeface(face);
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
