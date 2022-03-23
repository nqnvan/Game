package com.example.yourbrain;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.yourbrain.DifferentColor.PlayDifferentColor;
import com.example.yourbrain.Memory.PlayMemory;

public class MainActivity extends AppCompatActivity {

    TextView play_color, play_memory, exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);

        play_color = findViewById(R.id.play_color);
        play_memory = findViewById(R.id.play_memory);
        exit = findViewById(R.id.exit);

        play_color.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayDifferentColor.class);
                startActivity(intent);
            }
        });

        play_memory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, PlayMemory.class);
                startActivity(intent);
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finishAffinity();
                System.exit(0);
            }
        });

    }
}