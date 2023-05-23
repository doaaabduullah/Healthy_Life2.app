package com.example.healthylife2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class blood_pressure_Fragment extends Fragment {
    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup
            container, @NonNull Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_blood_pressure_,container,false);
        return view;
    }




}