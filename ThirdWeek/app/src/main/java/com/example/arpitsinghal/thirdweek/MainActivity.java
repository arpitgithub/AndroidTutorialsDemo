package com.example.arpitsinghal.thirdweek;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {



   String mFilename="InternalDemoFile";
    Button mSave,mRead;
    EditText mData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSave= (Button) findViewById(R.id.button);
        mRead= (Button) findViewById(R.id.button2);
        mData=(EditText)findViewById(R.id.editText);


    }

    public void saveFile(View view){
        String data=mData.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = openFileOutput(mFilename, Context.MODE_PRIVATE);
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
        String data="";
        int tempChar;
        FileInputStream fin = null;
        try {
            fin = openFileInput(mFilename);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while((tempChar=fin.read())!=-1)
            {
                // converts integer to character
                data+=(char)tempChar;

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fin.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Log.i("Result",data);
        TextView displayData=(TextView) findViewById(R.id.textView);
        displayData.setText(data);
    }


}
