package com.example.trendshoosetrendwear.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



import com.example.trendshoosetrendwear.databinding.FragmentFavoriteBinding;
import com.example.trendshoosetrendwear.models.ProductModel;
import com.example.trendshoosetrendwear.ui.home.ProductAdapter;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {
    private FragmentFavoriteBinding binding;
    private ArrayList<ProductModel> products_favorited ;
    private ProductAdapter adapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        adapter = new ProductAdapter();
        products_favorited = new ArrayList<>();

        if (getArguments() != null) {
            products_favorited= getArguments().getParcelableArrayList("keysss");

        }
    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding = FragmentFavoriteBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter.setList(products_favorited);
        binding.rvFavoriteCatalog.setAdapter(adapter);
    }
}