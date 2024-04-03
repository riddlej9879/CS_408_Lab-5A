package com.example.lab_5a_calculatorremix;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab_5a_calculatorremix.databinding.TabFragmentBinding;

public class TabLayoutFragment extends Fragment {
    // Instances of this class are used for the individual fragments within the tabbed layout
    private TabFragmentBinding binding;
    public static final String ARG_ID = "id";

    @Nullable
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = TabFragmentBinding.inflate(getLayoutInflater(), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle args = getArguments();
        String id = Integer.toString(args.getInt(ARG_ID));
    }
}