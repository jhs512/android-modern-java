package com.example.sbs.myapplication.ui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class MainViewModel extends AndroidViewModel {
    @Inject
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
}
