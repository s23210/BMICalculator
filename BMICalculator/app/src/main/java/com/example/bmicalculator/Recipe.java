package com.example.bmicalculator;

public class Recipe {
    private final String name;
    private final String[] ingredients;
    private final String[] instructions;

    public Recipe(String name, String[] ingredients, String[] instructions) {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public String getIngredients() {
        StringBuilder ingredientsString = new StringBuilder();
        int index = 1;
        for (String ingredient : ingredients) {
            ingredientsString.append(index++).append(". ").append(ingredient).append("\n");
        }
        return ingredientsString.toString();
    }

    public String getInstructions() {
        StringBuilder instructionsString = new StringBuilder();
        int index = 1;
        for (String instruction : instructions) {
            instructionsString.append(index++).append(". ").append(instruction).append("\n");
        }
        return instructionsString.toString();
    }
}
