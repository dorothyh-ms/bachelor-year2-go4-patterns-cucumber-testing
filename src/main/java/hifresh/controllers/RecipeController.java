package hifresh.controllers;

import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;


@Controller
public class RecipeController {

    private final RecipeService recipeService;


    @Autowired
    public RecipeController(RecipeService service){
        this.recipeService = service;
    }

    public int makeNewRecipe(int id, String recipeName){
        RecipeComponent recipe = recipeService.addRecipe(id, recipeName);
        return recipe.getId();
    }

    public void addStepToRecipe(String stepDescription, int recipeId){
        recipeService.addStepToRecipe(recipeId, stepDescription);
    };

    public void insertStepIntoRecipe(String stepDescription,  int recipeId, int indexToInsert){
        recipeService.addStepToRecipeAtIndex(recipeId, stepDescription, indexToInsert);
    };


    public void addIngredientToRecipe(int ingredientQuantity, String ingredientDescription, int recipeId){
        recipeService.addIngredientToRecipe(recipeId, ingredientDescription, ingredientQuantity);
    }


    public double calculateCost(int recipeId, LocalDate purchaseDate){
        return recipeService.calculateCost(recipeId, purchaseDate);
    }


    public void addSubRecipeToRecipe(int subRecipeId, int recipeId) {
        recipeService.addSubRecipeToRecipe(subRecipeId, recipeId);
    }

    public void setPricingStrategy(int recipeId, String pricingStrategy){
        recipeService.setPricingStrategy(recipeId, pricingStrategy);
    };
}
