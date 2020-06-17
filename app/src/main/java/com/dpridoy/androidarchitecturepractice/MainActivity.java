package com.dpridoy.androidarchitecturepractice;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.DialogInterface;
import android.os.Bundle;

import com.dpridoy.androidarchitecturepractice.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainViewModel.MainNavigator {

    MainViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        final ActivityMainBinding binding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        viewModel.setNavigator(this);
        viewModel.setUser();
        viewModel.getUser().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                binding.recyclerView.setAdapter(new MainAdapter(users,viewModel));
            }
        });


    }

    @Override
    public void onItemClick(final User user) {
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setMessage(user.name+"\n"+user.email);

        if(user.isMark.get()){
            alert.setPositiveButton("UN-MARK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    user.isMark.set(false);
                    dialog.dismiss();
                }
            });
        }else {
            alert.setPositiveButton("MARK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    user.isMark.set(true);
                    dialog.dismiss();
                }
            });
        }


        alert.show();
    }
}
