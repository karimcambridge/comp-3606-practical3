package com.example.comp3606practical3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

	int allBackgroundColor = Color.argb(255, 255, 255, 255);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		View parentLayout = findViewById(android.R.id.content);

		Intent intent = getIntent();

		if(intent.hasExtra("BACKGROUND_COLOR")) {
			ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.second_container);
			allBackgroundColor = intent.getIntExtra("BACKGROUND_COLOR", 0);
			bgElement.setBackgroundColor(allBackgroundColor);
		}
		if(intent.hasExtra("SECOND_SCREEN_DATA")) {
			String firstScreenData = intent.getStringExtra("SECOND_SCREEN_DATA");
			if(!firstScreenData.isEmpty()) {
				Snackbar.make(parentLayout, "First screen sent: " + firstScreenData, Snackbar.LENGTH_LONG).setAction("Action", null).show();
			}
		}
		if(intent.hasExtra("THIRD_SCREEN_RESULT_DATA")) {
			int thirdScreenResultData = intent.getIntExtra("THIRD_SCREEN_RESULT_DATA", 0);
			int thirdScreenDataValue0 = intent.getIntExtra("THIRD_SCREEN_DATA_0", 0);
			int thirdScreenDataValue1 = intent.getIntExtra("THIRD_SCREEN_DATA_1", 0);
			if(thirdScreenResultData != 0) {
				String tsResult = "Third Screen sent: (" + thirdScreenDataValue0 + " * " + thirdScreenDataValue1 + ") = " + thirdScreenResultData;
				Snackbar.make(parentLayout, tsResult, Snackbar.LENGTH_LONG).setAction("Action", null).show();
			}
		}
	}

	public void goToFirstScreen(View storeView) {
		Intent i = new Intent(SecondActivity.this, MainActivity.class);
		i.putExtra("BACKGROUND_COLOR", allBackgroundColor);
		startActivity(i);
	}

	public void goToThirdScreen(View storeView) {
		Intent i = new Intent(SecondActivity.this, ThirdActivity.class);
		i.putExtra("BACKGROUND_COLOR", allBackgroundColor);
		i.putExtra("THIRD_SCREEN_DATA_0", new Random().nextInt(100));
		i.putExtra("THIRD_SCREEN_DATA_1", new Random().nextInt(100));
		startActivity(i);
	}
}
