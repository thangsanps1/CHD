package com.douglas.chd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.IOException;

import static com.douglas.chd.R.id.tuvi;

public class ActivityMain extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_main);
        getSupportActionBar().setElevation(0);
        //Typeface face= Typeface.createFromAsset(getAssets(), "fonts/myfont.ttf");
        SpannableString s = new SpannableString("Cung Hoàng Đạo");
        s.setSpan(new TypefaceSpan(this, "myfont.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        getSupportActionBar().setTitle(s);
    }

    public void xuNu(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Xử Nữ");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);

    }

    public void baoBinh(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Bảo Bình");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void cuGiai(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Cự Giải");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void kimNguu(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Kim Ngưu");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void maKet(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Ma Kết");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void nhanMa(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Nhân Mã");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void songNgu(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Song Ngư");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void songTu(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Song Tử");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void suTu(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Sư Tử");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void thienBinh(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Thiên Bình");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void thienYet(View v){
        Intent xn = new Intent(ActivityMain.this, ActivityContent.class);
        xn.putExtra("name", "Thiên Yết");
        startActivity(xn);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }

    public void bachDuong(View v){
        Intent bd = new Intent(ActivityMain.this, ActivityContent.class);
        bd.putExtra("name", "Bạch Dương");
        startActivity(bd);
        overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.about:
                Intent Itabout = new Intent(ActivityMain.this, ActivityAbout.class);
                startActivity(Itabout);
                overridePendingTransition(R.anim.from_middle, R.anim.to_middle);
            case  tuvi:
                Intent intent = new Intent(ActivityMain.this, Horoscope.class);
                startActivity(intent);
                overridePendingTransition(R.anim.from_middle, R.anim.to_middle);

        }
        return super.onOptionsItemSelected(item);
    }
    public boolean isOnline() {

        Runtime runtime = Runtime.getRuntime();
        try {

            Process ipProcess = runtime.exec("/system/bin/ping -c 1 8.8.8.8");
            int     exitValue = ipProcess.waitFor();
            return (exitValue == 0);

        } catch (IOException e)          { e.printStackTrace(); }
        catch (InterruptedException e) { e.printStackTrace(); }

        return false;
    }
}
