package codeui.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import codeui.chevent.R;
import pl.tajchert.sample.DotsTextView;

public class SplashActivity extends AppCompatActivity {

    private DotsTextView dotsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_splash);

        //progress
        dotsTextView = (DotsTextView) findViewById(R.id.dots);

        dotsTextView.start();


        Thread timerThread = new Thread() {
            public void run() {
                try {

                    sleep(3000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent intent = new Intent(SplashActivity.this, EventListActivity.class);
                    startActivity(intent);
                    dotsTextView.stop();
                }
            }
        };
        timerThread.start();
    }

    @Override
    protected void onPause() {

        super.onPause();
        finish();
    }

}
