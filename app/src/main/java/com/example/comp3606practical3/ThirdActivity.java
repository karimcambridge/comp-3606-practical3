package com.example.comp3606practical3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

	int allBackgroundColor = Color.argb(255, 255, 255, 255);
	int secondScreenValue0 = 0;
	int secondScreenValue1 = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_third);

		Intent intent = getIntent();
		if(intent.hasExtra("BACKGROUND_COLOR")) {
			ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.third_container);
			allBackgroundColor = intent.getIntExtra("BACKGROUND_COLOR", 0);
			bgElement.setBackgroundColor(allBackgroundColor);
		}
		secondScreenValue0 = getIntent().getIntExtra("THIRD_SCREEN_DATA_0", 0);
		secondScreenValue1 = getIntent().getIntExtra("THIRD_SCREEN_DATA_1", 0);
	}

	public void goToSecondScreen(View storeView) {
		Intent i = new Intent(ThirdActivity.this, SecondActivity.class);
		i.putExtra("BACKGROUND_COLOR", allBackgroundColor);
		i.putExtra("THIRD_SCREEN_DATA_0", secondScreenValue0);
		i.putExtra("THIRD_SCREEN_DATA_1", secondScreenValue1);
		i.putExtra("THIRD_SCREEN_RESULT_DATA", secondScreenValue0 * secondScreenValue1);
		startActivity(i);
	}
}
