package com.example.externalstorage;

import android.content.Context;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    String mFilename="ExternalFileDemo";
    Button mSave,mRead;
    EditText mData;
    File myExternalFile;
    private String mFilepath = "MyFileStorage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSave= (Button) findViewById(R.id.button);
        mRead= (Button) findViewById(R.id.button2);
        mData=(EditText)findViewById(R.id.editText);
        myExternalFile = new File(getExternalFilesDir(mFilepath), mFilename);

    }

    public void saveFile(View view){
        String data=mData.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(myExternalFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            fos.write(data.getBytes());
            mData.setText("");
            Toast.makeText(this,""+getFilesDir(),Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readFile(View view){
        File directory = Environment.getExternalStorageDirectory();
        Toast.makeText(this,directory.toString(),Toast.LENGTH_SHORT).show();
        StringBuilder data=new StringBuilder("");
        File file = new File(directory + "/"+mFilename);
        if (!file.exists()) {
            throw new RuntimeException("File not found");
        }
        Log.e("Testing", "Starting to read");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line);
            }
            Toast.makeText(this,data,Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
