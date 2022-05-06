package com.arslanovic.justdrink;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.arslanovic.justdrink.databinding.FragmentFirst2Binding;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;

public class First2Fragment extends Fragment {

    private FragmentFirst2Binding binding;
    private ShoppingSystem shoppingSystem;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirst2Binding.inflate(inflater, container, false);
        shoppingSystem = (ShoppingSystem) getActivity().getIntent().getSerializableExtra("ShopSys");
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(First2Fragment.this)
                        .navigate(R.id.action_First2Fragment_to_Second2Fragment);
            }
        });

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShoppingSystem shoppingSystem = new ShoppingSystem();
                startActivity(new Intent(getActivity(), MainActivity.class).putExtra("ShopSys", shoppingSystem));
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}