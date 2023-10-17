package controllers;

import service.RecipeService;

import java.time.LocalDate;

public class RecipeController {
    private RecipeService recipeService;

    public double getAverageRecipePurchasePrice(int recipeId, LocalDate date){
        recipeService.getAverageRecipePurchasePrice(recipeId, date);
        return 0.0;
    }


}
