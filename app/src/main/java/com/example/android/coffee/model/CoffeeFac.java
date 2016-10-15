package com.example.android.coffee.model;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by inframincer on 2016-10-15.
 */

public class CoffeeFac {

    private static CoffeeFac sCoffeeFac;

    private List<Coffee> mCoffees;

    public static CoffeeFac get(Context context) {
        if (sCoffeeFac == null) {
            sCoffeeFac = new CoffeeFac(context);
        }
        return sCoffeeFac;
    }

    public CoffeeFac(Context context) {
        mCoffees = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            Coffee coffee = new Coffee();
            coffee.setTitle("coffee #" + i);
            coffee.setKnown(i % 2 == 0);
            mCoffees.add(coffee);
        }
    }

    public List<Coffee> getCoffees() {
        return mCoffees;
    }

    public Coffee getCoffee(UUID id) {
        for (Coffee coffee : mCoffees) {
            if (coffee.getId().equals(id)) {
                return coffee;
            }
        }
        return null;
    }
}
