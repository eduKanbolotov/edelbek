package com.example.trendshoosetrendwear.ui.home;

import static androidx.navigation.Navigation.findNavController;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;


import com.example.trendshoosetrendwear.R;
import com.example.trendshoosetrendwear.databinding.FragmentHomeBinding;
import com.example.trendshoosetrendwear.models.ProductModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    ProductAdapter adapter;
    ArrayList<ProductModel> list_products = new ArrayList<>();

    public HomeFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(true);
        adapter = new ProductAdapter();
        adapter.setList(list_products);
        createList();
    }


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.rvMainCatalog.setAdapter(adapter);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);

        inflater.inflate(R.menu.action_menu, menu);
    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.favorites) {

            NavController navController = Navigation.findNavController(requireActivity(),
                    R.id.nav_host_fragment_activity_main);

            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("keysss", adapter.getSelected_list());
            navController.navigate(R.id.navigation_favorite, bundle);
        }
        return super.onOptionsItemSelected(item);
    }

    private void createList() {
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp1));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp2));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp3));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp4));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp5));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp6));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp7));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp8));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp9));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp10));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp11));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp12));
        list_products.add(new ProductModel("Футболка","новый","99", R.drawable.topp13));

    }

}