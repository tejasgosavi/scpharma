package com.thg.retailapp.domain.newlapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;


public class MyCart extends Fragment {


    public MyCart() {
    }

    private RecyclerView cartItemsRecyclerView;
    private Button continueBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_cart, container, false);

        cartItemsRecyclerView =view.findViewById(R.id.cart_item_recyclerview);
        continueBtn = view.findViewById(R.id.cart_continue_btn);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        cartItemsRecyclerView.setLayoutManager(layoutManager);

        List<CartItemModel> cartItemModelList = new ArrayList<>();
        cartItemModelList.add(new CartItemModel(0,R.drawable.logo_transparent,"Azicip","Rs199/-","Rs299/-",1,"33.33"));
        cartItemModelList.add(new CartItemModel(0,R.drawable.logo_transparent,"Azicip S","Rs299/-","Rs399/-",2,"33.33"));
        cartItemModelList.add(new CartItemModel(0,R.drawable.logo_transparent,"Azicip D","Rs399/-","Rs499/-",4 ,"33.33"));
        cartItemModelList.add(new CartItemModel(1,"Rs1197","Price(3items)","Free","Rs1197","Rs297/-"));
        cartAdapter cartAdapter = new cartAdapter(cartItemModelList);
        cartItemsRecyclerView.setAdapter(cartAdapter);
        cartAdapter.notifyDataSetChanged();


        continueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent deliveryIntent = new Intent(getContext(),DeliveryActivity.class);
                getContext().startActivity(deliveryIntent);
            }
        });
        return view;
    }
}
