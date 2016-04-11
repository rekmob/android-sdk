package com.rekmob.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
	}

	public void goToBannerActivity(View v){
		Intent intent = new Intent(this,BannerExampleActivity.class);
		startActivity(intent);
	}
	
	public void goToInterstialActivity(View v){
		Intent intent = new Intent(this,InterstitialActivity.class);
		startActivity(intent);
	}
	


}
