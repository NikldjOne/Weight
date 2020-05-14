package com.example.diplom;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyViewHolderSwipe extends RecyclerView.ViewHolder {
    TextView cart_item_name;

    public MyViewHolderSwipe(@NonNull View itemView) {
        super(itemView);
        cart_item_name = (TextView) itemView.findViewById(R.id.cart_item_name);
    }
}
