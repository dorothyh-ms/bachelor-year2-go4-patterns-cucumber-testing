package hifresh.service;

import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.recipe.RecipeComponent;

import java.time.LocalDate;

public interface RecipeService {
    RecipeComponent addRecipe(int id, String recipeName);

    public void addStepToRecipe(int recipeId, String stepDescription);

    void addStepToRecipeAtIndex(int recipeId, String stepDescription, int indexToInsert);

    void addIngredientToRecipe(int recipeId, String ingredientDescription, int ingredientQuantity);



    double calculateCost(int recipeId, LocalDate purchaseDate);

    void addSubRecipeToRecipe(int subRecipeId, int recipeId);

    void setPricingStrategy(int recipeId, String type);
}
