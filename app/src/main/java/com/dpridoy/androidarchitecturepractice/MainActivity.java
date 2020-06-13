package com.dpridoy.androidarchitecturepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.dpridoy.androidarchitecturepractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        user=new User();
        user.name="Nasirul Haque";
        user.email="dpridoy@gmail.com";
        binding.setUser(user);

    }
}
