package com.douglas.chd.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Douglas on 11/15/2016.
 */
public class CustomSpn extends ArrayAdapter {

    Typeface face= Typeface.createFromAsset(getContext().getAssets(), "fonts/myfont.ttf");

    public CustomSpn(Context context, int textViewResourceId,
                     ArrayList<String> objects) {
        super(context, textViewResourceId, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View v = super.getView(position, convertView, parent);
        ((TextView) v).setTypeface(face);
        ((TextView) v).setTextColor(Color.parseColor("#ffffff"));
        ((TextView) v).setTextSize(17);
        return v;
    }
    public View getDropDownView(int position,  View convertView,  ViewGroup parent) {
        View v =super.getDropDownView(position, convertView, parent);

        ((TextView) v).setTypeface(face);
        ((TextView) v).setTextColor(Color.parseColor("#000000"));
        ((TextView) v).setTextSize(17);
        return v;
    }
}
