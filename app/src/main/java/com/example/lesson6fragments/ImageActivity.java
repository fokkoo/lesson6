package com.example.lesson6fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;

public class ImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // первый запуск
            ImageFragment fragment = new ImageFragment();
            fragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.image_contaner, fragment)
                    .commit();


            /*
            ExersicesTextFragment exersicesTextFragment = new ExersicesTextFragment();
            exersicesTextFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.image_contaner, exersicesTextFragment)
                    .commit();
                    */

        }
    }

}