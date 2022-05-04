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
import com.arslanovic.justdrink.ShoppingSystem;
import com.arslanovic.justdrink.databinding.FragmentHomeBinding;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private ShoppingSystem shoppingSystem;
    private FirebaseAuth mAuth;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);
        mAuth = FirebaseAuth.getInstance();

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        shoppingSystem = new ShoppingSystem();
       // final TextView textView = binding.textHome;
       // homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
                            LinearLayout c = (LinearLayout)m.getChildAt(0);
                            LinearLayout d = (LinearLayout) c.getChildAt(1);
                            TextView t = (TextView)d.getChildAt(0);
                            TextView tt = (TextView)d.getChildAt(2);
                            shoppingSystem.createProduct(String.valueOf(t.getText()), m.getId(), Integer.parseInt(String.valueOf(tt.getText()).split("\\s+")[0]));
                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Toast.makeText(getActivity(), shoppingSystem.findProduct(view.getId()).getName() + " " +shoppingSystem.findProduct(view.getId()).getPrice(), Toast.LENGTH_SHORT).show();
                                    shoppingSystem.addToBasket(shoppingSystem.findProduct(view.getId()));
                                    Toast.makeText(getActivity(), "Basket value: " + shoppingSystem.getBasketValue(), Toast.LENGTH_SHORT).show();
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
                            LinearLayout c = (LinearLayout)m.getChildAt(0);
                            LinearLayout d = (LinearLayout) c.getChildAt(1);
                            TextView t = (TextView)d.getChildAt(0);
                            TextView tt = (TextView)d.getChildAt(2);
                            int tmp = m.getId();
                            shoppingSystem.createProduct(String.valueOf(t.getText()), tmp + 50, Integer.parseInt(String.valueOf(tt.getText()).split("\\s+")[0]));
                            m.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    int tmp2 = view.getId();
                                    tmp2 += 50;
                                    Toast.makeText(getActivity(), shoppingSystem.findProduct(tmp2).getName() + " " +shoppingSystem.findProduct(tmp2).getPrice(), Toast.LENGTH_SHORT).show();
                                    shoppingSystem.addToBasket(shoppingSystem.findProduct(view.getId()));
                                    Toast.makeText(getActivity(), String.valueOf(view.getId()), Toast.LENGTH_SHORT).show();
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
    public void onStart() {
        super.onStart();
        TabLayout tabLayout = getActivity().findViewById(R.id.tabLayout);
        tabLayout.selectTab(tabLayout.getTabAt(1));
        tabLayout.selectTab(tabLayout.getTabAt(0));

        LocalTime time = LocalTime.now(); // Gets the current time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH");
        TextView t = (TextView)getActivity().findViewById(R.id.BeskedText);
        FirebaseUser user = mAuth.getCurrentUser();
        if(Integer.parseInt(time.format(formatter)) >= 18 && Integer.parseInt(time.format(formatter)) <= 23){
            t.setText("God aften\n" + user.getDisplayName());
        }
        else if(Integer.parseInt(time.format(formatter)) >= 13 && Integer.parseInt(time.format(formatter)) <= 17){
            t.setText("God eftermiddag\n" + user.getDisplayName());
        }
        else if(Integer.parseInt(time.format(formatter)) >= 9 && Integer.parseInt(time.format(formatter)) <= 12){
            t.setText("God formiddag\n" + user.getDisplayName());
        }
        else{
            t.setText("Gå i seng\n" + user.getDisplayName());
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}