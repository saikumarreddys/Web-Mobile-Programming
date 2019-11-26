package com.example.mywhatsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class GroupchatActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageButton imagebutton;
    private EditText editText;
    private ScrollView scrollView;
    private TextView textView;
    private  String currentGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groupchat);

        currentGroup = getIntent().getExtras().get("groupName").toString();
        Toast.makeText(GroupchatActivity.this,currentGroup,Toast.LENGTH_SHORT);

        InitializeFields();
    }

    private void InitializeFields() {

        toolbar= (Toolbar) findViewById(R.id.group_chat_layout);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(currentGroup);

        imagebutton = (ImageButton) findViewById(R.id.send_m);
        editText = (EditText) findViewById(R.id.input_g_message);
        textView = (TextView) findViewById(R.id.group_chat_text_display);
        scrollView = (ScrollView) findViewById(R.id.Scroll_View);
    }
}
