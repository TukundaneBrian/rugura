package com.example.bryn;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.view.Gravity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver  {


    public void onReceive(Context context, Intent intent) {
            Toast toast=Toast.makeText(context,"dont panilk but ur time z up",Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER,0,0);
            toast.show();
            // vibrate
            Vibrator vibrator=(Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(3000);
    }
}
