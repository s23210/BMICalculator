package com.example.bmicalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityCalorieBinding;

public class CalorieActivity extends AppCompatActivity {

    private ActivityCalorieBinding binding;
    private boolean isWoman = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCalorieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationOnClickListener(v -> finish());

        binding.womanButton.setOnClickListener(v -> isWoman = true);
        binding.manButton.setOnClickListener(v -> isWoman = false);

        binding.calculateButton.setOnClickListener(v -> {
            String ageString = String.valueOf(binding.age.getText());
            String heightString = String.valueOf(binding.height.getText());
            String weightString = String.valueOf(binding.weight.getText());

            if (ageString.isEmpty() || heightString.isEmpty() || weightString.isEmpty()) {
                binding.resultTextView.setText("Please enter your age, height, and weight");
                return;
            }

            int age = Integer.parseInt(ageString);
            double height = Double.parseDouble(heightString);
            double weight = Double.parseDouble(weightString);

            if (age < 18) {
                binding.resultTextView.setText("This calculator is intended for use by adults only");
                return;
            }

            double bmr = isWoman ? (10 * weight) + (6.25 * height) - (5 * age) - 161 : (10 * weight) + (6.25 * height) - (5 * age) + 5;
            binding.resultTextView.setText(String.format("Your daily calorie requirement is %.2f kcal", bmr));
        });

    }
}

