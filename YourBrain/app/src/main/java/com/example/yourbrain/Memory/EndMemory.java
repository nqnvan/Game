package com.example.yourbrain.Memory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yourbrain.DifferentColor.PlayDifferentColor;
import com.example.yourbrain.R;

public class EndMemory extends AppCompatActivity {

    TextView tvpoint;
    int point;
    Button play_again, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_memory);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        tvpoint =findViewById(R.id.tvpoint);
        play_again = findViewById(R.id.btn_playagain);
        exit = findViewById(R.id.btn_exitgame);

        point = getIntent().getIntExtra("point",0);

        tvpoint.setText("Point "+point);

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


    public void playAgain() {
        Intent intent = new Intent(this, PlayMemory.class);
        startActivity(intent);
        finish();
    }

    public void Exit() {
        finish();
    }

}
