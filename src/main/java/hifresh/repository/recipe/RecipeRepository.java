package hifresh.repository.recipe;

import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.Recipe;
import hifresh.repository.Repository;

import java.util.Optional;

public interface RecipeRepository extends Repository<Recipe> {

    void addStepToRecipe(int recipeId, String stepDescription);
    void addStepToRecipe(int recipeId, String stepDescription, int indexToInsert);

}
