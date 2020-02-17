package com.example.bryn;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {


//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        TextView messageView =(TextView)findViewById(R.id.messageTextView);
        messageView.setText(message); }
    public void sendMessage(View view) {
        EditText message = (EditText)findViewById(R.id.Edit_message);
    Intent intent = new Intent(this,
            DisplayMessageActivity.class);
    intent.putExtra("MESSAGE", message.getText().toString());
        startActivity(intent); message.setText(""); }
//
    public void onClose(View view) {
        super.finish();

    }

}
