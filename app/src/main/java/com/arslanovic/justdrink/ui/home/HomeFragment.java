package com.arslanovic.justdrink.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.arslanovic.justdrink.R;
import com.arslanovic.justdrink.databinding.FragmentHomeBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

       // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        /*binding.card11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Click", Toast.LENGTH_SHORT).show();
            }
        });
*/
        binding.tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                CharSequence tabs = tab.getText();
                if(tabs.equals("Spiritus")){
                    ScrollView item = (ScrollView) getActivity().findViewById(R.id.scrollView2);
                    item.removeAllViewsInLayout();
                    View child = getLayoutInflater().inflate(R.layout.spirituscatalog, null);
                    item.addView(child);
                    // Handle click_________________________________
                    TableLayout lay = (TableLayout)getActivity().findViewById(R.id.SpiritusCatTable);
                    int count = lay.getChildCount();
                    TableRow v = null;
                    for(int i=0; i<count; i++) {
                        v = (TableRow) lay.getChildAt(i);
                        MaterialCardView m = null;
                        for(int a = 0; a<v.getChildCount(); a++){
                            m = (MaterialCardView) v.getChildAt(a);

                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getActivity(), "Id is: " + view.getId(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }
                else if(tabs.equals("Bajer")){
                    ScrollView item = (ScrollView) getActivity().findViewById(R.id.scrollView2);
                    item.removeAllViewsInLayout();
                    View child = getLayoutInflater().inflate(R.layout.bajercatalog, null);
                    item.addView(child);
                    // Handle click_________________________________
                    TableLayout lay = (TableLayout)getActivity().findViewById(R.id.BajerCatTable);
                    int count = lay.getChildCount();
                    TableRow v = null;
                    for(int i=0; i<count; i++) {
                        v = (TableRow) lay.getChildAt(i);
                        MaterialCardView m = null;
                        for(int a = 0; a<v.getChildCount(); a++){
                            m = (MaterialCardView) v.getChildAt(a);

                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getActivity(), "Id is: " + view.getId(), Toast.LENGTH_SHORT).show();
                                    MaterialCardView b = (MaterialCardView) view;
                                    LinearLayout c = (LinearLayout)b.getChildAt(0);
                                    LinearLayout d = (LinearLayout) c.getChildAt(1);
                                    TextView t = (TextView)d.getChildAt(0);
                                    Toast.makeText(getActivity(), t.getText(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }
                else if(tabs.equals("Vin")){
                    ScrollView item = (ScrollView) getActivity().findViewById(R.id.scrollView2);
                    item.removeAllViewsInLayout();
                    View child = getLayoutInflater().inflate(R.layout.vincatalog, null);
                    item.addView(child);
                    // Handle click_________________________________
                    TableLayout lay = (TableLayout)getActivity().findViewById(R.id.VinCatTable);
                    int count = lay.getChildCount();
                    TableRow v = null;
                    for(int i=0; i<count; i++) {
                        v = (TableRow) lay.getChildAt(i);
                        MaterialCardView m = null;
                        for(int a = 0; a<v.getChildCount(); a++){
                            m = (MaterialCardView) v.getChildAt(a);

                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getActivity(), "Id is: " + view.getId(), Toast.LENGTH_SHORT).show();
                                    MaterialCardView b = (MaterialCardView) view;
                                    LinearLayout c = (LinearLayout)b.getChildAt(0);
                                    LinearLayout d = (LinearLayout) c.getChildAt(1);
                                    TextView t = (TextView)d.getChildAt(0);
                                    Toast.makeText(getActivity(), t.getText(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }
                else if(tabs.equals("Fest boks")){
                    ScrollView item = (ScrollView) getActivity().findViewById(R.id.scrollView2);
                    item.removeAllViewsInLayout();
                    View child = getLayoutInflater().inflate(R.layout.festbokscatalog, null);
                    item.addView(child);
                    // Handle click_________________________________
                    TableLayout lay = (TableLayout)getActivity().findViewById(R.id.FestBoksCatTable);
                    int count = lay.getChildCount();
                    TableRow v = null;
                    for(int i=0; i<count; i++) {
                        v = (TableRow) lay.getChildAt(i);
                        MaterialCardView m = null;
                        for(int a = 0; a<v.getChildCount(); a++){
                            m = (MaterialCardView) v.getChildAt(a);

                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getActivity(), "Id is: " + view.getId(), Toast.LENGTH_SHORT).show();
                                    MaterialCardView b = (MaterialCardView) view;
                                    LinearLayout c = (LinearLayout)b.getChildAt(0);
                                    LinearLayout d = (LinearLayout) c.getChildAt(1);
                                    TextView t = (TextView)d.getChildAt(0);
                                    Toast.makeText(getActivity(), t.getText(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }
                else if(tabs.equals("Techno bajer")){
                    ScrollView item = (ScrollView) getActivity().findViewById(R.id.scrollView2);
                    item.removeAllViewsInLayout();
                    View child = getLayoutInflater().inflate(R.layout.technobajercatalog, null);
                    item.addView(child);
                    // Handle click_________________________________
                    TableLayout lay = (TableLayout)getActivity().findViewById(R.id.TechnoBajerCatTable);
                    int count = lay.getChildCount();
                    TableRow v = null;
                    for(int i=0; i<count; i++) {
                        v = (TableRow) lay.getChildAt(i);
                        MaterialCardView m = null;
                        for(int a = 0; a<v.getChildCount(); a++){
                            m = (MaterialCardView) v.getChildAt(a);

                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getActivity(), "Id is: " + view.getId(), Toast.LENGTH_SHORT).show();
                                    MaterialCardView b = (MaterialCardView) view;
                                    LinearLayout c = (LinearLayout)b.getChildAt(0);
                                    LinearLayout d = (LinearLayout) c.getChildAt(1);
                                    TextView t = (TextView)d.getChildAt(0);
                                    Toast.makeText(getActivity(), t.getText(), Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}