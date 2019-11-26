package com.example.mywhatsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import de.hdodenhof.circleimageview.CircleImageView;

public class Settingsactivity extends AppCompatActivity {

    private Button UpdateButton;
    private EditText username,phnnum;
    private CircleImageView userProfileImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsactivity);
        InitializeFields();
    }

    private void InitializeFields() {
        UpdateButton = (Button) findViewById(R.id.update_button);
        username = (EditText) findViewById(R.id.set_user_name);
        phnnum=(EditText) findViewById(R.id.set_mobile_num);
        userProfileImage = (CircleImageView) findViewById(R.id.profile_image);
    }
}
