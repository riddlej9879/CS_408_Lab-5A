package com.example.lab_5a_calculatorremix;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;
import com.example.lab_5a_calculatorremix.databinding.FragmentDistConverterBinding;

public class DistConverter extends Fragment {
    private FragmentDistConverterBinding distBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        distBinding = FragmentDistConverterBinding.inflate(getLayoutInflater(), container,
                false);
        return distBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        distBinding.convertDist.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                TextView m = distBinding.mileInput;
                TextView k = distBinding.kilometerInput;
                double dist;

                try {
                    if (!m.getText().toString().isEmpty()) {
                        dist = Double.parseDouble(m.getText().toString());
                        k.setText(String.format("%.1f", (dist * 1.609)));
                    } else if (!k.getText().toString().isEmpty()) {
                        dist = Double.parseDouble(k.getText().toString());
                        m.setText(String.format("%.1f", (dist / 1.609)));
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
        distBinding = null;
    }
}