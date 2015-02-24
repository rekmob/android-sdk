package com.rekmob.example;

import com.rekmob.ads.RekmobInterstitial;
import com.rekmob.ads.RekmobInterstitial.RekmobInterstitialAdListener;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class InterstitialActivity extends Activity implements RekmobInterstitialAdListener {

	RekmobInterstitial rekmobInterstitial;
	static final String INTERSTITIAL_AD_UNIT_ID="281819bf399e42ef83cf2fc4fcddffb9";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interstitial);
		
		rekmobInterstitial = new RekmobInterstitial(this,INTERSTITIAL_AD_UNIT_ID);
		rekmobInterstitial.setInterstitialAdListener(this);
	    rekmobInterstitial.load();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.interstitial, menu);
		return true;
	}

	@Override
	public void onInterstitialClicked(RekmobInterstitial arg0) {
		
	}

	@Override
	public void onInterstitialDismissed(RekmobInterstitial arg0) {
		
	}

	@Override
	public void onInterstitialFailed(RekmobInterstitial arg0, String arg1) {
		
	}

	@Override
	public void onInterstitialLoaded(RekmobInterstitial arg0) {
		 if (rekmobInterstitial.isReady()) {
	            rekmobInterstitial.show();
	        } else {
	            
	        }
	}

	@Override
	public void onInterstitialShown(RekmobInterstitial arg0) {
		
	}

}
