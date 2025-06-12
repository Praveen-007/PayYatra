package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class SplashScreenActivity extends AppCompatActivity {

    private View img_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Utils.blackIconStatusBar(SplashScreenActivity.this, R.color.light_Background);

        img_logo = findViewById(R.id.logo_cashtox);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, LoginOTP_activity.class);
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreenActivity.this,
                        img_logo, "logo");
                startActivity(intent, options.toBundle());
            }
        }, 3000);
    }
}