package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.bmiButton.setOnClickListener(
                v -> startActivity(new Intent(MainActivity.this, BMIActivity.class))
        );

        binding.calorieButton.setOnClickListener(
                v -> startActivity(new Intent(MainActivity.this, CalorieActivity.class))
        );

        binding.recipeButton.setOnClickListener(
                v -> startActivity(new Intent(MainActivity.this, RecipeActivity.class))
        );
    }
}