
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		2
	 *	@date 		Saturday 04th of November 2023 05:13:40 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;


import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

	public class VerifyOTP_activity extends AppCompatActivity {

		private EditText et1;
		private EditText et2;
		private EditText et3;
		private EditText et4;
		private Button confirm;
		private TextView resendcode;
		private boolean resendEnabled = false;

		private int resendTime = 60;
	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.verifyotp);


		confirm = findViewById(R.id.btnverify);
		et1 = findViewById(R.id.et1);
		et2 = findViewById(R.id.et2);
		et3 = findViewById(R.id.et3);
		et4 = findViewById(R.id.et4);
		resendcode = findViewById(R.id.resend_code);


		confirm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(VerifyOTP_activity.this, SuccessOTP_activity.class);
				startActivity(intent);
			}
		});
		
		//custom code goes here
		et1.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start,int before, int count)
			{
				// TODO Auto-generated method stub
				if(et1.getText().toString().length()==1)     //size as per your requirement
				{
					et2.requestFocus();
				}
			}
			public void beforeTextChanged(CharSequence s, int start,
										  int count, int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}

		});

		et2.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start,int before, int count)
			{
				// TODO Auto-generated method stub
				if(et2.getText().toString().length()==1)     //size as per your requirement
				{
					et3.requestFocus();
				}
			}
			public void beforeTextChanged(CharSequence s, int start,
										  int count, int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}

		});

		et3.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start,int before, int count)
			{

				// TODO Auto-generated method stub
				if(et3.getText().toString().length()==1)     //size as per your requirement
				{
					et4.requestFocus();
				}
			}
			public void beforeTextChanged(CharSequence s, int start,
										  int count, int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}

		});

		et4.addTextChangedListener(new TextWatcher() {

			public void onTextChanged(CharSequence s, int start,int before, int count)
			{

			}
			public void beforeTextChanged(CharSequence s, int start,
										  int count, int after) {
				// TODO Auto-generated method stub

			}

			public void afterTextChanged(Editable s) {
				// TODO Auto-generated method stub
			}

		});
		startCountDownTimer();
		resendcode.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if(resendEnabled){

					startCountDownTimer();
				}
			}
		});

	}

	private void startCountDownTimer(){
		resendEnabled = false;
		resendcode.setTextColor(Color.parseColor("#99000000"));
	    new CountDownTimer(resendTime * 60, 100){

			@Override
			public void onTick(long l) {
				resendcode.setText("Resend Code ("+(l/60)+")");
			}

			@Override
			public void onFinish() {
				resendEnabled = true;
				resendcode.setText("Resend Code");
				resendcode.setTextColor(getResources().getColor(R.color.primary));
			}
		}.start();
	}
}
	
	