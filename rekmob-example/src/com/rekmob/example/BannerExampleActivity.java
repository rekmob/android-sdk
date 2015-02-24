package com.rekmob.example;

import com.rekmob.ads.RekmobView;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class BannerExampleActivity extends Activity {

	static final String REKMOB_AD_UNIT_ID = "f8f21b476296437ea063c18549002c89";

	RekmobView rekmobView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	
	   /*
	    * We pull inflated RekmobView from root view of activity.
	    * see https://github.com/rekmob/android-sdk/wiki/Android-Banner-Ad-Integration, section 5.
	    */
		rekmobView = (RekmobView) findViewById(R.id.rekmobAdView);
		
		/*
		 * We set ad unit id obtained from rekmob.com
		 */
		rekmobView.setAdUnitId(REKMOB_AD_UNIT_ID);
		
		/*
		 * We request to load ad.
		 */
		rekmobView.loadAd();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		/*
		 * when activity is destroyed, we destroys RekmobInterstitial instance to deactivate of its internal broadcast receivers.
		 * Thus we cancel new ad requests.  
		 */
		if (rekmobView != null) {
			rekmobView.destroy();
		}
		super.onDestroy();
	}

}
