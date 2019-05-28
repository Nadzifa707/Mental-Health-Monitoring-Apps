package com.example.beattheblues4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Relaxation extends AppCompatActivity {

    private Button btnBack, btnStress, btnAnxiety;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relaxation);

        btnStress = (Button) findViewById(R.id.btnStress);
        btnAnxiety = (Button) findViewById(R.id.btnAnxiety);
        btnBack = (Button) findViewById(R.id.btnBack);

        btnStress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RelaxStress.class));
                finish();
                Toast.makeText(getApplicationContext(), "STRESS RELIEVE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnAnxiety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), RelaxAnxiety.class));
                finish();
                Toast.makeText(getApplicationContext(), "ANXIETY RELIEVE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });


        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SelfTherapy.class));
                finish();
                Toast.makeText(getApplicationContext(), "SELF THERAPY PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}
