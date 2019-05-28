package com.example.beattheblues4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ScreeningMode extends AppCompatActivity {

    private ImageButton btnHome, btnSMode, btnSTherapy;
    private Button btnDaily, btnDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screening_mode);

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnSMode = (ImageButton) findViewById(R.id.btnSMode);
        btnSTherapy= (ImageButton) findViewById(R.id.btnSTherapy);
        btnDaily = (Button) findViewById(R.id.btnDaily);
        btnDetail= (Button) findViewById(R.id.btnDetail);

        btnSMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "SCREENING MODE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
                Toast.makeText(getApplicationContext(), "HOME PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnSTherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelfTherapy.class));
                finish();
                Toast.makeText(getApplicationContext(), "SELF THERAPY PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnDaily.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DailyScreening.class));
                finish();
                Toast.makeText(ScreeningMode.this, "DAILY SCREENING PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailScreening.class));
                finish();
                Toast.makeText(ScreeningMode.this, "DETAIL SCREENING PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

    }
}
