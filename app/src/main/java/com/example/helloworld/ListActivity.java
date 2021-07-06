package com.example.helloworld;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {
TextView textViewsh;
SharedPreferences preferences;
Button listAdd;
EditText textViewShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        textViewsh =findViewById(R.id.textViewShared);
        textViewShared =findViewById(R.id.textViewShared);
        listAdd = findViewById(R.id.ListActivity);
        preferences = getSharedPreferences("SHERD_PREF",MODE_PRIVATE);
        String  Name = preferences.getString("Name","");



        listAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textViewsh.getText().toString().trim().length() <= 0) {
                    Toast.makeText(ListActivity.this, "It's empty", Toast.LENGTH_SHORT).show();
                }

            }


        });
    }
}