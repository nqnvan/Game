package com.example.yourbrain.DifferentColor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yourbrain.R;

public class EndDifferentColor extends AppCompatActivity {

    TextView tv_level;
    int level;
    Button play_again, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_different_color);
        setContentView(R.layout.activity_end_different_color);

        init();
        anhxa();
        setup();

        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Exit();
            }
        });
    }

    private void init() {
        level = getIntent().getIntExtra("level",0);
    }

    private void anhxa() {
        tv_level = findViewById(R.id.tvlevel);
        play_again = findViewById(R.id.btn_play_again);
        exit = findViewById(R.id.btn_exit);
    }

    private void setup() {
        tv_level.setText("Level "+level);
    }

    public void playAgain() {
        Intent intent = new Intent(this, PlayDifferentColor.class);
        startActivity(intent);
        finish();
    }

    public void Exit() {
        finish();
    }
}