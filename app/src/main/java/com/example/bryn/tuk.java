package com.example.bryn;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class tuk extends AppCompatActivity {
    TextView textView;
    private Object CharSequence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuk);
            textView=findViewById(R.id.c);
            String str ="";
            try {
                InputStream inputStream=getAssets().open("cprogram.cpp");
                int size =inputStream.available();
                byte[] buffer =new byte[size];
                inputStream.read(buffer);
                inputStream.close();
                str =new String(buffer);

            }
            catch (IOException e){
                e.printStackTrace();
            }
    textView.setText((CharSequence)str);

        }

}
