package com.example.android.coffee.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.example.android.coffee.R;
import com.example.android.coffee.model.Coffee;
import com.example.android.coffee.model.CoffeeFac;

import java.util.UUID;

/**
 * Created by inframincer on 2016-10-15.
 */

public class CoffeeFragment extends Fragment {

    private static final String ARG_COFFEE_ID = "coffee_id";

    private Coffee mCoffee;
    private EditText mTitleField;
    private Button mDateButton;
    private CheckBox mKnownCheckBox;

    public static CoffeeFragment newInstance(UUID coffeeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_COFFEE_ID, coffeeId);

        CoffeeFragment fragment = new CoffeeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        mCoffee = new Coffee();
//        UUID coffeeId = (UUID) getActivity().getIntent()
//                .getSerializableExtra(CoffeeActivity.EXTRA_COFFEE_ID);
        UUID coffeeId = (UUID) getArguments().getSerializable(ARG_COFFEE_ID);
        mCoffee = CoffeeFac.get(getActivity()).getCoffee(coffeeId);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_coffee, container, false);
        mTitleField = (EditText) view.findViewById(R.id.coffee_title);
        mTitleField.setText(mCoffee.getTitle());
        mTitleField.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mCoffee.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        mDateButton = (Button) view.findViewById(R.id.coffee_date);
        mDateButton.setText(mCoffee.getDate().toString());

        mKnownCheckBox = (CheckBox) view.findViewById(R.id.coffee_known);
        mKnownCheckBox.setChecked(mCoffee.isKnown());
        mKnownCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mCoffee.setKnown(isChecked);
            }
        });
        return view;
    }
}
