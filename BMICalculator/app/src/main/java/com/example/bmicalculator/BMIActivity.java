package com.example.bmicalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityBmiBinding;

public class BMIActivity extends AppCompatActivity {

    private ActivityBmiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBmiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        binding.toolbar.setNavigationOnClickListener(v -> finish());

        binding.calculate.setOnClickListener(v -> {
            String height = String.valueOf(binding.height.getText());
            String weight = String.valueOf(binding.weight.getText());
            if (height.isEmpty() || weight.isEmpty()) {
                binding.result.setText("Please enter your height and weight");
                return;
            }

            double heightValue = Double.parseDouble(height) / 100;
            double weightValue = Double.parseDouble(weight);
            double bmi = weightValue / (heightValue * heightValue);

            binding.result.setText(String.format("Your BMI is %.2f", bmi));
        });
    }
}

