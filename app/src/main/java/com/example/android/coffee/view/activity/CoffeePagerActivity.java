package com.example.android.coffee.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.android.coffee.R;
import com.example.android.coffee.model.Coffee;
import com.example.android.coffee.model.CoffeeFac;
import com.example.android.coffee.view.fragment.CoffeeFragment;

import java.util.List;
import java.util.UUID;

/**
 * Created by inframincer on 2016-10-15.
 */

public class CoffeePagerActivity extends AppCompatActivity {

    private static final String EXTRA_COFFEE_ID =
            "com.example.android.coffee.coffee_id";

    private ViewPager mViewPager;
    private List<Coffee> mCoffees;

    public static Intent newIntent(Context packageContext, UUID coffeeId) {
        Intent intent = new Intent(packageContext, CoffeePagerActivity.class);
        intent.putExtra(EXTRA_COFFEE_ID, coffeeId);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coffee_pager);

        UUID coffeeId = (UUID) getIntent().getSerializableExtra(EXTRA_COFFEE_ID);

        mViewPager = (ViewPager) findViewById(R.id.activity_coffee_pager_view_pager);

        mCoffees = CoffeeFac.get(this).getCoffees();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int position) {
                Coffee coffee = mCoffees.get(position);
                return CoffeeFragment.newInstance(coffee.getId());
            }

            @Override
            public int getCount() {
                return mCoffees.size();
            }
        });

        for (int i = 0; i < mCoffees.size(); i++) {
            if (mCoffees.get(i).getId().equals(coffeeId)) {
                mViewPager.setCurrentItem(i);
                break;
            }
        }
    }
}
