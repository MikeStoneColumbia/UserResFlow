package com.example.userresflow;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView splashMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        splashMsg = findViewById(R.id.splashMessage);

        new CountDownTimer(4000,1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {

                goToNameInfo();

            }
        }.start();

    }


    public void goToNameInfo(){

        Intent i = new Intent(this,NameSignUp.class);
        startActivity(i);
        finish();


    }

}
