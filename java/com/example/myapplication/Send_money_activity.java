
	 
	/*
	 *	This content is generated from the API File Info.
	 *	(Alt+Shift+Ctrl+I).
	 *
	 *	@desc 		
	 *	@file 		4__send_money
	 *	@date 		Saturday 04th of November 2023 10:03:19 PM
	 *	@title 		Page 1
	 *	@author 	
	 *	@keywords 	
	 *	@generator 	Export Kit v1.3.figma
	 *
	 */
	

package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

	public class Send_money_activity extends AppCompatActivity implements PaymentResultListener {


	private Button send_money;

	private EditText amountTxt;

	private EditText descriptionTxt;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.send_money);


		amountTxt = findViewById(R.id.amount_to_send);
		descriptionTxt = findViewById(R.id.description_txt);
		send_money = (Button) findViewById(R.id.send_money);


		Checkout.preload(Send_money_activity.this);
		//custom code goes here
		send_money.setOnClickListener(new View.OnClickListener() {
		@Override
		public void onClick(View view) {
			String description = descriptionTxt.getText().toString();
			String amount = amountTxt.getText().toString();
			StartPayment(description, Integer.parseInt(amount));
		}
	});
	}

		private void StartPayment(String description, int Amount) {
		Checkout checkout = new Checkout();
		checkout.setKeyID("rzp_test_tQuNFdoGn7hF7j");

		try
		{
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("name", "Cashtox");
			jsonObject.put("description",description);
			jsonObject.put("theme.color", "#FFBB86FC");
			jsonObject.put("currency", "INR");
			jsonObject.put("amount", Amount*100);

			JSONObject retryObject = new JSONObject();
			retryObject.put("enabled", true);
			retryObject.put("max_count", 4);

			jsonObject.put("retry", retryObject);

			checkout.open(Send_money_activity.this, jsonObject);

		} catch (Exception e) {
			Toast.makeText(Send_money_activity.this, "Something went wrong", Toast.LENGTH_LONG).show();
			throw new RuntimeException(e);
		}
		}

		@Override
		public void onPaymentSuccess(String s) {
		Intent intent = new Intent(Send_money_activity.this, Success_page_activity.class);
		startActivity(intent);
		}

		@Override
		public void onPaymentError(int i, String s) {

		}
	}
	
	