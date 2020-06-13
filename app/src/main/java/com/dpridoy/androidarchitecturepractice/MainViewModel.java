package com.dpridoy.androidarchitecturepractice;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<User> user=new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<User> getUser(){
        setUser();
        return user;
    }

    public void setUser(){
        User user=new User();
        user.name="Nasirul Haque";
        user.email="dpridoy@gmail.com";
        this.user.setValue(user);
    }

    public void updateUser(){
        User user=new User();
        user.name="Test";
        user.email="test@gmail.com";
        this.user.setValue(user);
    }
}
