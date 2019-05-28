package com.example.beattheblues4;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class RelaxAnxiety extends AppCompatActivity {

    Button btnPlay, btnBack;
    VideoView videov;
    MediaController mediaC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relax_anxiety);

        btnPlay = (Button) findViewById(R.id.btnPlay);
        btnBack = (Button) findViewById(R.id.btnBack);
        videov = (VideoView) findViewById(R.id.videov);
        mediaC = new MediaController(this);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Relaxation.class));
                finish();
                Toast.makeText(getApplicationContext(), "RELAXATION PAGE", Toast.LENGTH_SHORT).show();
            }
        });

        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String videopath = "android.resource://com.example.beattheblues4/"+ R.raw.anxiety;
                Uri uri = Uri.parse(videopath);
                videov.setVideoURI(uri);
                videov.setMediaController(mediaC);
                mediaC.setAnchorView(videov);
                videov.start();
            }
        });
    }
}
