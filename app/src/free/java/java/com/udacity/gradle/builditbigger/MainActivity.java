package java.com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.udacity.gradle.builditbigger.R;

import br.com.jokes.builditbigger.DisplayJokeActivity;


public class MainActivity extends AppCompatActivity {

    final InterstitialAd mInterstitialAd = new InterstitialAd(this);;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");

        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdLoaded() {
                mInterstitialAd.show();
            }
            @Override
            public void onAdClosed() {
                new EndpointAsynctask().execute(MainActivity.this);
            }
        });
        mInterstitialAd.loadAd(new AdRequest.Builder().build());


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void displayJoke(String joke) {
        Intent intent = new Intent(this, DisplayJokeActivity.class);
        intent.putExtra("joke",joke);
        startActivityForResult(intent, 1);
    }
}
