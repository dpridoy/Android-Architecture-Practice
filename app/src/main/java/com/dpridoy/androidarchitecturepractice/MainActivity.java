package com.dpridoy.androidarchitecturepractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.dpridoy.androidarchitecturepractice.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        final ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.setUser();
        viewModel.getUser().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                binding.setModel(viewModel);
                binding.setUser(user);
            }
        });


    }
}
