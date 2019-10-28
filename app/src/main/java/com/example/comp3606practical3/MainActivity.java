package com.example.comp3606practical3;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

	int allBackgroundColor = Color.argb(255, 255, 255, 255);

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toolbar toolbar = findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);

		Intent intent = getIntent();

		if(intent.hasExtra("BACKGROUND_COLOR")) {
			ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.main_container);
			allBackgroundColor = intent.getIntExtra("BACKGROUND_COLOR", 0);
			bgElement.setBackgroundColor(allBackgroundColor);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();

		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}

		return super.onOptionsItemSelected(item);
	}

	public void goToSecondScreen(View view) {
		String testData = "Hi, this data is for the Second Screen.";
		Intent i = new Intent(MainActivity.this, SecondActivity.class);
		i.putExtra("BACKGROUND_COLOR", allBackgroundColor);
		i.putExtra("SECOND_SCREEN_DATA", testData);
		startActivity(i);

		//Snackbar.make(view, "Going to second screen", Snackbar.LENGTH_LONG).setAction("Action", null).show();
	}

	public void setRandomBackgroundColor(View view) {
		ConstraintLayout bgElement = (ConstraintLayout) findViewById(R.id.main_container);

		Random rnd = new Random();
		allBackgroundColor = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
		bgElement.setBackgroundColor(allBackgroundColor);
	}
}
