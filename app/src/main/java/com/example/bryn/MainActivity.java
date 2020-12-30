package com.example.bryn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
//import android.net.Uri;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.view.View.*;

//import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements View.OnClickListener{
private Button start,stop;
private static final String FILE_NAME="example.txt";
EditText m;


    private MyReceiver receive= new MyReceiver() {
        @Override
        public void onReceive(Context c,Intent i){
            int r=i.getIntExtra("level",0);
            ProgressBar bar=findViewById(R.id.Bar);
            bar.setProgress(r);
            TextView view =findViewById(R.id.view1);
            view.setText("charge the phone"+ Integer.toString(r)+"%");

        }

    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerReceiver(receive,new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

        start = findViewById(R.id.buttonstart);
        start.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                startService(intent);
            }
        });
          stop = findViewById(R.id.buttonstop);
        stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MyService.class);
                stopService(intent);
            }
        });

    }


    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.Edit_message);
        Intent intent = new Intent(this,
                DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }


    public void send(View view1) {
        EditText message = (EditText) findViewById(R.id.sav);
        Intent intent = new Intent(this,
                DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more,menu);
        return true;
    }

    public void onClick(View view){

        EditText editText=findViewById(R.id.alar);
        int b=Integer.parseInt(editText.getText().toString());
        Intent intent=new Intent(getApplicationContext(),MyReceiver.class);
        PendingIntent pendingIntent=PendingIntent.getBroadcast(this.getApplicationContext(),0,intent,0);
        AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+(b*1000),pendingIntent);
        Toast.makeText(this,"alarm set in"+ b +"seconds",Toast.LENGTH_LONG).show();


    }




    public boolean onOptionsItemSelected(@ NonNull MenuItem item) {
        int itemId1 = item.getItemId();
        switch (itemId1) {
            case R.id.music:
                startActivity(new Intent(this, tuk1.class));
                return true;
                // Intent a = new Intent(Intent.ACTION_VIEW, Uri.parse(nam1));

            case R.id.search:
                startActivity(new Intent(this, tuk.class));
                return true;

            case R.id.view:
                startActivity(new Intent(this, view.class));
                return true;
            case R.id.inte:
                startActivity(new Intent(this, Internal.class));
                return true;
            case R.id.ext:
                startActivity(new Intent(this, External.class));
                return true;



            case R.id.call:
                try {
                    // check for call permissions
                    int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);

                    // Here, thisActivity is the current activity
                    if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                        // Should we show an explanation?
                        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {

                            // Show an explanation to the user *asynchronously*
                            Toast.makeText(this, "This intends to call", Toast.LENGTH_LONG).show();

                        } else {

                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 1);

                        }
                    }
                    Intent contact = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0791256855"));
                    startActivity(contact);
                }
                catch (Exception e){
                    e.printStackTrace();
                }
                return true;
            // for creating email
            case R.id.email:
                Intent intent2 = new Intent(Intent.ACTION_SEND);
                intent2.setData(Uri.parse("mailto:"));
                String to []={"elinahnabasitu@gmail.com","maatemartin@gmail.com","nickie8283@gmail.com"};
                intent2.putExtra(Intent.EXTRA_EMAIL,to);
                intent2.putExtra(Intent.EXTRA_SUBJECT,"assignment");
                intent2.putExtra(Intent.EXTRA_TEXT,"u are reminded to send ur assignment in the aftrn thank you");
                intent2.setType("message/rfc822");
                startActivity(intent2);
                return true;
            default:

                return super.onOptionsItemSelected(item);
        }
    }



}



