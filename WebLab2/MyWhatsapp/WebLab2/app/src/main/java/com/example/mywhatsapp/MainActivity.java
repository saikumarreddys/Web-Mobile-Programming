package com.example.mywhatsapp;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import android.os.Bundle;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = (Toolbar) findViewById(R.id.main_page_toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("MYWhatsapp");

    }
}
