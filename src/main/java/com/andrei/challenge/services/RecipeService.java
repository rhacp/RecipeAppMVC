package com.andrei.challenge.services;

import com.andrei.challenge.models.Recipe;

import java.util.List;

public interface RecipeService {

    List<Recipe> getAllRecipes();

    Recipe createRecipe();

    void addRecipe(Recipe recipe);

    void formatIngredients(Recipe recipe);

    boolean isValid(Recipe recipe);

    void removeRecipe(Recipe recipe);
}
