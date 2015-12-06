package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.jokeactivity.JokeActivity;


public class MainActivity extends AppCompatActivity {

    private InterstitialAd interstitialAd;
    private String joke;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();
                showJokeAfterAd();
            }
        });

        requestNewInterstitial();
    }

    public void tellJoke(View view) {
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(this);
    }

    public void showJoke(final String joke) {
        this.joke = joke;
        showInterstitial();
        progressBar.setVisibility(View.GONE);
    }

    private void showJokeAfterAd() {
        Intent intent = new Intent(this, JokeActivity.class);
        intent.putExtra(JokeActivity.EXTRA_MESSAGE, joke);
        this.startActivity(intent);
    }

    private void showInterstitial() {
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            showJokeAfterAd();
        }
    }

    private void requestNewInterstitial() {
        AdRequest interstitialAdRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(interstitialAdRequest);
    }
}
