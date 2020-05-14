package com.example.diplom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.diplom.model.ItemSwipe;

import java.util.List;

public class MyAdapterSwipe extends RecyclerView.Adapter<MyViewHolderSwipe> {
    Context context;
    List<ItemSwipe> itemList;

    public MyAdapterSwipe(Context context, List<ItemSwipe> itemList) {
        this.context = context;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public MyViewHolderSwipe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.item_layout, parent, false);
        return new MyViewHolderSwipe(itemView);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderSwipe holder, int position) {

        holder.cart_item_name.setText(itemList.get(position).getName());
    }
}
