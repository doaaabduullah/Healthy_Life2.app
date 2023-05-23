package com.example.healthylife2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Logout extends Fragment {

    Button btnlogout;
    DBHelper myDB;
    TextView logout0;

    @NonNull
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @NonNull ViewGroup
            container, @NonNull Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_logout, container, false);
        return view;
    }





}



