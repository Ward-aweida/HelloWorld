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




    }

    private void openActivityMain() {
        Intent intent=new Intent(this,MainActivity.class);

        startActivity(intent);
    }


}


