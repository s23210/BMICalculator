package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText height = findViewById(R.id.height);
        EditText weight = findViewById(R.id.weight);
        Button button = findViewById(R.id.calculate);
        TextView result = findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (height.getText().toString().isEmpty() || weight.getText().toString().isEmpty()) {
                    result.setText("Please enter your height and weight");
                    return;
                }

                double heightValue = Double.parseDouble(height.getText().toString()) / 100;
                double weightValue = Double.parseDouble(weight.getText().toString());
                double bmi = weightValue / (heightValue * heightValue);

                result.setText(String.format("Your BMI is %.2f", bmi));
            }
        });
    }
}