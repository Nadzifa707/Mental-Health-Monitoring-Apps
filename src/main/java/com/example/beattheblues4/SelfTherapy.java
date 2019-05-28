package com.example.beattheblues4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class SelfTherapy extends AppCompatActivity {

    private ImageButton btnHome, btnSMode, btnSTherapy;
    private Button btnRelaxation, btnMindfulness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_self_therapy);

        btnHome = (ImageButton) findViewById(R.id.btnHome);
        btnSMode = (ImageButton) findViewById(R.id.btnSMode);
        btnSTherapy= (ImageButton) findViewById(R.id.btnSTherapy);
        btnRelaxation= (Button) findViewById(R.id.btnRelaxation);
        btnMindfulness= (Button) findViewById(R.id.btnMindfulness);

        btnSTherapy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "SELF THERAPY PAGE", Toast.LENGTH_SHORT).show();
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

        btnSMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScreeningMode.class));
                finish();
                Toast.makeText(getApplicationContext(), "SCREENING MODE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnRelaxation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Relaxation.class));
                finish();
                Toast.makeText(getApplicationContext(), "RELAXATION PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnMindfulness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Mindfulness.class));
                finish();
                Toast.makeText(getApplicationContext(), "MINDFULNESS PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}
