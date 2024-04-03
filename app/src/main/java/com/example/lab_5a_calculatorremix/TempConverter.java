package com.example.lab_5a_calculatorremix;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;
import com.example.lab_5a_calculatorremix.databinding.FragmentTempConverterBinding;

public class TempConverter extends Fragment {
    private FragmentTempConverterBinding tempBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tempBinding = FragmentTempConverterBinding.inflate(getLayoutInflater(), container,
                false);
        return tempBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tempBinding.convertTemp.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                TextView f = tempBinding.fahrenheitInput;
                TextView c = tempBinding.celsiusInput;
                double temp;

                try {
                    if (!f.getText().toString().isEmpty()) {
                        temp = Double.parseDouble(f.getText().toString());
                        c.setText(String.format("%.1f", ((temp - 32) / 1.8)));
                    } else if (!c.getText().toString().isEmpty()) {
                        temp = Double.parseDouble(c.getText().toString());
                        f.setText(String.format("%.1f", ((temp * 1.8) + 32)));
                    }
                }
                catch (NumberFormatException e) {
                    Log.d("Number format exception", e.toString());
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        tempBinding = null;
    }
}