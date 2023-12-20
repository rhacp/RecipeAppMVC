package com.andrei.challenge.controllers;

import com.andrei.challenge.models.Recipe;
import com.andrei.challenge.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {

    @Autowired
    private RecipeService recipeService;
//    Recipe firstRecipe = new Recipe("Eggs", "Bacon");
//    List<Recipe> recipeList = new ArrayList<>(List.of(firstRecipe, new Recipe("Omelette", "Eggs & Beer")));

    @GetMapping("/recipes/add")
    public String showFormPage(Model model) {
        model.addAttribute("recipe", recipeService.createRecipe());

        return "form_page";
    }

    @PostMapping("/recipes/add")
    public String addRecipe(@ModelAttribute Recipe recipe) {
        recipeService.formatIngredients(recipe);

        if (recipeService.isValid(recipe)) {
            recipeService.addRecipe(recipe);
        } else {
            System.out.println("Invalid input");
        }

        return "redirect:/recipes";
    }

    @GetMapping("/recipes")
    public String showRecipeBook(Model model) {
        model.addAttribute("recipeListAttributeName", recipeService.getAllRecipes());

        return "recipe_book";
    }

//    @DeleteMapping("/recipes")
//    public String deleteRecipe(@ModelAttribute Recipe recipe) {
//        recipeService.removeRecipe(recipe);
//
//        return "redirect:/recipes";
//    }

//    @GetMapping("/main")
//    public String showPage(Model model) {
//        return "main_page";
//    }
//
//    @GetMapping("/second")
//    public String showSecondPage(Model model) {
//        model.addAttribute("firstRecipeAttributeName", firstRecipe);
//
//        return "second_page";
//    }
}
