package com.hp.pav.demojune6;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Thread thread;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        imageView = (ImageView)findViewById(R.id.freezlogo);
        imageView.setImageResource(R.drawable.logo);


        thread = new Thread(){
            @Override
            public void run() {
                super.run();

                try {


                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        };
        thread.start();
    }
}
