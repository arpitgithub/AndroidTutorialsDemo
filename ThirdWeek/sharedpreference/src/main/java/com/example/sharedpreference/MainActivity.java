package com.example.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MyPreferenceFile";
    EditText mUsername,mPassword;
    Button mSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUsername= (EditText) findViewById(R.id.editText);
        mPassword= (EditText) findViewById(R.id.editText2);
        mSave=(Button)findViewById(R.id.button);
    }

    public void savePreference(View v){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("username",mUsername.getText().toString() );
        editor.putString("password", mPassword.getText().toString());
        editor.commit();
    }
    public void showPreference(View v) {
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        String uname=settings.getString("username","Default User");
        Toast.makeText(this,uname,Toast.LENGTH_SHORT).show();
    }
}
