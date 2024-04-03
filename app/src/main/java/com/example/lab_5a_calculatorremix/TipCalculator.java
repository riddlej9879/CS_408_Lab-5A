package com.example.lab_5a_calculatorremix;

import android.util.Log;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.view.LayoutInflater;

import android.annotation.SuppressLint;

import androidx.fragment.app.Fragment;
import com.example.lab_5a_calculatorremix.databinding.FragmentTipCalculatorBinding;

public class TipCalculator extends Fragment {
    private FragmentTipCalculatorBinding tipBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        tipBinding = FragmentTipCalculatorBinding.inflate(getLayoutInflater(), container,
                false);
        return tipBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tipBinding.calcBtn.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("DefaultLocale")
            @Override
            public void onClick(View view) {
                TextView output = tipBinding.splitOutputLbl;
                output.setTextAlignment(R.string.splitOutputText);
                double total = 0;
                double percent = 0;
                double people = 0;

                try {
                    if (!tipBinding.totalInput.getText().toString().isEmpty()) {
                        total = Double.parseDouble(tipBinding.totalInput.getText().toString());
                    }
                    if (!tipBinding.percentInput.getText().toString().isEmpty()) {
                        percent = Double.parseDouble(tipBinding.percentInput.getText().toString());
                    }
                    if(!tipBinding.peopleInput.getText().toString().isEmpty()) {
                        people = Double.parseDouble(tipBinding.peopleInput.getText().toString());
                    }
                }
                catch (NumberFormatException e) {
                    Log.e("Number format exception", e.toString());
                    output.setText(R.string.InputError);
                }
                if ((total <= 0) || (percent <= 0) || (people <= 0)) {
                    output.setText(R.string.InputMissing);
                } else if ((total > 0) && (percent > 0) && (people > 0)) {
                    Log.d("OUTPUT", "Tot: " + total);
                    Log.d("OUTPUT", "Per: " + percent);
                    Log.d("OUTPUT", "Ppl: " + people);
                    output.setText(
                            String.format("%.2f", (total + (total * (percent/100))) / people));
                } else {
                    output.setText(R.string.OutputError);
                }
            }
        });
    }

    public void onDestroyView() {
        super.onDestroyView();
        tipBinding = null;
    }
}