package com.example.bmicalculator;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bmicalculator.databinding.ActivityRecipeBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecipeActivity extends AppCompatActivity {

    private ActivityRecipeBinding binding;
    private final Recipe[] recipes = {
            new Recipe(
                    "Pasta Carbonara",
                    new String[]{
                            "200g spaghetti",
                            "100g pancetta",
                            "2 eggs",
                            "50g grated Parmesan cheese",
                            "Salt and pepper"
                    },
                    new String[]{
                            "Cook spaghetti according to package instructions",
                            "Fry pancetta in a pan until crispy",
                            "Whisk eggs and Parmesan cheese in a bowl",
                            "Drain spaghetti and add to pancetta",
                            "Remove pan from heat and add egg mixture",
                            "Stir until eggs are cooked",
                            "Season with salt and pepper"
                    },
                    generateShoppingList(new String[]{
                            "spaghetti",
                            "pancetta",
                            "eggs",
                            "Parmesan cheese"
                    })
            ),
            new Recipe(
                    "Chicken Stir-Fry",
                    new String[]{
                            "200g chicken breast",
                            "1 bell pepper",
                            "1 onion",
                            "2 cloves garlic",
                            "2 tbsp soy sauce",
                            "1 tbsp oyster sauce",
                            "1 tsp sugar",
                            "Salt and pepper"
                    },
                    new String[]{
                            "Slice chicken breast, bell pepper, and onion",
                            "Mince garlic",
                            "Heat oil in a pan and sauté garlic",
                            "Add chicken and cook until browned",
                            "Add bell pepper and onion",
                            "Stir in soy sauce, oyster sauce, sugar, salt, and pepper",
                            "Cook until vegetables are tender"
                    },
                    generateShoppingList(new String[]{
                            "chicken breast",
                            "bell pepper",
                            "onion",
                            "garlic",
                            "soy sauce",
                            "oyster sauce"
                    })
            ),
            new Recipe(
                    "Vegetable Curry",
                    new String[]{
                            "1 onion",
                            "2 cloves garlic",
                            "1 carrot",
                            "1 potato",
                            "1 bell pepper",
                            "200ml coconut milk",
                            "2 tbsp curry powder",
                            "Salt and pepper"
                    },
                    new String[]{
                            "Chop onion, garlic, carrot, potato, and bell pepper",
                            "Heat oil in a pan and sauté onion and garlic",
                            "Add carrot and potato, cook until slightly softened",
                            "Stir in bell pepper and curry powder",
                            "Add coconut milk, salt, and pepper",
                            "Simmer until vegetables are cooked"
                    },
                    generateShoppingList(new String[]{
                            "onion",
                            "garlic",
                            "carrot",
                            "potato",
                            "bell pepper",
                            "coconut milk",
                            "curry powder"
                    })
            ),
            new Recipe(
                    "Banana Bread",
                    new String[]{
                            "3 ripe bananas",
                            "150g flour",
                            "100g sugar",
                            "1 egg",
                            "50g butter",
                            "1 tsp baking powder",
                            "1 tsp cinnamon",
                            "1/2 tsp salt"
                    },
                    new String[]{
                            "Preheat oven to 180°C",
                            "Mash bananas in a bowl",
                            "Add sugar, egg, and melted butter",
                            "Mix in flour, baking powder, cinnamon, and salt",
                            "Pour batter into a greased loaf pan",
                            "Bake for 45-50 minutes until golden brown"
                    },
                    generateShoppingList(new String[]{
                            "ripe bananas",
                            "flour",
                            "sugar",
                            "egg",
                            "butter",
                            "baking powder",
                            "cinnamon",
                            "salt"
                    })
            ),
    };

    private Recipe recipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRecipeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        binding.toolbar.setNavigationOnClickListener(v -> finish());

        binding.generateButton.setOnClickListener(v -> {
            int randomIndex = (int) (Math.random() * recipes.length);
            recipe = recipes[randomIndex];

            String recipeString = recipe.getName() +
                    "\nIngredients:\n" + recipe.getIngredients() +
                    "\nInstructions:\n" + recipe.getInstructions();

            binding.recipeTextView.setText(recipeString);
        });

        binding.showShoppingListButton.setOnClickListener(

                v -> {
                    Intent intent = new Intent(RecipeActivity.this, ShoppingListActivity.class);
                    intent.putExtra("shoppingList", recipe.getShoppingList().toArray(new String[0]));
                    startActivity(intent);
                }
        );
    }

    private static List<String> generateShoppingList(String[] ingredients) {
        List<String> shoppingList = new ArrayList<>();
        Collections.addAll(shoppingList, ingredients);
        return shoppingList;
    }
}