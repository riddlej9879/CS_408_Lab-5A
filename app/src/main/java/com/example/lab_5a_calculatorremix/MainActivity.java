package com.example.lab_5a_calculatorremix;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab_5a_calculatorremix.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private static final String TAG_MAIN = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }
}