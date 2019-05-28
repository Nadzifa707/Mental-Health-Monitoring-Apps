package com.example.beattheblues4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class DetailScreening extends AppCompatActivity {

    private Button btnBack, btnAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_screening);

        btnAnswer= (Button) findViewById(R.id.btnAnswer);
        btnBack= (Button) findViewById(R.id.btnBack);

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), DetailScreening2.class));
                finish();
                Toast.makeText(getApplicationContext(), "ANSWER DASS21 PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScreeningMode.class));
                finish();
                Toast.makeText(getApplicationContext(), "SCREENING MODE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}
