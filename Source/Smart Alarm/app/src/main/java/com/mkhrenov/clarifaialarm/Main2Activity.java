package com.mkhrenov.clarifaialarm;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        img = findViewById(R.id.imgview);
        Animation aniRotate = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        img.startAnimation(aniRotate);

        mHandler.postDelayed(new Runnable() {
            public void run() {
                doStuff();
            }
        }, 5000);
    }

    private void doStuff() {
        Intent intent = new Intent(Main2Activity.this, MainActivity.class);

        startActivity(intent);
    }
}
