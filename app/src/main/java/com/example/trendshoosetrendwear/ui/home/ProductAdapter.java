package com.example.trendshoosetrendwear.ui.home;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trendshoosetrendwear.R;
import com.example.trendshoosetrendwear.databinding.ItemProductBinding;
import com.example.trendshoosetrendwear.models.ProductModel;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ArrayList<ProductModel> list = new ArrayList<>();
    ArrayList<ProductModel> selected_list = new ArrayList<>();
    NavController navController;

    public void setList(ArrayList<ProductModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public ArrayList<ProductModel> getSelected_list()    {
        return selected_list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ItemProductBinding itemProductBinding = ItemProductBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        ViewHolder viewHolder = new ViewHolder(itemProductBinding);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.onBind(list.get(position));
    }
    @Override
    public int getItemCount() {

        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ItemProductBinding binding;

        public ViewHolder(@NonNull ItemProductBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }

        public void onBind(ProductModel productModel) {

            binding.tovarName.setText(productModel.getName());
            binding.tovarPrice.setText(productModel.getPrice());
            binding.tovarBrand.setText(productModel.getBrand());
            binding.tovarImage.setImageResource(productModel.getPhoto_int());

            itemView.setOnClickListener(view -> {
                binding.tovarFavoriteCheck.setVisibility(View.VISIBLE);
                selected_list.add(productModel);
            });

        }
    }
}
