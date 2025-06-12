
	

package com.example.myapplication;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.os.Bundle;


import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginOTP_activity extends AppCompatActivity {

	private LinearLayout layoutLogin;

	private Animation animation_fadein;

	private Button otpVerify;
	private TextView sign_up_textview;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginotp);

		Utils.blackIconStatusBar(LoginOTP_activity.this, R.color.light_Background);


		otpVerify = findViewById(R.id.verify_otp);
		sign_up_textview = findViewById(R.id.signup_tv);




		otpVerify.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(LoginOTP_activity.this, VerifyOTP_activity.class);
				startActivity(intent);
			}
		});

		sign_up_textview.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(LoginOTP_activity.this, SignUpActivity.class);
				startActivity(intent);
			}
		});
		//custom code goes here
	
	}
}
	
	