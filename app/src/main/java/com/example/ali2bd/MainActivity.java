package com.example.ali2bd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splash_part();

    }

    //animation splash
    private void splash_part() {
        iv=(ImageView)findViewById(R.id.imageLogo);

        Animation anime= AnimationUtils.loadAnimation(this,R.anim.splash);

        iv.startAnimation(anime);

        final Intent intent=new Intent(MainActivity.this,second_activity.class);

        Thread timer=new Thread(){
            public void run(){
                try{

                    sleep(5000);
                }catch (InterruptedException e){

                    e.printStackTrace();
                }

                finally {
                    startActivity(intent);
                    finish();
                }
            }

        };
        timer.start();

    }
    }

