package com.example.beattheblues4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class DailyScreening extends AppCompatActivity {


    int mood;
    int moodval;
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "$NAME";
    private ImageView imgTerrible, imgBad, imgOkay, imgGood, imgAwesome;
    private Button btnBack, btnNext;
    private TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_screening);

        imgTerrible = (ImageView) findViewById(R.id.imgTerrible);
        imgBad = (ImageView) findViewById(R.id.imgBad);
        imgOkay= (ImageView) findViewById(R.id.imgOkay);
        imgGood= (ImageView) findViewById(R.id.imgGood);
        imgAwesome= (ImageView) findViewById(R.id.imgAwesome);
        btnBack= (Button) findViewById(R.id.btnBack);
        btnNext= (Button) findViewById(R.id.btnNext);
        t1= (TextView) findViewById(R.id.moodtext);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), ScreeningMode.class));
                finish();
                Toast.makeText(DailyScreening.this, "SCREENING MODE PAGE", Toast.LENGTH_SHORT).show();
                return;
            }
        });

        imgTerrible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("TERRIBLE");
            }
        });

        imgBad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("BAD");
            }
        });

        imgOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("OKAY");
            }
        });

        imgGood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("GOOD");
            }
        });

        imgAwesome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t1.setText("AWESOME");
            }
        });


            // Toast.makeText(getApplicationContext(), Integer.toString(mood), Toast.LENGTH_SHORT).show();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String, Object> oceandata = new HashMap<>();
                oceandata.put("mood", mood);
                oceandata.put("timestamp", FieldValue.serverTimestamp());
                String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                db.collection("users").document(uid).collection("mood").add(oceandata).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
                        Toast.makeText(DailyScreening.this, "done!", Toast.LENGTH_SHORT).show();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.w(TAG, "Error adding document", e);
                            }
                        });;
                if(imgTerrible.performClick()){
                    startActivity(new Intent(getApplicationContext(), Terrible.class));
                }
                finish();
            }
        });

        }
    }