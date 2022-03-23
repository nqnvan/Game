package com.example.yourbrain.DifferentColor.Object;

import android.content.Context;
import android.content.SharedPreferences;

public class Info {
    public int coin = 0;
    private String namefile = "gameInfo";

    private Context context;

    public Info(Context context) {
        this.context = context;
    }

    public void getData() {
        SharedPreferences preferences = context.getSharedPreferences(namefile,Context.MODE_PRIVATE);
        coin = preferences.getInt("player",0);
    }

    public void setData() {
        SharedPreferences preferences = context.getSharedPreferences(namefile,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("player", coin);
        editor.apply();
    }
}
