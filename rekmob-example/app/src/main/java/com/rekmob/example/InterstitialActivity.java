package com.rekmob.example;

import com.rekmob.ads.RekmobErrorCode;
import com.rekmob.ads.RekmobInterstitial;


import android.os.Bundle;
import android.app.Activity;
import android.util.Log;


public class InterstitialActivity extends Activity implements
		RekmobInterstitial.InterstitialAdListener {

	RekmobInterstitial rekmobInterstitial;
	static final String INTERSTITIAL_AD_UNIT_ID = "ef2e9e7470f94d15b740159eeea28215";

	static final String TAG = "InterstitialActivity";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_interstitial);

		/*
		 * for creating RekmobInterstitial instance, current activity (Activity)
		 * and interstital ad unit id (String) are passed as arguments to
		 * contructor method.
		 */
		rekmobInterstitial = new RekmobInterstitial(this,
				INTERSTITIAL_AD_UNIT_ID);

		/*
		 * To listen state of intersistial ad request, we set current activity
		 * as an listener. Our activity impliments RekmobInterstitialAdListener,
		 * and its method implimented below.
		 */
		rekmobInterstitial.setInterstitialAdListener(this);

		/*
		 * we request to load ad
		 */
		rekmobInterstitial.load();
	}



	@Override
	protected void onDestroy() {
		/*
		 * when activity is destroyed, we destroys RekmobInterstitial instance to deactivate of its internal broadcast receivers.
		 * Thus we cancel new ad requests.  
		 */
		if (rekmobInterstitial != null) {
			rekmobInterstitial.destroy();
		}
		super.onDestroy();
	}

	/*
	 * when ad is clicked, onInterstitialClicked method of an
	 * RekmobInterstitialAdListener instance is fired by Rekmob-SDK
	 */
	@Override
	public void onInterstitialClicked(RekmobInterstitial arg0) {

	}

	/*
	 * when ad is dismissed, onInterstitialDismissed method of an
	 * RekmobInterstitialAdListener instance is fired by Rekmob-SDK
	 */
	@Override
	public void onInterstitialDismissed(RekmobInterstitial arg0) {

	}

	/*
	 * In case of fail on loading or showing of ad, onInterstitialFailed method
	 * of an RekmobInterstitialAdListener instance is fired by Rekmob-SDK and a
	 * message about failing is passed to method.
	 */
	@Override
	public void onInterstitialFailed(RekmobInterstitial arg0, RekmobErrorCode errorCode) {
		Log.e(TAG, errorCode.toString());
	}

	/*
	 * When ad loaded , onInterstitialLoaded method is fired. If ad is ready to
	 * show, it can be invoked "show" method of RekmobInterstitial instance.
	 */
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
