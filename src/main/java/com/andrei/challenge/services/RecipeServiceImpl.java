package com.andrei.challenge.services;

import com.andrei.challenge.models.Recipe;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeServiceImpl implements RecipeService {

    private List<Recipe> recipeList = new ArrayList<>();

    @Override
    public boolean isValid(Recipe recipe) {
//        check if there are at least 2 ingredients
        if (!(recipe.getIngredientsMap().size() >= 2)) {
            return false;
        }
//        check if ingredient quantity > 0
        long check = recipe.getIngredientsMap().entrySet().stream()
                .filter(entry -> (entry.getValue() > 0))
                .count();

        if (check < 0) return false;

//          check if cooking time > 0

        if (recipe.getCookingTime() <= 0) return false;


        return true;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeList;
    }

    @Override
    public Recipe createRecipe() {
        return new Recipe();
    }

    @Override
    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
    }

    @Override
    public void formatIngredients(Recipe recipe) {
        if (!recipe.getIngredient1().isBlank()) {
            System.out.println("Checked ingredient 1");
            String[] strArr = recipe.getIngredient1().split(",");
            recipe.getIngredientsMap().put(strArr[0], Integer.valueOf(strArr[1]));
        }
        if (!(recipe.getIngredient2().equals(","))) {
            System.out.println("Checked ingredient 2");
            String[] strArr = recipe.getIngredient2().split(",");
            recipe.getIngredientsMap().put(strArr[0], Integer.valueOf(strArr[1]));
        }
        if (!(recipe.getIngredient3().equals(","))) {
            System.out.println("Checked ingredient 3");
            String[] strArr = recipe.getIngredient3().split(",");
            recipe.getIngredientsMap().put(strArr[0], Integer.valueOf(strArr[1]));
        }
    }

    @Override
    public void removeRecipe(Recipe recipe) {
        recipeList.remove(recipe);
    }
}
