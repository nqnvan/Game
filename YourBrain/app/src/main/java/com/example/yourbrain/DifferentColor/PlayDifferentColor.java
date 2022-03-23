package com.example.yourbrain.DifferentColor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.yourbrain.DifferentColor.Object.AdapterColor;
import com.example.yourbrain.DifferentColor.Object.Color;
import com.example.yourbrain.DifferentColor.Object.DinhNghia;
import com.example.yourbrain.DifferentColor.Object.Info;
import com.example.yourbrain.R;

import java.util.ArrayList;
import java.util.Random;

public class PlayDifferentColor extends AppCompatActivity {

    ArrayList<Color> arrayColor = new ArrayList<>();
    GridView gdvListColor;
    AdapterColor adapter;
    DinhNghia dinhNghia = new DinhNghia();

    TextView tv_level, tv_time, tv_coin;
    CountDownTimer demNguoc;

    Info player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_different_color);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        init();
        anhxa();
        setUp();
        setClick();
    }

    private void init () {
        player = new Info(this);
        player.getData();
        createColor();
        adapter = new AdapterColor(this,0,arrayColor);
    }

    private void anhxa () {
        gdvListColor = findViewById(R.id.gdvListColor);
        tv_level = findViewById(R.id.tv_level);
        tv_time = findViewById(R.id.tv_time);
        tv_coin = findViewById(R.id.tv_coin);
    }

    private void setUp () {
        tv_coin.setText(""+player.coin);
        gdvListColor.setNumColumns(dinhNghia.soCot);
        gdvListColor.setAdapter(adapter);
        tv_level.setText(""+dinhNghia.level);
        upDateTime();
    }

    private void setClick () {
        gdvListColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                checkColor(arrayColor.get(i));
            }
        });
    }

    private void createColor () {
        dinhNghia.setLevel();
        dinhNghia.layMauNgauNhien();
        dinhNghia.setTime();
        arrayColor.clear();
        while (arrayColor.size() < dinhNghia.soO) {
            arrayColor.add(new Color(dinhNghia.maudam));
        }

        Random r = new Random();
        arrayColor.get(r.nextInt(arrayColor.size())).maMau = dinhNghia.maunhat;
    }

    private void upDate () {
        adapter.upDate(arrayColor);
        gdvListColor.setNumColumns(dinhNghia.soCot);
        tv_level.setText(""+dinhNghia.level);
    }

    private void checkColor(Color c) {
        if(c.maMau.equals(dinhNghia.maunhat)) {
            //Toast.makeText(this,"true",Toast.LENGTH_SHORT).show();
            dinhNghia.level++;
            createColor();
            upDate();
            dinhNghia.setTime();
            demNguoc.cancel();
            upDateTime();
            player.coin = player.coin + 2;
            tv_coin.setText(""+player.coin);
            player.setData();
        } else {
            //Toast.makeText(this,"false",Toast.LENGTH_SHORT).show();
            player.coin = player.coin - 4;
            tv_coin.setText(""+player.coin);
            player.setData();
        }
    }

    private void upDateTime() {
        demNguoc = new CountDownTimer(dinhNghia.timeChay, 10) {
            @Override
            public void onTick(long l) {
                dinhNghia.timeChay = (int) l;
                if (dinhNghia.timeChay != 0) {
                    int soGiay = dinhNghia.timeChay / 1000;
                    int soMiliGiay = dinhNghia.timeChay % 1000 / 10;
                    String time = soGiay + ":" + soMiliGiay;
                    tv_time.setText(time);
                }
            }

            @Override
            public void onFinish() {
                tv_time.setText("0:00");
                timeup();
            }
        }.start();
    }

    private void timeup() {
        dinhNghia.hetGio = true;
        gdvListColor.setOnItemClickListener(null);

        Intent intent = new Intent(this, EndDifferentColor.class);
        intent.putExtra("level",dinhNghia.level);
        startActivity(intent);
        finish();

    }
}