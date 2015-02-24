package com.rekmob.example;

import com.rekmob.ads.RekmobView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BannerExampleActivity extends Activity {

	static final String REKMOB_AD_UNIT_ID = "e7fda455c07742f68b572904e2b80e0b";

	RekmobView rekmobView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Rekmob integration
		rekmobView = (RekmobView) findViewById(R.id.rekmobAdView);
		rekmobView.setAdUnitId(REKMOB_AD_UNIT_ID);
		rekmobView.loadAd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		if (rekmobView != null) {
			rekmobView.destroy();
		}
		super.onDestroy();
	}

}
