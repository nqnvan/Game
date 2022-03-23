package com.example.yourbrain.Memory;

import android.content.Context;
import android.content.SharedPreferences;

public class Point {

    public int point = 10;
    private String filename = "gamePoint";

    private Context context;

    public Point (Context context) {
        this.context = context;
    }

    public void getData() {
        SharedPreferences preferences = context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        point = preferences.getInt("player",0);
    }

    public void setData() {
        SharedPreferences preferences = context.getSharedPreferences(filename,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("player", point);
        editor.apply();
    }

}
