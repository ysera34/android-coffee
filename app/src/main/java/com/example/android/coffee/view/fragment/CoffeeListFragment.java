package com.example.android.coffee.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.coffee.R;
import com.example.android.coffee.model.Coffee;
import com.example.android.coffee.model.CoffeeFac;
import com.example.android.coffee.view.activity.CoffeeActivity;

import java.util.List;

/**
 * Created by inframincer on 2016-10-15.
 */
public class CoffeeListFragment extends Fragment {

    private RecyclerView mCoffeeRecyclerView;
    private CoffeeAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_coffee_list, container, false);
        mCoffeeRecyclerView = (RecyclerView) view.findViewById(R.id.coffee_recycler_view);
        mCoffeeRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        updateUI();

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI() {
        CoffeeFac coffeeFac = CoffeeFac.get(getActivity());
        List<Coffee> coffees = coffeeFac.getCoffees();

        if (mAdapter == null) {
            mAdapter = new CoffeeAdapter(coffees);
            mCoffeeRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.notifyDataSetChanged();
        }
    }

    private class CoffeeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        public TextView mTitleTextView;
        private TextView mTitleTextView;
        private TextView mDateTextView;
        private CheckBox mKnownCheckBox;
        private Coffee mCoffee;

        public CoffeeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

//            mTitleTextView = (TextView) itemView;
            mTitleTextView = (TextView)
                    itemView.findViewById(R.id.list_item_coffee_title_text_view);
            mDateTextView = (TextView)
                    itemView.findViewById(R.id.list_item_coffee_date_text_view);
            mKnownCheckBox = (CheckBox)
                    itemView.findViewById(R.id.list_item_coffee_known_check_box);
        }

        public void bindCoffee(Coffee coffee) {
            mCoffee = coffee;
            mTitleTextView.setText(mCoffee.getTitle());
            mDateTextView.setText(mCoffee.getDate().toString());
            mKnownCheckBox.setChecked(mCoffee.isKnown());
            mKnownCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    mCoffee.setKnown(isChecked);
                }
            });
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(getActivity(),
                    mCoffee.getTitle() + " selected!!", Toast.LENGTH_SHORT).show();
//            mCoffeeRecyclerView.getAdapter().notifyItemMoved(getAdapterPosition(), 0);

//            Intent intent = new Intent(getActivity(), CoffeeActivity.class);
            Intent intent = CoffeeActivity.newIntent(getActivity(), mCoffee.getId());
            startActivity(intent);
        }
    }

    private class CoffeeAdapter extends RecyclerView.Adapter<CoffeeHolder> {

        private List<Coffee> mCoffees;

        public CoffeeAdapter(List<Coffee> coffees) {
            mCoffees = coffees;
        }

        @Override
        public CoffeeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(R.layout.list_item_coffee, parent, false);
            return new CoffeeHolder(view);
        }

        @Override
        public void onBindViewHolder(CoffeeHolder holder, int position) {
            Coffee coffee = mCoffees.get(position);
//            holder.mTitleTextView.setText(coffee.getTitle());
            holder.bindCoffee(coffee);
        }

        @Override
        public int getItemCount() {
            return mCoffees.size();
        }
    }
}
