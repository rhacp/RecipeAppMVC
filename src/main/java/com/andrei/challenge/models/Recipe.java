package com.andrei.challenge.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipe {

    private String name;
    private Map<String, Integer> ingredientsMap;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private String description;
    private String preparationSteps;
    private int cookingTime;

    public Recipe() {
        ingredientsMap = new HashMap<>();
    }
}
