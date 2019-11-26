package com.example.mywhatsapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class Settingsactivity extends AppCompatActivity {

    private Button UpdateButton;
    private EditText username,phnnum;
    private CircleImageView userProfileImage;
    private String currentUserID;
    private FirebaseAuth mAuth;
    private DatabaseReference dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settingsactivity);
        mAuth = FirebaseAuth.getInstance();
        currentUserID = mAuth.getCurrentUser().getUid();
        dbRef = FirebaseDatabase.getInstance().getReference();

        InitializeFields();
        RetrieveUserInfo();
        UpdateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                updateSettingstoDb();
            }
        });
    }



    private void InitializeFields() {
        UpdateButton = (Button) findViewById(R.id.update_button);
        username = (EditText) findViewById(R.id.set_user_name);
        phnnum=(EditText) findViewById(R.id.set_mobile_num);
        userProfileImage = (CircleImageView) findViewById(R.id.profile_image);
    }

    private void updateSettingstoDb() {

        String Username = username.getText().toString();
        String mobilenum =phnnum.getText().toString();

        if(TextUtils.isEmpty(Username))
        {
            Toast.makeText(this,"Please Enter your Name...",Toast.LENGTH_SHORT);
        }
        if(TextUtils.isEmpty(mobilenum))
        {
            Toast.makeText(this,"Please Enter your Mobile Number...",Toast.LENGTH_SHORT);
        }
        else
        {
            HashMap<String,String> UserMap = new HashMap<>();
            UserMap.put("uid",currentUserID);
            UserMap.put("name",Username);
            UserMap.put("phnnum",mobilenum);
            dbRef.child("Users").child(currentUserID).setValue(UserMap)
                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {

                            if(task.isSuccessful())
                            {
                                SenduserToMainActivity();
                                Toast.makeText(Settingsactivity.this,"Profile Updated Successfully",Toast.LENGTH_SHORT);
                            }
                            else
                            {
                                String message = task.getException().toString();
                                Toast.makeText(Settingsactivity.this,"Error:"+message,Toast.LENGTH_SHORT);
                            }


                        }
                    });
        }
    }

    private void RetrieveUserInfo()
    {
        dbRef.child("Users").child(currentUserID)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.exists() && ((dataSnapshot.hasChild("name") && (dataSnapshot.hasChild("image")))))
                        {
                            String Retusername = dataSnapshot.child("name").getValue().toString();
                            String Retphnnum = dataSnapshot.child("phnnum").getValue().toString();
                            String image = dataSnapshot.child("image").getValue().toString();

                            username.setText(Retusername);
                            phnnum.setText(Retphnnum);


                        }
                        else if(dataSnapshot.exists() && (dataSnapshot.hasChild("name")))
                        {
                            String Retusername = dataSnapshot.child("name").getValue().toString();
                            String Retphnnum = dataSnapshot.child("phnnum").getValue().toString();


                            username.setText(Retusername);
                            phnnum.setText(Retphnnum);

                        }
                        else
                        {
                            Toast.makeText(Settingsactivity.this,"Please Enter your Pofile Details..",Toast.LENGTH_SHORT);
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
    }

    private void SenduserToMainActivity() {
        Intent mainintent = new Intent(Settingsactivity.this, MainActivity.class);
        mainintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(mainintent);
        finish();
    }
}
