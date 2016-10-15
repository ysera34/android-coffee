package com.example.android.coffee.view.activity;

import android.support.v4.app.Fragment;

import com.example.android.coffee.view.fragment.CoffeeListFragment;

/**
 * Created by inframincer on 2016-10-15.
 */

public class CoffeeListActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new CoffeeListFragment();
    }
}
