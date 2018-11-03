package br.com.jokes.builditbigger;

import android.graphics.PorterDuff;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisplayJokeActivity extends AppCompatActivity {
    @BindView(R2.id.btn_next)
    FrameLayout btnNext;
    @BindView(R2.id.txt_joke)
    TextView txtJoke;
    @BindView(R2.id.img_background)
    ImageView imgBackground;
    @BindView(R2.id.adView)
    AdView adView;
    int[] imgList ={R.drawable.laugh_01,R.drawable.laugh_02,R.drawable.laugh_03,
            R.drawable.laugh_04,R.drawable.laugh_05,R.drawable.laugh_06};
    int[] colorList ={R.color.color1,R.color.color2,R.color.color3,
            R.color.color4,R.color.color5,R.color.color6};
    int[] darkColorList ={R.color.color1_dark,R.color.color2_dark,R.color.color3_dark,
            R.color.color4_dark,R.color.color5_dark,R.color.color6_dark};
    boolean isFree = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_joke);
        ButterKnife.bind(this);
        Random r = new Random();
        Glide.with(this).load(imgList[r.nextInt(5)]).into(imgBackground);
        txtJoke.setText(getIntent().getExtras().getString("joke"));
        isFree = getIntent().getExtras().getBoolean("isfree");
        int colorPos = r.nextInt(5);
        imgBackground.setColorFilter(ContextCompat.getColor(this, colorList[colorPos]), PorterDuff.Mode.LIGHTEN);

        getWindow().setStatusBarColor(ContextCompat.getColor(this, darkColorList[colorPos]));
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DisplayJokeActivity.this.setResult(RESULT_OK);
                DisplayJokeActivity.this.finish();
            }
        });

        if(isFree){
            MobileAds.initialize(this, getString(R.string.banner_ad_unit_id));
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }

    }
}
