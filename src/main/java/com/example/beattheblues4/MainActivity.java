package com.example.beattheblues4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ImageButton btnHome, btnSMode, btnSTherapy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnSMode = (ImageButton) findViewById(R.id.btnSMode);
        btnSTherapy= (ImageButton) findViewById(R.id.btnSTherapy);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "HOME PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnSMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ScreeningMode.class));
                Toast.makeText(MainActivity.this, "SCREENING MODE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnSTherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SelfTherapy.class));
                Toast.makeText(MainActivity.this, "SELF THERAPY PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}
