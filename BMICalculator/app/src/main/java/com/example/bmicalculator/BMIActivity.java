package com.example.bmicalculator;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityBmiBinding;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

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

        List<Entry> entries = new ArrayList<Entry>();
        for (int i = 0; i < 10; i++) {
            entries.add(new Entry(i, (float) (Math.random() * 80) + 20));
        }
        LineDataSet dataSet = new LineDataSet(entries, "Label");

        LineData lineData = new LineData(dataSet);
        binding.chart.setData(lineData);
        binding.chart.invalidate();

        binding.calculate.setOnClickListener(v -> {
            String height = String.valueOf(binding.height.getText());
            String weight = String.valueOf(binding.weight.getText());
            if (height.isEmpty() || weight.isEmpty()) {
                binding.result.setText("Please enter your height and weight");
                return;
            }

            double bmi = calculateBMI(Double.parseDouble(height), Double.parseDouble(weight));

            binding.result.setText(String.format("Your BMI is %.2f", bmi));
        });
    }

    public static double calculateBMI(double height, double weight) {
        double heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }
}

