package com.example.first_app;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
public class CompleatActivity extends AppCompatActivity {
    Button btnSmsOpen, btnAlarmSet, btnMakeCall, btnEmailSend, btnMapLocate, btnBack_2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compleat);
        btnBack_2 = findViewById(R.id.btnBack_2);
        btnSmsOpen = findViewById(R.id.btnSmsOpen);
        btnAlarmSet = findViewById(R.id.btnAlarmSet);
        btnMakeCall = findViewById(R.id.btnMakeCall);
        btnMapLocate = findViewById(R.id.btnMapLocate);
        btnEmailSend = findViewById(R.id.btnEmailSend);
        btnMapLocate.setOnClickListener(v -> {
            int btnClick = v.getId();
            if (btnClick == R.id.btnMapLocate) {
                String location = "geo:31.926852,35.205561";
                Uri geoLocUri = Uri.parse(location);
                Intent i = new Intent(Intent.ACTION_VIEW, geoLocUri);
                startActivity(i);
            }
        });

        btnEmailSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int btnClick = v.getId();
                if (btnClick == R.id.btnEmailSend) {
                    String[] addresses = {"test@gmail.com"};
                    String[] ccs = {"user@gmail.com"};
                    String subject = "Test";
                    String message = "Dear User \n This is test email";
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setData(Uri.parse("mailto:"));
                    i.putExtra(Intent.EXTRA_EMAIL, addresses);
                    i.putExtra(Intent.EXTRA_SUBJECT, subject);
                    i.putExtra(Intent.EXTRA_CC, ccs);
                    i.putExtra(Intent.EXTRA_TEXT, message);
                    startActivity(i);
                }
            }
        });
        btnMakeCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View y) {
                int btnClick = y.getId();
                if (btnClick == R.id.btnMakeCall) {
                    String phoneNumber = "1-800-555-1212";
                    Uri numUri = Uri.parse("tel:" + phoneNumber);

                    Intent i = new Intent(Intent.ACTION_DIAL);
                    i.setData(numUri);
                    startActivity(i);
                }
            }
        });
        btnAlarmSet.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                int btnClick = v.getId();
                if (btnClick == R.id.btnAlarmSet) {
                    final String message = "This Is The Time To wake up!";
                    final int hour = 2;
                    final int minutes = 15;
                    Intent i = new Intent(AlarmClock.ACTION_SET_ALARM)
                            .putExtra(AlarmClock.EXTRA_MESSAGE, message)
                            .putExtra(AlarmClock.EXTRA_HOUR, hour)
                            .putExtra(AlarmClock.EXTRA_MINUTES, minutes)
                            .putExtra(AlarmClock.EXTRA_VIBRATE, true);
                    startActivity(i);
                }
            }
        });
        btnSmsOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int btnClick = v.getId();
                if (btnClick == R.id.btnSmsOpen) {
                    final String message = "This is a text message";
                    Intent i = new Intent(Intent.ACTION_SENDTO);
                    i.setData(Uri.parse("sms:Thanks to send sms ! "));
                    i.putExtra("sms", message);
                    startActivity(i);
                }
            }
        });
        btnBack_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openButtonActivity();
            }
        });
    }
    private void openButtonActivity() {
        Intent intent = new Intent(this, ButtonActivity.class);
        startActivity(intent);
    }
}
