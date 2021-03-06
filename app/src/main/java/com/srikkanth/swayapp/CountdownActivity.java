package com.srikkanth.swayapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class CountdownActivity extends AppCompatActivity {

    TextView txtCountDown;
    EditText mPassword;
    ImageButton btnEnterPassword;
    TextView hintText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countdown);

        mPassword = (EditText) findViewById(R.id.password);

        btnEnterPassword = (ImageButton) findViewById(R.id.btnPassword);

        hintText = (TextView) findViewById(R.id.hintText);

        txtCountDown = (TextView) findViewById(R.id.txtCountdown);

        txtCountDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(CountdownActivity.this, MainActivity.class));
                mPassword.setVisibility(View.VISIBLE);
                btnEnterPassword.setVisibility(View.VISIBLE);
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
                txtCountDown.setText("Happy birthday !");
//                txtCountDown.setTextAppearance(getApplicationContext(), android.R.style.TextAppearance_Medium);
                mPassword.setVisibility(View.VISIBLE);
                btnEnterPassword.setVisibility(View.VISIBLE);
                hintText.setVisibility(View.VISIBLE);

            }
        }.start();

    }

    public void checkPassword(View view)
    {
        String strPassword = mPassword.getText().toString();

        if(strPassword.equalsIgnoreCase("otter"))
        {
            Toast.makeText(this, "Password Accepted", Toast.LENGTH_LONG).show();
            startActivity(new Intent(CountdownActivity.this, MainActivity.class));
        }
        else
        {
            Toast.makeText(this, "Hermione would be so disappointed !!!", Toast.LENGTH_LONG).show();
        }
    }
}
