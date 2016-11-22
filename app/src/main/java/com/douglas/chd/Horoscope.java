package com.douglas.chd;

import android.app.DatePickerDialog;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class Horoscope extends AppCompatActivity {
    TextView txtDate, txtNotification1,txtNotification2;
    Button btnOke;
    Spinner spnZodiac;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horoscope);

        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/myfont.ttf");
        spnZodiac = (Spinner) findViewById(R.id.spnZodiac);
        txtDate = (TextView) findViewById(R.id.showDate);
        btnOke = (Button) findViewById(R.id.btnOke);
        txtNotification1 = (TextView) findViewById(R.id.txtNotification);
        txtNotification2 = (TextView) findViewById(R.id.txtNotification2);
        txtDate.setTypeface(face);
        btnOke.setTypeface(face);
        txtNotification1.setTypeface(face);
        txtNotification2.setTypeface(face);

        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new docJSON().execute("http://baitap.esy.es/index.php");
            }
        });

        ArrayList<String> arrZodiac = new ArrayList<String>();

        arrZodiac.add("Bạch Dương");
        arrZodiac.add("Kim Ngưu");
        arrZodiac.add("Song Tử");
        arrZodiac.add("Cự Giải");
        arrZodiac.add("Sư tử");
        arrZodiac.add("Xử Nữ");
        arrZodiac.add("Thiên Bình");
        arrZodiac.add("Thần Nông");
        arrZodiac.add("Nhân Mã");
        arrZodiac.add("Ma Kết");
        arrZodiac.add("Bảo Bình");
        arrZodiac.add("Song Ngư");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, arrZodiac);
        spnZodiac.setAdapter(arrayAdapter);

        txtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Horoscope.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String date = dayOfMonth + "/" + monthOfYear + "/" + year;
                        txtDate.setText(date);

                    }
                }, 2016, 11, 22);
                datePickerDialog.show();

            }
        });

    }

    class docJSON extends AsyncTask<String, Integer, String> {

        @Override
        protected String doInBackground(String... params) {
            return docNoiDung_Tu_URL(params[0]);

        }

        @Override
        protected void onPostExecute(String s) {


        }
    }


    private static String docNoiDung_Tu_URL(String theUrl) {
        StringBuilder content = new StringBuilder();

        try {
            // create a url object
            URL url = new URL(theUrl);

            // create a urlconnection object
            URLConnection urlConnection = url.openConnection();

            // wrap the urlconnection in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

            String line;

            // read from the urlconnection via the bufferedreader
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line + "\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return content.toString();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
