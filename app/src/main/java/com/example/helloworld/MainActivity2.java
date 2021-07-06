package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class MainActivity2 extends AppCompatActivity {
    Button lastPage;
    TextView textViewSherd;
    Button ListAdd;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        lastPage= findViewById(R.id.lastPage);
        lastPage.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                openActivityMain();
            }
        });

        textViewSherd =findViewById(R.id.textViewShared);
        ListAdd=findViewById(R.id.ListActivity);
        preferences = getSharedPreferences("SHERD_PREF",MODE_PRIVATE);
        String  Name = preferences.getString("Name","");
        textViewSherd.setText(Name);


    }

    private void openActivityMain() {
        Intent intent=new Intent(this,MainActivity.class);

        startActivity(intent);
    }


}


