package com.example.beattheblues4;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MoodGraph extends AppCompatActivity {
    private FirebaseFirestore db;
    CollectionReference collectionReference;
    DocumentReference documentReference;
    BarChart barChart;
    List<Mood> moods = new ArrayList<>();
    FirebaseUser currentFirebaseUser = FirebaseAuth.getInstance().getCurrentUser();
    String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mood_graph);

        db = FirebaseFirestore.getInstance();
        barChart = findViewById(R.id.chart);
        barChart.setDrawBarShadow(true);
        //barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(15);
        barChart.setTouchEnabled(false);
        barChart.setDrawGridBackground(true);
        barChart.setNoDataText("Loading...");
        final ArrayList<BarEntry> barEntries = new ArrayList<>();
        collectionReference = db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).collection("mood");
        documentReference = db.collection("users").document(FirebaseAuth.getInstance().getCurrentUser().getUid()).collection("mood").document();
        Query moodquery = collectionReference.orderBy("timestamp", Query.Direction.DESCENDING).limit(15);
        moodquery.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Mood mood = document.toObject(Mood.class);
                        //int moodval = document.getLong("mood").intValue();
                        //Date date = document.getDate("timestamp");
                        moods.add(mood);
                    }
                    //graph
                    for (int i = 0; i < moods.size(); i++) {
                        barEntries.add(new BarEntry(i, moods.get(i).getMood()));
                        Toast.makeText(MoodGraph.this, Integer.toString(moods.get(i).getMood()), Toast.LENGTH_SHORT).show();
                    }
                    BarDataSet barDataSet = new BarDataSet(barEntries, "date");
                    BarData data = new BarData(barDataSet);
                    data.setBarWidth(0.9f);

                    barChart.setData(data);
                    barChart.animateY(500, Easing.EaseInElastic);
                } else {
                    Log.d("PUCK", "Error getting documents: ", task.getException());
                }
            }
        });

    }
}
