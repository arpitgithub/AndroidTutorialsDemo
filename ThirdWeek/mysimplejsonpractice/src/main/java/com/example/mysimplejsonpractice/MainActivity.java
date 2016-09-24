package com.example.mysimplejsonpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View v){

        String myJson="{\n" +
                "\t\"id\":123,\n" +
                "\t\"name\":\"Pankaj Kumar\",\n" +
                "\t\"permanent\":true,\n" +
                "\t\"address\":{\n" +
                "\t\t\t\"street\":\"El Camino Real\",\n" +
                "\t\t\t\"city\":\"San Jose\",\n" +
                "\t\t\t\"zipcode\":95014\n" +
                "\t\t},\n" +
                "\t\"phoneNumbers\":[9988664422, 1234567890],\n" +
                "\t\"role\":\"Developer\"\n" +
                "}";

        try {
            JSONObject jsonObject=new JSONObject(myJson);
            int id=jsonObject.getInt("id");
            Log.d("Click Method",""+id);

            JSONObject jsonObject1=jsonObject.getJSONObject("address");
            String street=jsonObject1.getString("street");
            Log.d("Click Method",street);





        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}
