package com.example.test_retrofit_post.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.test_retrofit_post.R;
import com.example.test_retrofit_post.retrofit.call_api.UserCallApi;
import com.example.test_retrofit_post.model.Address;
import com.example.test_retrofit_post.model.User;

public class MainActivity extends AppCompatActivity {

    private User user1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openUser(View view) {
        Intent intent=new Intent(MainActivity.this,UserActivity.class);
        startActivity(intent);
    }

    public void openPost(View view) {
        Intent intent=new Intent(MainActivity.this,PostAcitivty.class);
        startActivity(intent);
    }
}