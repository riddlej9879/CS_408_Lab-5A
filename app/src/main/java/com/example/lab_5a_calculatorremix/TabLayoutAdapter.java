package com.example.lab_5a_calculatorremix;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {
    public static final int NUM_TABS = 3;

    // Constructor
    public TabLayoutAdapter(Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Bundle args = new Bundle();
        Fragment fragment = new Fragment();
        switch(position) {
            case 0:
                fragment = new TipCalculator();
                args.putInt(TabLayoutFragment.ARG_ID, position);
                fragment.setArguments(args);
                break;
            case 1:
                fragment = new TempConverter();
                args.putInt(TabLayoutFragment.ARG_ID, position);
                fragment.setArguments(args);
                break;
            case 2:
                fragment = new DistConverter();
                args.putInt(TabLayoutFragment.ARG_ID, position);
                fragment.setArguments(args);
                break;
        }
        return fragment;
    }

    @Override
    public int getItemCount() {
        return NUM_TABS;
    }
}