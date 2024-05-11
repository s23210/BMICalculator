package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bmicalculator.databinding.ActivityShoppingListBinding;

public class ShoppingListActivity extends AppCompatActivity {
    private ActivityShoppingListBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShoppingListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationOnClickListener(v -> finish());

        Intent intent = getIntent();
        ShoppingListAdapter shoppingListAdapter = new ShoppingListAdapter(intent.getStringArrayExtra("shoppingList"));
        binding.recyclerView.setAdapter(shoppingListAdapter);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
