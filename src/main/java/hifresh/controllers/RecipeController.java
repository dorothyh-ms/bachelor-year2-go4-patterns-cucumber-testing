package hifresh.controllers;

import hifresh.domain.recipe.Recipe;
import hifresh.service.RecipeService;
import hifresh.service.RecipeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller
public class RecipeController {

    private final RecipeService recipeService;


    @Autowired
    public RecipeController(RecipeService service){
        this.recipeService = service;
    }

    public int makeNewRecipe(int id, String recipeName){
        Recipe recipe = recipeService.addRecipe(id, recipeName);
        return recipe.getId();
    }

    public void addStepToRecipe(String stepDescription, int recipeId){
        recipeService.addStepToRecipe(recipeId, stepDescription);
    };

    public void insertStepIntoRecipe(String stepDescription, int indexToInsert, int recipeId){
        recipeService.addStepToRecipeAtIndex(recipeId, stepDescription, indexToInsert);
    };


    public void addIngredientToRecipe(int ingredientQuantity, String ingredientDescription, int recipeId){
        recipeService.addIngredientToRecipe(recipeId, ingredientDescription, ingredientQuantity);
    }


    public double calculateCost(int recipeId){
        return recipeService.calculateCost(recipeId);
    }


}
