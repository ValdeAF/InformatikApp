package com.arslanovic.justdrink.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.arslanovic.justdrink.R;
import com.arslanovic.justdrink.databinding.FragmentDashboardBinding;
import com.google.android.material.card.MaterialCardView;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
       // final TextView textView = binding.textDashboard;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.radioButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rad = (RadioButton)getActivity().findViewById(R.id.radioButton1);
                rad.setChecked(false);
                RadioButton rad2 = (RadioButton)getActivity().findViewById(R.id.radioButton2);
                rad2.setChecked(false);
            }
        });

        binding.radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rad = (RadioButton)getActivity().findViewById(R.id.radioButton);
                rad.setChecked(false);
                RadioButton rad2 = (RadioButton)getActivity().findViewById(R.id.radioButton2);
                rad2.setChecked(false);
            }
        });

        binding.radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton rad = (RadioButton)getActivity().findViewById(R.id.radioButton1);
                rad.setChecked(false);
                RadioButton rad2 = (RadioButton)getActivity().findViewById(R.id.radioButton);
                rad2.setChecked(false);
            }
        });

        binding.cardx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}