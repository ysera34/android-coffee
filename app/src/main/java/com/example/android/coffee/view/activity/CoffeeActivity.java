package com.example.android.coffee.view.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.example.android.coffee.view.fragment.CoffeeFragment;

import java.util.UUID;

public class CoffeeActivity extends SingleFragmentActivity {

    private static final String EXTRA_COFFEE_ID =
            "com.example.android.coffee.coffee_id";

    @Override
    protected Fragment createFragment() {
//        return new CoffeeFragment();
        UUID coffeeId = (UUID) getIntent().getSerializableExtra(EXTRA_COFFEE_ID);
        return CoffeeFragment.newInstance(coffeeId);
    }

    public static Intent newIntent(Context packageContext, UUID coffeeId) {
        Intent intent = new Intent(packageContext, CoffeeActivity.class);
        intent.putExtra(EXTRA_COFFEE_ID, coffeeId);
        return intent;
    }
}
