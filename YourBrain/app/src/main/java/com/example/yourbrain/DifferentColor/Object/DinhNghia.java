package com.example.yourbrain.DifferentColor.Object;

import java.util.Random;

public class DinhNghia {
    public int soCot = 7;
    public int soO;
    public String maudam = "";
    public String maunhat = "";

    public int level = 1;
    public int timeTong;
    public int timeChay;

    public boolean hetGio = false;

    private String arraymaudam[] = new String[] {
            "#FE2E2E",
            "#04B4AE",
            "#FACC2E",
            "#AEB404",
            "#31B404",
            "#04B45F",
            "#AEB404"
    };

    private String arrmaunhat[] = new String[] {
            "#FA5858",
            "#2EFEF7",
            "#F5DA81",
            "#F3F781",
            "#3ADF00",
            "#00FF80",
            "#F4FA58"
    };

    public void setTime() {
        if(level<10) {
            timeTong = 3;
        } else if (level<30) {
            timeTong = 4;
        } else if (level<40) {
            timeTong = 5;
        } else if (level<50) {
            timeTong = 6;
        } else if (level<70){
            timeTong = 6;
        } else if (level<100){
            timeTong = 6;
        } else {
            timeTong = 5;
        }
        timeChay = timeTong * 1000;
    }

    public void layMauNgauNhien() {
        Random r = new Random();
        int position = r.nextInt(arraymaudam.length);
        maudam = arraymaudam[position];
        maunhat = arrmaunhat[position];
    }

    public void setLevel() {
        if(level<10) {
            soCot = 3;
        } else if (level<20) {
            soCot = 4;
        } else if (level<30) {
            soCot = 5;
        } else if (level<40){
            soCot = 6;
        } else if (level<50){
            soCot = 7;
        } else if (level<70) {
            soCot = 8;
        } else if (level<100) {
            soCot = 9;
        } else {
            soCot = 10;
        }
        soO = soCot*soCot;
    }
}
