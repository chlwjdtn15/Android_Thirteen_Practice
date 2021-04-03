package com.example.week11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {



    EditText nameET;
    EditText ageET;
    JSONObject json;
    JSONArray jsonArray;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        jsonArray = new JSONArray();
        nameET = findViewById(R.id.editTextTextPersonName);
        ageET = findViewById(R.id.editTextNumber);
    }

    public void addUser(View view) {


        String name = nameET.getText().toString();
        int age = Integer.valueOf(ageET.getText().toString());
        json = new JSONObject();


        try {
            json.put("name", name);
            json.put("age", age);
            Log.d("Tag", "addUser" + json.toString());
            jsonArray.put(json);
            Log.d("Tag", "addUser" + jsonArray.toString());


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    public void displayData(View view) {

        TextView tv = findViewById(R.id.textView2);

        try {

            //getting data from JSON
            String name = json.getString("name");
            int age = json.getInt("age");

            tv.setText("Name is " + name + " and age is " + age);

            //getting data from JSON Array

            for(int i = 0; i < jsonArray.length(); i++){

                JSONObject obj = (JSONObject) jsonArray.get(i);

                String n = obj.getString("name");
                int a = obj.getInt("age");
                User u = new User(n,a);

                Log.d("TAg", "DisplayData: " + u.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
            Log.d("TAG", "displayData: Error");
        }

    }
}