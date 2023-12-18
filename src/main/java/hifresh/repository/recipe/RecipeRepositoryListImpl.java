package hifresh.repository.recipe;


import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.domain.recipe.Step;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Profile(value = {"listrepo"})
public class RecipeRepositoryListImpl implements RecipeRepository{

    private final List<RecipeComponent> recipeList = new ArrayList<>();

    public RecipeComponent findById(int recipeId) {
        Optional<RecipeComponent> recipe = recipeList.stream().filter(r -> r.getId() == recipeId).findFirst();
        return recipe.orElse(null);
    }


    @Override
    public RecipeComponent save(RecipeComponent recipeComponent) {
        recipeList.add(recipeComponent);
        return recipeComponent;
    }



    public CompositeRecipe findCompositeRecipeById(int id) {
        RecipeComponent foundComponent = findById(id);
        if (foundComponent instanceof CompositeRecipe) {
            return (CompositeRecipe) foundComponent;
        }
        return null; // Not a CompositeRecipe or not found
    }

    @Override
    public void addStepToRecipe(int recipeId, String stepDescription) {
        RecipeComponent recipe = findById(recipeId);
        recipe.addStep(new Step(stepDescription));
    }

    @Override
    public void addStepToRecipe(int recipeId, String stepDescription, int indexToInsert) {
        RecipeComponent recipe = findById(recipeId);
        recipe.addStep(indexToInsert-1, new Step(stepDescription));
    }

    @Override
    public void addIngredientToRecipe(int recipeId, Ingredient ingredient) {
        RecipeComponent recipe = findById(recipeId);
        recipe.addIngredient(ingredient);
        ingredient.setRecipe(recipe);
    }

    @Override
    public void addSubRecipeToRecipe(int subRecipeId, int recipeId) {
        CompositeRecipe mainRecipe = findCompositeRecipeById(recipeId);
        RecipeComponent subRecipe = findById(subRecipeId);
        mainRecipe.addSubRecipe(subRecipe);
    }

    @Override
    public void clear() {
        this.recipeList.clear();
    }
}
