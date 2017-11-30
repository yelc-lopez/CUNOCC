package com.example.administrador.cunocc;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScream extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_scream);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent =new Intent(SplashScream.this,MainActivity.class);
                startActivity(intent);
                finish();

            }
        },4030);

        //jonathanasdffffffffffffffffffffffffff
        // cinebtarios 12312323


    }
}
