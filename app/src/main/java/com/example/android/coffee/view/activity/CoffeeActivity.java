package com.example.android.coffee.view.activity;

import android.support.v4.app.Fragment;

import com.example.android.coffee.view.fragment.CoffeeFragment;

public class CoffeeActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CoffeeFragment();
    }
}
