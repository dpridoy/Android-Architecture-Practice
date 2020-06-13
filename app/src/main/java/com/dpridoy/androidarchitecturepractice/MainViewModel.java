package com.dpridoy.androidarchitecturepractice;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<User>> user=new MutableLiveData<>();

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<List<User>> getUser(){
        setUser();
        return user;
    }

    public void setUser(){
        List<User> users=new ArrayList<>();
        users.add(new User("Ridoy 1","dpridoy@gmail.com"));
        users.add(new User("Ridoy 2","dpridoy@gmail.com"));
        users.add(new User("Ridoy 3","dpridoy@gmail.com"));
        users.add(new User("Ridoy 4","dpridoy@gmail.com"));
        users.add(new User("Ridoy 5","dpridoy@gmail.com"));
        users.add(new User("Ridoy 6","dpridoy@gmail.com"));
        this.user.setValue(users);
    }

}
