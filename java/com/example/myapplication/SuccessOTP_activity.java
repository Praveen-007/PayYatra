
	 
	/*
	 *
	 *	@desc 		
	 *	@file 		4
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *
	 */
	

package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;


import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

	public class SuccessOTP_activity extends AppCompatActivity {

	
	private LottieAnimationView lottieSuccess;

	private TextView continu;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.successotp);


		lottieSuccess = findViewById(R.id.lottie_success);
		continu = findViewById(R.id.continu_btn);


		continu.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(SuccessOTP_activity.this, Homepage_activity.class);
				startActivity(intent);
			}
		});
		
		//custom code goes here
	
	}
}
	
	