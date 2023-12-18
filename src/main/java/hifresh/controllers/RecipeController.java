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

    public void insertStepIntoRecipeInOrder(String stepDescription, int recipeId, int indexToInsertAt){
        recipeService.addStepToRecipeAtIndex(recipeId, stepDescription, indexToInsertAt);
    };


    public void addIngredientToRecipe(int recipeId, String ingredientUnit, String productName, double ingredientQuantity){
        recipeService.addIngredientToRecipe(recipeId, ingredientUnit, productName, ingredientQuantity);
    }


    public void addSubRecipeToRecipe(int subRecipeId, int recipeId) {
        recipeService.addSubRecipeToRecipe(subRecipeId, recipeId);
    }

    public double calculateCost(int recipeId, LocalDate purchaseDate){
        return recipeService.calculateCost(recipeId, purchaseDate);
    }


    public void setPricingStrategy(int recipeId, String pricingStrategy){
        recipeService.setPricingStrategy(recipeId, pricingStrategy);
    };

    public RecipeComponent getRecipe(int recipeId){
        return recipeService.getRecipeById(recipeId);
    }

    public CompositeRecipe getCompositeRecipe(int recipeId){
        return recipeService.getCompositeRecipeById(recipeId);
    }
}
