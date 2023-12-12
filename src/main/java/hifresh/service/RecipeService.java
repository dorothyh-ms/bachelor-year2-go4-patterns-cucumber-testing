package hifresh.service;

import hifresh.domain.recipe.Recipe;

import java.util.List;

public interface RecipeService {
    Recipe addRecipe(int id, String recipeName);

    public void addStepToRecipe(int recipeId, String stepDescription);

    void addStepToRecipeAtIndex(int recipeId, String stepDescription, int indexToInsert);

    void addIngredientToRecipe(int recipeId, String ingredientDescription, int ingredientQuantity);



    double calculateCost(int recipeId);
}
