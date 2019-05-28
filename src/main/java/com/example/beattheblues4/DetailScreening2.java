package com.example.beattheblues4;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextSwitcher;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FieldValue;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class DetailScreening2 extends AppCompatActivity {

    private RadioGroup radioGroup;
    private TextSwitcher textSwitcher;
    private Button finishbutton;
    final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG = "$NAME";
    //private RadioGroup rg;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButton3;
    private RadioButton radioButton4;

    private int count =0;
    TextView total;
    TextView t ;
    private String[] textArray = {
            "I found it difficult to calm myself."
            ,"My mouth felt dry."
            ,"I didn't experience any positive feelings."
            ,"I had difficulty breathing at times (such as wheezing and breathlessness without having made any physical effort)."
            ,"It was hard for me to have the initiatives to do things."
            ,"I intended to exaggerate when I reacted to situations",
            "I felt shaky (for example, in my hands)",
            "I felt I was always nervous",
            "I got worried about situations in which I could have panicked and looked ridiculous."
            ,"I felt I had no desire for anything"
            ,"I felt restless",
            "I found it difficult to relax",
            "I felt depressed and had no motivation"
            ,"I was intolerant of the things that kept me from continuing to do what I had been doing",
            "I felt like I was going to panic",
            "I didn't feel enthusiastic about anything",
            "I felt like I was worthless as a person",
            "I felt like I was being a little too emotional/sensitive",
            "I knew my heartbeat had changed even though I hadn't done anything physically rigorous (e.g. increased heart rate. irregular heartbeat)",
            "I felt afraid for no reason",
            "I felt there was no meaning to life"};

    int[] scorearray = new int[21];
    int score = -1;
    int depression = 0;
    int anxiety = 0;
    int stress = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialization
        radioButton1 = (RadioButton)findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton)findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton)findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton)findViewById(R.id.radioButton4);
        super.onCreate(savedInstanceState);
        total=findViewById(R.id.total);
        setContentView(R.layout.activity_detail_screening2);
        textSwitcher = (TextSwitcher) findViewById(R.id.textSwitcher);
        t= findViewById(R.id.counter2);
        finishbutton = (Button) findViewById(R.id.Finish);
        finishbutton.setVisibility(View.GONE);
        textSwitcher.setCurrentText(textArray[count]);
        //total.setText(Integer.toString(textArray.length));
//animation
        Animation textAnimationIn =  AnimationUtils.
                loadAnimation(this,   android.R.anim.slide_in_left);
        textAnimationIn.setDuration(800);

        Animation textAnimationOut =  AnimationUtils.
                loadAnimation(this,   android.R.anim.slide_out_right);
        textAnimationOut.setDuration(800);

        textSwitcher.setInAnimation(textAnimationIn);

        textSwitcher.setOutAnimation(textAnimationOut);
        radioGroup = (RadioGroup) findViewById(R.id.selectionRG);
        radioGroup.clearCheck();

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                int selectedType;
                if (null != rb ) {
                    int check;
                    switch(checkedId)
                    {
                        case R.id.radioButton1:
                            score = 0;
                            break;
                        case R.id.radioButton2:
                            score = 1;
                            break;
                        case R.id.radioButton3:
                            score = 2;
                            break;
                        case R.id.radioButton4:
                            score = 3;
                            break;
                    }

                    //Toast.makeText(DASSActivity.this, rb.getText(), Toast.LENGTH_SHORT).show();
                    //Toast.makeText(DASSActivity.this, Integer.toString(score), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }


    public void showNextText(View view){
        if(score==-1){
            Toast.makeText(DetailScreening2.this, "Please choose!", Toast.LENGTH_SHORT).show();
        }else if(count<scorearray.length) {
            scorearray[count] = score;
            textSwitcher.setText(textArray[count]);
            t.setText(Integer.toString(count + 1));
            count++;
            radioGroup.clearCheck();
            score = -1;
            //Toast.makeText(DASSActivity.this, Integer.toString(scorearray[count]), Toast.LENGTH_SHORT).show();
        }
        else{
            finishbutton.setVisibility(View.VISIBLE);
        }
    }
    public void endpersonalitytest(View v) {
        depression = scorearray[2]+scorearray[4]+scorearray[9]+scorearray[12]+scorearray[15]+scorearray[16]+scorearray[20];
        anxiety = scorearray[1]+scorearray[3]+scorearray[6]+scorearray[8]+scorearray[14]+scorearray[17]+scorearray[19];
        stress = scorearray[0]+scorearray[5]+scorearray[7]+scorearray[10]+scorearray[11]+scorearray[13]+scorearray[17];
        //database stuff
        Date currentTime = Calendar.getInstance().getTime();
        Map<String, Object> dassdata = new HashMap<>();
        dassdata.put("depression", depression);
        dassdata.put("anxiety", anxiety);
        dassdata.put("stress", stress);
        dassdata.put("timestamp", FieldValue.serverTimestamp());
        String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        //Toast.makeText(DASSActivity.this, "depression "+Integer.toString(depression)+" anxiety "+Integer.toString(anxiety)+"Stress: "+Integer.toString(stress), Toast.LENGTH_SHORT).show();
        db.collection("users").document(uid).collection("dass").add(dassdata).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot written with ID: " + documentReference.getId());
            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });;

        if(depression>11||anxiety>8||stress>13){
            Intent intent = new Intent(DetailScreening2.this, ProfessionalSupport.class);
            startActivity(intent);
        }
        else{
            Intent intent = new Intent(DetailScreening2.this, MainActivity.class);
            startActivity(intent);
        }

        //todo : finished
    }
}