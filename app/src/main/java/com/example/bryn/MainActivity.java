package com.example.bryn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
//import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
//import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
//import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //    String print,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        EditText message = (EditText) findViewById(R.id.Edit_message);
        Intent intent = new Intent(this,
                DisplayMessageActivity.class);
        intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent);
        message.setText("");
    }


//public boolean onC
//        getMenuInflater().inflate(R.menu.more,menu);
//    return true;
//}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.more,menu);
        return true;
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
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
            default:

                return super.onOptionsItemSelected(item);
        }
    }
}
