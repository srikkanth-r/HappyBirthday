package com.srikkanth.swayapp;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

public class CountdownActivity extends AppCompatActivity {

    TextView txtCountDown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        txtCountDown = (TextView) findViewById(R.id.txtCountdown);

        txtCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(CountdownActivity.this, MainActivity.class));
            }
        });

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setTimeZone(TimeZone.getDefault());
        Date bdayDate = null;

        try {
            bdayDate = dateFormat.parse("21-05-2016");
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        new CountDownTimer(bdayDate.getTime() - System.currentTimeMillis(), 1000) {

            public void onTick(long millisUntilFinished) {

                int days = (int) ((millisUntilFinished / 1000) / 86400);

                int hours = (int) (((millisUntilFinished / 1000) - (days * 86400)) / 3600);

                int minutes = (int) (((millisUntilFinished / 1000) - (days * 86400) - (hours * 3600)) / 60);

                int seconds = (int) ((millisUntilFinished / 1000) % 60);

                String timeRemaining = days + " : " + hours + " : " + minutes + " : " + seconds;

                txtCountDown.setText(timeRemaining);
            }

            public void onFinish() {
                txtCountDown.setText("done!");
            }
        }.start();

    }
}
