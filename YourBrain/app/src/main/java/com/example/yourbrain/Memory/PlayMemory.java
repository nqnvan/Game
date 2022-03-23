package com.example.yourbrain.Memory;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.text.InputType;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yourbrain.DifferentColor.EndDifferentColor;
import com.example.yourbrain.DifferentColor.Object.Info;
import com.example.yourbrain.MainActivity;
import com.example.yourbrain.R;

import java.util.Arrays;
import java.util.Collections;

public class PlayMemory extends AppCompatActivity {

    TextView tv_p, tv_time;
    ImageView iv11, iv12, iv13, iv14, iv21, iv22, iv23, iv24, iv31, iv32, iv33, iv34, iv41, iv42, iv43, iv44;

    Integer[] cardsArray = {101, 102, 103, 104, 105, 106, 107, 108, 201, 202, 203, 204, 205, 206, 207, 208};

    int image101, image102, image103, image104, image105, image106, image107, image108;
    int image201, image202, image203, image204, image205, image206, image207, image208;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    //int point = 10;

    int timeTong = 35;
    int timeChay = timeTong*1000;
    CountDownTimer demNguoc;

    Point player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_memory);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        tv_p = findViewById(R.id.tv_p);
        tv_time = findViewById(R.id.tv_time);
        tv_p.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);
        tv_time.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS);

        iv11 = findViewById(R.id.iv_11);
        iv12 = findViewById(R.id.iv_12);
        iv13 = findViewById(R.id.iv_13);
        iv14 = findViewById(R.id.iv_14);
        iv21 = findViewById(R.id.iv_21);
        iv22 = findViewById(R.id.iv_22);
        iv23 = findViewById(R.id.iv_23);
        iv24 = findViewById(R.id.iv_24);
        iv31 = findViewById(R.id.iv_31);
        iv32 = findViewById(R.id.iv_32);
        iv33 = findViewById(R.id.iv_33);
        iv34 = findViewById(R.id.iv_34);
        iv41 = findViewById(R.id.iv_41);
        iv42 = findViewById(R.id.iv_42);
        iv43 = findViewById(R.id.iv_43);
        iv44 = findViewById(R.id.iv_44);

        iv11.setTag("0");
        iv12.setTag("1");
        iv13.setTag("2");
        iv14.setTag("3");
        iv21.setTag("4");
        iv22.setTag("5");
        iv23.setTag("6");
        iv24.setTag("7");
        iv31.setTag("8");
        iv32.setTag("9");
        iv33.setTag("10");
        iv34.setTag("11");
        iv41.setTag("12");
        iv42.setTag("13");
        iv43.setTag("14");
        iv44.setTag("15");

        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));
        System.out.println(Arrays.asList(cardsArray));

        player = new Point(this);
        player.getData();
        tv_p.setText("P: "+player.point);

        upDateTime();

        iv11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv11, theCard);
            }
        });

        iv12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv12, theCard);
            }
        });

        iv13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv13, theCard);
            }
        });

        iv14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv14, theCard);
            }
        });

        iv21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv21, theCard);
            }
        });

        iv22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv22, theCard);
            }
        });

        iv23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv23, theCard);
            }
        });

        iv24.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv24, theCard);
            }
        });

        iv31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv31, theCard);
            }
        });

        iv32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv32, theCard);
            }
        });

        iv33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv33, theCard);
            }
        });

        iv34.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv34, theCard);
            }
        });

        iv41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv41, theCard);
            }
        });

        iv42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv42, theCard);
            }
        });

        iv43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv43, theCard);
            }
        });

        iv44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv44, theCard);
            }
        });

    }

    private void doStuff(ImageView iv, int card) {
        if (cardsArray[card] == 101) {
            iv.setImageResource(image101);
        } else if (cardsArray[card] == 102) {
            iv.setImageResource(image102);
        } else if (cardsArray[card] == 103) {
            iv.setImageResource(image103);
        } else if (cardsArray[card] == 104) {
            iv.setImageResource(image104);
        } else if (cardsArray[card] == 105) {
            iv.setImageResource(image105);
        } else if (cardsArray[card] == 106) {
            iv.setImageResource(image106);
        } else if (cardsArray[card] == 107) {
            iv.setImageResource(image107);
        } else if (cardsArray[card] == 108) {
            iv.setImageResource(image108);
        } else if (cardsArray[card] == 201) {
            iv.setImageResource(image201);
        } else if (cardsArray[card] == 202) {
            iv.setImageResource(image202);
        } else if (cardsArray[card] == 203) {
            iv.setImageResource(image203);
        } else if (cardsArray[card] == 204) {
            iv.setImageResource(image204);
        } else if (cardsArray[card] == 205) {
            iv.setImageResource(image205);
        } else if (cardsArray[card] == 206) {
            iv.setImageResource(image206);
        } else if (cardsArray[card] == 207) {
            iv.setImageResource(image207);
        } else if (cardsArray[card] == 208) {
            iv.setImageResource(image208);
        }

        if (cardNumber == 1) {
            firstCard = cardsArray[card];
            if (firstCard > 200) {
                firstCard = firstCard - 100;
            }
            cardNumber = 2;
            clickedFirst = card;
            iv.setEnabled(false);
        } else if (cardNumber == 2) {
            secondCard = cardsArray[card];
            if (secondCard > 200) {
                secondCard = secondCard - 100;
            }
            cardNumber = 1;
            clickedSecond = card;


            iv11.setEnabled(false);
            iv12.setEnabled(false);
            iv13.setEnabled(false);
            iv14.setEnabled(false);
            iv21.setEnabled(false);
            iv22.setEnabled(false);
            iv23.setEnabled(false);
            iv24.setEnabled(false);
            iv31.setEnabled(false);
            iv32.setEnabled(false);
            iv33.setEnabled(false);
            iv34.setEnabled(false);
            iv41.setEnabled(false);
            iv42.setEnabled(false);
            iv43.setEnabled(false);
            iv44.setEnabled(false);


            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    calculate();
                }
            }, 300);

        }

    }

    private void calculate() {
        if (firstCard == secondCard) {
            if (clickedFirst == 0) {
                iv11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv14.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv24.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv34.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 12) {
                iv41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 13) {
                iv42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 14) {
                iv43.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 15) {
                iv44.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv14.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv24.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv34.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 12) {
                iv41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 13) {
                iv42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 14) {
                iv43.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 15) {
                iv44.setVisibility(View.INVISIBLE);
            }


            player.point = player.point + 10;
            tv_p.setText("P: " + player.point);

        } else {

            player.point = player.point - 2;
            tv_p.setText("P: " + player.point);

            iv11.setImageResource(R.drawable.background);
            iv12.setImageResource(R.drawable.background);
            iv13.setImageResource(R.drawable.background);
            iv14.setImageResource(R.drawable.background);
            iv21.setImageResource(R.drawable.background);
            iv22.setImageResource(R.drawable.background);
            iv23.setImageResource(R.drawable.background);
            iv24.setImageResource(R.drawable.background);
            iv31.setImageResource(R.drawable.background);
            iv32.setImageResource(R.drawable.background);
            iv33.setImageResource(R.drawable.background);
            iv34.setImageResource(R.drawable.background);
            iv41.setImageResource(R.drawable.background);
            iv42.setImageResource(R.drawable.background);
            iv43.setImageResource(R.drawable.background);
            iv44.setImageResource(R.drawable.background);

        }

        iv11.setEnabled(true);
        iv12.setEnabled(true);
        iv13.setEnabled(true);
        iv14.setEnabled(true);
        iv21.setEnabled(true);
        iv22.setEnabled(true);
        iv23.setEnabled(true);
        iv24.setEnabled(true);
        iv31.setEnabled(true);
        iv32.setEnabled(true);
        iv33.setEnabled(true);
        iv34.setEnabled(true);
        iv41.setEnabled(true);
        iv42.setEnabled(true);
        iv43.setEnabled(true);
        iv44.setEnabled(true);

        checkend();
    }

    private void checkend() {

        if (iv11.getVisibility() == View.INVISIBLE && iv12.getVisibility() == View.INVISIBLE
                && iv13.getVisibility() == View.INVISIBLE && iv14.getVisibility() == View.INVISIBLE
                && iv21.getVisibility() == View.INVISIBLE && iv22.getVisibility() == View.INVISIBLE
                && iv23.getVisibility() == View.INVISIBLE && iv24.getVisibility() == View.INVISIBLE
                && iv31.getVisibility() == View.INVISIBLE && iv32.getVisibility() == View.INVISIBLE
                && iv33.getVisibility() == View.INVISIBLE && iv34.getVisibility() == View.INVISIBLE
                && iv41.getVisibility() == View.INVISIBLE && iv42.getVisibility() == View.INVISIBLE
                && iv43.getVisibility() == View.INVISIBLE && iv44.getVisibility() == View.INVISIBLE)
        {
            demNguoc.cancel();
            player.setData();
            Intent intent = new Intent(this, EndMemory.class);
            intent.putExtra("point",player.point);
            startActivity(intent);
            finish();
        }

    }

    private void gameover() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(PlayMemory.this);
        alertDialogBuilder
                .setMessage("GAME OVER! \nPoint " + player.point)
                .setCancelable(false)
                .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(getApplicationContext(), PlayMemory.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
        player.setData();
    }

    private void upDateTime() {
        demNguoc = new CountDownTimer(timeChay, 10) {
            @Override
            public void onTick(long l) {
                timeChay = (int) l;
                if (timeChay!=0) {
                    int soGiay = timeChay / 1000;
                    int soMiliGiay = timeChay % 1000 / 10;
                    String time = soGiay + ":" + soMiliGiay;
                    tv_time.setText(time);
                }
            }

            @Override
            public void onFinish() {
                tv_time.setText("0:00");
                gameover();
            }
        }.start();
    }

    private void frontOfCardsResources() {
        image101 = R.drawable.icon1;
        image102 = R.drawable.icon2;
        image103 = R.drawable.icon3;
        image104 = R.drawable.icon4;
        image105 = R.drawable.icon5;
        image106 = R.drawable.icon6;
        image107 = R.drawable.icon7;
        image108 = R.drawable.icon8;
        image201 = R.drawable.icon1;
        image202 = R.drawable.icon2;
        image203 = R.drawable.icon3;
        image204 = R.drawable.icon4;
        image205 = R.drawable.icon5;
        image206 = R.drawable.icon6;
        image207 = R.drawable.icon7;
        image208 = R.drawable.icon8;
    }
}