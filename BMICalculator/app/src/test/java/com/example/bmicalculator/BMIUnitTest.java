package com.example.bmicalculator;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BMIUnitTest {
    @Test
    public void testCalculateBmi_validInput() {
        double heightInMeters = 178;
        double weight = 68;

        double bmi = BMIActivity.calculateBMI(heightInMeters, weight);

        assertEquals(21.46, bmi, 0.01); // Delta for floating-point comparison
    }
}