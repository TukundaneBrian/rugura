package com.example.bryn;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class tuk1 extends AppCompatActivity {

    MediaPlayer player;
    Button buttnplay;
    Button buttnPause;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuk1);
        buttnplay= (Button)findViewById(R.id.btnplay);

        buttnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player = MediaPlayer.create(getApplicationContext(), R.raw.jangu);//Create MediaPlayer object with MP3 file under res/raw folder
                player.start();//Start playing the music
            }

        });
        buttnPause = (Button) findViewById(R.id.btnstop);
        buttnPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (player != null && player.isPlaying()) {//If music is playing already
                    player.stop();//Stop playing the music

                }
            }
        });
    }

}
