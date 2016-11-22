package com.douglas.chd;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.douglas.chd.custom.CustomSpn;
import com.douglas.chd.custom.CustomSpnday;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ActivityContent extends AppCompatActivity {
    String name;
    String[] month12 = new String[]{"1", "2"};
    String[] month23 = new String[]{"2", "3"};
    String[] month34 = new String[]{"3", "4"};
    String[] month45 = new String[]{"4", "5"};
    String[] month56 = new String[]{"5", "6"};
    String[] month67 = new String[]{"6", "7"};
    String[] month78 = new String[]{"7", "8"};
    String[] month89 = new String[]{"8", "9"};
    String[] month910 = new String[]{"9", "10"};
    String[] month1011 = new String[]{"10", "11"};
    String[] month1112 = new String[]{"11", "12"};
    String[] month121 = new String[]{"12", "1"};

    ArrayList<String> day22d31 = new ArrayList<String>();
    ArrayList<String> day1d19 = new ArrayList<String>();
    ArrayList<String> day21d30 = new ArrayList<String>();
    ArrayList<String> day1d23 = new ArrayList<String>();
    ArrayList<String> day20d31 = new ArrayList<String>();
    ArrayList<String> day1d18 = new ArrayList<String>();
   ArrayList<String> day23d31 = new ArrayList<String>();
    ArrayList<String> day21d31 = new ArrayList<String>();
    ArrayList<String> day23d30 = new ArrayList<String>();
    ArrayList<String> day1d21 = new ArrayList<String>();
    ArrayList<String> day24d31 = new ArrayList<String>();
    ArrayList<String> day19d29 = new ArrayList<String>();
    ArrayList<String> day1d20 = new ArrayList<String>();
    ArrayList<String> day22d30 = new ArrayList<String>();
    ArrayList<String> day1d22 = new ArrayList<String>();

    TextView thangSinh;
    TextView ngaySinh;
    Spinner spnThang;
    Spinner spnNgay;
    Button xemButton;

    String chiTiet;
    String yNghia;
    String anh;
    TextView tvChitiet;
    TextView tvYNghia;
    ImageView imgAnh;
    TextView tvtt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_content);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        name = bd.getString("name");

        SpannableString s = new SpannableString("Cung Hoàng Đạo");
        s.setSpan(new TypefaceSpan(this, "myfont.ttf"), 0, s.length(),
                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        getSupportActionBar().setTitle(s);

        TabHost host = (TabHost)findViewById(R.id.tabHost);
        host.setup();

        final Typeface face= Typeface.createFromAsset(getAssets(), "fonts/myfont.ttf");

        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator(name);
        host.addTab(spec);
        TextView tv1 = (TextView) host.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        tv1.setTextSize(20);
        tv1.setTypeface(face);
        tv1.setTextColor(Color.parseColor("#ffffff"));

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Xem Mệnh");
        host.addTab(spec);
        TextView tv2 = (TextView) host.getTabWidget().getChildAt(1).findViewById(android.R.id.title);
        tv2.setTextSize(20);
        tv2.setTypeface(face);
        tv2.setTextColor(Color.parseColor("#ffffff"));

        thangSinh = (TextView) findViewById(R.id.tvThangSinh);
        ngaySinh = (TextView) findViewById(R.id.tvNgaySinh);
        spnThang = (Spinner) findViewById(R.id.spnThang);
        spnNgay = (Spinner) findViewById(R.id.spnNgay);
        xemButton = (Button) findViewById(R.id.btnXem);
        tvChitiet = (TextView) findViewById(R.id.tvChiTiet);
        tvYNghia = (TextView) findViewById(R.id.tvYnghia);
        imgAnh = (ImageView) findViewById(R.id.imgCung);
        tvtt = (TextView) findViewById(R.id.tvtt);

        thangSinh.setTypeface(face);
        ngaySinh.setTypeface(face);
        xemButton.setTypeface(face);
        tvChitiet.setTypeface(face);
        tvYNghia.setTypeface(face);
        tvtt.setTypeface(face);

        for(int i=1; i<=18; i++){day1d18.add(String.valueOf(i));}
        for(int i=1; i<=19; i++){day1d19.add(String.valueOf(i));}
        for(int i=1; i<=20; i++){day1d20.add(String.valueOf(i));}
        for(int i=1; i<=21; i++){day1d21.add(String.valueOf(i));}
        for(int i=1; i<=22; i++){day1d22.add(String.valueOf(i));}
        for(int i=1; i<=23; i++){day1d23.add(String.valueOf(i));}
        for(int i=19; i<=29; i++){day19d29.add(String.valueOf(i));}
        for(int i=20; i<=31; i++){day20d31.add(String.valueOf(i));}
        for(int i=21; i<=30; i++){day21d30.add(String.valueOf(i));}
        for(int i=21; i<=31; i++){day21d31.add(String.valueOf(i));}
        for(int i=22; i<=30; i++){day22d30.add(String.valueOf(i));}
        for(int i=22; i<=31; i++){day22d31.add(String.valueOf(i));}
        for(int i=23; i<=30; i++){day23d30.add(String.valueOf(i));}
        for(int i=24; i<=31; i++){day24d31.add(String.valueOf(i));}
        for(int i=23; i<=31; i++){day23d31.add(String.valueOf(i));}

        spnThang.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);
        spnNgay.getBackground().setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);

        if(name.equals("Xử Nữ")) {
            CustomSpnday adapter89 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month89);
            adapter89.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter89);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("8")){
                        CustomSpn adapter2331 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day23d31);
                        adapter2331.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2331);
                    } else if(spnThang.getSelectedItem().toString().equals("9")){
                        CustomSpn adapter0122 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d22);
                        adapter0122.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0122);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Ma Kết")) {
            CustomSpnday adapter121 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month121);
            adapter121.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter121);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("12")){
                        CustomSpn adapter2231 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day22d31);
                        adapter2231.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2231);
                    } else if(spnThang.getSelectedItem().toString().equals("1")){
                        CustomSpn adapter0119 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d19);
                        adapter0119.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0119);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Kim Ngưu")) {
            CustomSpnday adapter45 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month45);
            adapter45.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter45);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("4")){
                        CustomSpn adapter2130 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day21d30);
                        adapter2130.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2130);
                    } else if(spnThang.getSelectedItem().toString().equals("5")){
                        CustomSpn adapter2031 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day20d31);
                        adapter2031.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2031);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Song Tử")) {
            CustomSpnday adapter56 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month56);
            adapter56.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter56);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("5")){
                        CustomSpn adapter2131 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day21d31);
                        adapter2131.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2131);
                    } else if(spnThang.getSelectedItem().toString().equals("6")){
                        CustomSpn adapter0122 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d22);
                        adapter0122.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0122);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Thiên Bình")) {
            CustomSpnday adapter910 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month910);
            adapter910.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter910);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("9")){
                        CustomSpn adapter2330 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day23d30);
                        adapter2330.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2330);
                    } else if(spnThang.getSelectedItem().toString().equals("10")){
                        CustomSpn adapter0123 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d23);
                        adapter0123.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0123);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Bảo Bình")) {
            CustomSpnday adapter12 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month12);
            adapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter12);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("1")){
                        CustomSpn adapter2031 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day20d31);
                        adapter2031.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2031);
                    } else if(spnThang.getSelectedItem().toString().equals("2")){
                        CustomSpn adapter0118 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d18);
                        adapter0118.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0118);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Sư Tử")) {
            CustomSpnday adapter78= new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month78);
            adapter78.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter78);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("7")){
                        CustomSpn adapter2331 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day23d31);
                        adapter2331.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2331);
                    } else if(spnThang.getSelectedItem().toString().equals("8")){
                        CustomSpn adapter0122 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d22);
                        adapter0122.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0122);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Bạch Dương")) {
            CustomSpnday adapter34 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month34);
            adapter34.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter34);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("3")){
                        CustomSpn adapter2131 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day21d31);
                        adapter2131.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2131);
                    } else if(spnThang.getSelectedItem().toString().equals("4")){
                        CustomSpn adapter0120 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d20);
                        adapter0120.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0120);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Nhân Mã")) {
            CustomSpnday adapter1112 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month1112);
            adapter1112.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter1112);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("11")){
                        CustomSpn adapter2330 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day23d30);
                        adapter2330.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2330);
                    } else if(spnThang.getSelectedItem().toString().equals("12")){
                        CustomSpn adapter0121 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d21);
                        adapter0121.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0121);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Thiên Yết")) {
            CustomSpnday adapter1011 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month1011);
            adapter1011.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter1011);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("10")){
                        CustomSpn adapter2431 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day24d31);
                        adapter2431.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2431);
                    } else if(spnThang.getSelectedItem().toString().equals("11")){
                        CustomSpn adapter0122 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d22);
                        adapter0122.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0122);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Song Ngư")) {
            CustomSpnday adapter23 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month23);
            adapter23.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter23);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("2")){
                        CustomSpn adapter1929 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day19d29);
                        adapter1929.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter1929);
                    } else if(spnThang.getSelectedItem().toString().equals("3")){
                        CustomSpn adapter0120 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d20);
                        adapter0120.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0120);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }
        if(name.equals("Cự Giải")) {
            CustomSpnday adapter67 = new CustomSpnday(ActivityContent.this, android.R.layout.simple_spinner_item, month67);
            adapter67.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spnThang.setAdapter(adapter67);
            spnThang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spnThang.getSelectedItem().toString().equals("6")){
                        CustomSpn adapter2230 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day22d30);
                        adapter2230.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter2230);
                    } else if(spnThang.getSelectedItem().toString().equals("9")){
                        CustomSpn adapter0122 = new CustomSpn(ActivityContent.this, android.R.layout.simple_spinner_item, day1d22);
                        adapter0122.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spnNgay.setAdapter(adapter0122);
                    }
                }
                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {
                }
            });
        }

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (new CheckNet(ActivityContent.this).isNetworkAvailable()) {
                    if(isOnline()) {
                        new readJson().execute("http://dongchd.pe.hu/index.php");
                    }else {
                        Toast.makeText(ActivityContent.this, "bad internet connection!", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(ActivityContent.this, "Internet not available!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    class readJson extends AsyncTask<String, Integer, String>{
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            return readDataFromURL(params[0]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONArray mang = new JSONArray(s);
                for(int i=0; i<mang.length(); i++){
                JSONObject chd = mang.getJSONObject(i);
                    if(chd.getString("ten").toString().equals(name)) {
                        chiTiet = chd.getString("chitiet");
                        yNghia = chd.getString("ynghia");
                        anh = chd.getString("anh");
                    }
            }
                tvChitiet.setText(chiTiet);
                tvYNghia.setText(yNghia);
                new DownloadImageFromInternet((ImageView) findViewById(R.id.imgCung))
                        .execute(anh);
                tvtt.setText("Truyền thuyết:");
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static String readDataFromURL(String theUrl)
    {
        StringBuilder content = new StringBuilder();

        try
        {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null)
            {
                content.append(line + "\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return content.toString();
    }

    private class DownloadImageFromInternet extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView;

        public DownloadImageFromInternet(ImageView imageView) {
            this.imageView = imageView;
            imageView.setImageDrawable(getDrawable(R.drawable.loading));
            //Toast.makeText(getApplicationContext(), "Please wait, it may take a few minute...", Toast.LENGTH_SHORT).show();
        }

        protected Bitmap doInBackground(String... urls) {
            String imageURL = urls[0];
            Bitmap bimage = null;
            try {
                InputStream in = new java.net.URL(imageURL).openStream();
                bimage = BitmapFactory.decodeStream(in);

            } catch (Exception e) {
                Log.e("Error Message", e.getMessage());
                e.printStackTrace();
            }
            return bimage;
        }

        protected void onPostExecute(Bitmap result) {
            imageView.setImageBitmap(result);
        }
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
