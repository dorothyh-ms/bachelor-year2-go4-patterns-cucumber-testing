package hifresh.repository.recipe;

import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.repository.Repository;

public interface RecipeRepository extends Repository<RecipeComponent> {

    void addStepToRecipe(int recipeId, String stepDescription);
    void addStepToRecipe(int recipeId, String stepDescription, int indexToInsert);

    void addIngredientToRecipe(int recipeId, Ingredient ingredient);
    public CompositeRecipe findCompositeRecipeById(int recipeId);

}
