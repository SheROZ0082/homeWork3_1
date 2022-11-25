package com.example.homework3_1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.security.SecureRandom;

public class MainActivityOne extends AppCompatActivity {

    EditText edit;
    TextView generate, gettext;
    Button btn_generate, btnnext;

    public static String generateRandomPassword(int len) {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();


        final String chars = "1";
        for (int i = 0; i < len; i++) {
            int randomIndex = random.nextInt(chars.length());
            sb.append(chars.charAt(randomIndex));
        }

        return sb.toString();

    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_one);
        edit = findViewById(R.id.writeCod);
        generate = findViewById(R.id.generate);
        gettext = findViewById(R.id.gettext);
        btn_generate = findViewById(R.id.btn_generate);
        btnnext = findViewById(R.id.btn_next);

        Intent intent = getIntent();
        String name = intent.getStringExtra("key");
        gettext.setText(name);
        int len = 6;
        btn_generate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate.setText(generateRandomPassword(len));

            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edit.getText().toString().equals(generate.getText().toString())) {
                    Intent intent1 = new Intent(MainActivityOne.this, ThreeActivity.class);
                    String result = gettext.getText().toString();
                    intent1.putExtra("1",result);
                    startActivity(intent1);
                } else {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


}
