package com.arslanovic.justdrink;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoadActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        mAuth = FirebaseAuth.getInstance();
        Context context = this;
        ImageView image = findViewById(R.id.startLogoImageview);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.rotate);
        image.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                image.clearAnimation();
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser != null){
                    startActivity(new Intent(context, MainActivity.class));
                }
                else {
                    startActivity(new Intent(context, SignInUpActivity.class));
                }
            }
        }, animation.getDuration());
    }
}