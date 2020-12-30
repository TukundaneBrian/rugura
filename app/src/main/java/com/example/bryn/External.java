package com.example.bryn;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class External extends AppCompatActivity {
    Button save;
    Button load;
    EditText edtinput;
    String filename="";
    String filepath="";
    String filecontent="";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_external);


        save = findViewById(R.id.save);
        load = findViewById(R.id.load);
        edtinput = findViewById(R.id.ex);
        filename = "myFile.text";
        filepath = "MyFileDir";

        if (isexternalAvailableForRW()) {
            save.setEnabled(true);
        }
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                load.setText("");
                filecontent = edtinput.getText().toString().trim();
                if (!filecontent.equals("")) {
                    File myExternalFile = new File(getExternalFilesDir(filepath), filename);
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(myExternalFile);
                        fos.write(filecontent.getBytes());
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    edtinput.setText("");
                    Toast.makeText(getApplicationContext(), "saved on the external card", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "empty text field eneter something", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private boolean isexternalAvailableForRW() {
        String extStorageState = Environment.getExternalStorageState();
        if (extStorageState.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        }
        return false;
    }

}

