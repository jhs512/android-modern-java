package com.example.sbs.myapplication.ui.homeMain;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sbs.myapplication.R;
import com.example.sbs.myapplication.databinding.FragmentHomeMainBinding;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class HomeMainFragment extends Fragment {
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        FragmentHomeMainBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_main, container, false);
        binding.setLifecycleOwner(this);
        HomeMainViewModel vm = new ViewModelProvider(this).get(HomeMainViewModel.class);
        binding.setVm(vm);
        vm.initView(binding);

        return binding.getRoot();
    }
}