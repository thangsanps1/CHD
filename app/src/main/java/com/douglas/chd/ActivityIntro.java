package com.douglas.chd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActivityIntro extends AppCompatActivity {
    private Thread splashThread;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_intro);
        getSupportActionBar().hide();
        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(1500);
                    }
                } catch (InterruptedException ex) {
                }

                finish();

                // Run next activity
                Intent intent = new Intent();
                intent.setClass(ActivityIntro.this,ActivityMain.class);
                startActivity(intent);
                overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
            }
        };

        splashThread.start();
    }
}
