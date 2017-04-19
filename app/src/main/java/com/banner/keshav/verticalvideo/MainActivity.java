package com.banner.keshav.verticalvideo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;
import com.inmobi.sdk.InMobiSdk;

import java.util.Map;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity implements InMobiInterstitial.InterstitialAdListener2 {

    public static final String TAG = MainActivity.class.getSimpleName();
    InMobiInterstitial i;
    Button getAd;
    //  long PLACEMENT_ID = 1485516992909L;
    //  long PLACEMENT_ID = 1487726174530L;
    //  long PLACEMENT_ID = 1489083111295L;
    //  long PLACEMENT_ID = 1488008150634L;
    long PLACEMENT_ID = 1493464535892L;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_PORTRAIT);
        InMobiSdk.init(this, "489ecf303bb54bbb89b62b6c689ec677");
        setContentView(R.layout.activity_main);

        InMobiSdk.setLogLevel(InMobiSdk.LogLevel.DEBUG);

        getAd = (Button) findViewById(R.id.getAdButton);

        i = new InMobiInterstitial(this, PLACEMENT_ID, this);
        i.load();
        Log.d(TAG, "Interstitial Load ad");
//        showAd();
//        Log.d(TAG, "show method");
    }

    private void showAd() {
        getAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i.isReady()) {
                    Toast.makeText(MainActivity.this, "ad is ready", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "ad is ready");
                    i.show();

                } else {
                    Toast.makeText(MainActivity.this, "ad not yet ready", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "ad is not loaded");
                }

            }
        });
    }

    @Override
    public void onAdLoadFailed(InMobiInterstitial inMobiInterstitial, InMobiAdRequestStatus inMobiAdRequestStatus) {
        Log.d(TAG, "Failed Reason is: " + inMobiAdRequestStatus.getMessage());
    }

    @Override
    public void onAdReceived(InMobiInterstitial inMobiInterstitial) {
        Log.d(TAG, "onAdReceived");
    }

    @Override
    public void onAdLoadSucceeded(InMobiInterstitial inMobiInterstitial) {
        Log.d(TAG, "onAdLoadSuccessful");

    }

    @Override
    public void onAdRewardActionCompleted(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {

    }

    @Override
    public void onAdDisplayFailed(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdWillDisplay(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdDisplayed(InMobiInterstitial inMobiInterstitial) {

    }

    @Override
    public void onAdInteraction(InMobiInterstitial inMobiInterstitial, Map<Object, Object> map) {

    }

    @Override
    public void onAdDismissed(InMobiInterstitial inMobiInterstitial) {

    }


    @Override
    public void onUserLeftApplication(InMobiInterstitial inMobiInterstitial) {

    }
}
