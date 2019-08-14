package com.ilham.aplikasiku;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                if (Preferences.getLoggedInStatus(getBaseContext())){
                    Intent home = new Intent(SplashScreenActivity.this, MainActivity.class);
                    startActivity(home);
                    finish();
                }else {
                    Intent home = new Intent(SplashScreenActivity.this, WalkthroughActivity.class);
                    startActivity(home);
                    finish();
                }
            }
        },2000);

    }
}
