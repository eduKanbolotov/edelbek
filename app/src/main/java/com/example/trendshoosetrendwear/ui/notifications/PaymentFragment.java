package com.example.trendshoosetrendwear.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.trendshoosetrendwear.R;

import com.example.trendshoosetrendwear.databinding.FragmentPaymentBinding;

public class PaymentFragment extends Fragment {

    private FragmentPaymentBinding binding;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = FragmentPaymentBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        binding.cardVisa.setOnClickListener(v ->{
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://demirbank.kg/ru/"));
            startActivity(myIntent);

        });
        binding.cardPaypal.setOnClickListener(v ->{
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.optimabank.kg/ru/"));
            startActivity(myIntent);

        });
        binding.cardMBank.setOnClickListener(v ->{
            Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://visa.com/"));
            startActivity(myIntent);

        });




    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}