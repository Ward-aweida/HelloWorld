package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button nextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn;
        final int[] count = {0};
        TextView txv;
        btn =(Button) findViewById(R.id.button);
        txv=(TextView) findViewById(R.id.textV);
        TextView textViewAct2;

        nextPage = findViewById(R.id.nextPage);
        nextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity2();
            }


        });

        EditText   editTextName ;
        Button btnClickhere;
        TextView textName;
        editTextName=(EditText)findViewById(R.id.editTextName);
        btnClickhere =(Button)findViewById(R.id.btnClickhere);
        textName=(TextView) findViewById(R.id.textViewn);

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, "This is my text to send.");
        sendIntent.setType("text/plain");

        Intent shareIntent = Intent.createChooser(sendIntent, null);
        startActivity(shareIntent);
        btnClickhere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name=editTextName.getText().toString();
                textName.setText(Name);
            }
        });
       btn.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view ) {
               count[0]++ ;
               txv.setText("Hello World!" +":"+count[0]);

           }
       });



    }
    private void openMainActivity2() {
        Intent intent = new Intent(this,MainActivity2.class);
        startActivity(intent);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("PhrasesActivity", "onStart: Start");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.v("PhrasesActivity", "onPause: Pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("PhrasesActivity", "onRestart: Restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("PhrasesActivity", "onPause: Stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("PhrasesActivity", "onDestroy: Destroy");
    }
}
