package com.example.homework3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ThreeActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        imageView = findViewById(R.id.memTree);
        textView = findViewById(R.id.phoneN);
        Intent intent = getIntent();
        String name = intent.getStringExtra("1");
        textView.setText(name);


    }
}