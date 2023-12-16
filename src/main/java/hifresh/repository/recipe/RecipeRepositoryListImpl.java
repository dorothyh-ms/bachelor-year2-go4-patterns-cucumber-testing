package hifresh.repository.recipe;


import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.domain.recipe.Step;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
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

    @Override
    public void update(RecipeComponent compositeRecipe) {
//        CompositeRecipe recipeToUpdate = compositeRecipeList.stream().filter(r -> r.getId() == compositeRecipe.getId()).findFirst().get();
//        recipeToUpdate.setDescription(compositeRecipe.getDescription());
//        recipeToUpdate.setName(compositeRecipe.getName());
//        recipeToUpdate.setPicture(compositeRecipe.getPicture());
//        recipeToUpdate.
//        compositeRecipe.clearSubRecipes();
//        compositeRecipe.getSubRecipes().forEach(recipeToUpdate::addSubRecipe);

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
        recipe.getSteps().add(new Step(stepDescription));
    }

    @Override
    public void addStepToRecipe(int recipeId, String stepDescription, int indexToInsert) {
        RecipeComponent recipe = findById(recipeId);
        recipe.getSteps().add(indexToInsert-1, new Step(stepDescription));
    }

    @Override
    public void addIngredientToRecipe(int recipeId, Ingredient ingredient) {
        RecipeComponent recipe = findById(recipeId);
        recipe.addIngredient(ingredient);
        ingredient.setRecipe(recipe);
    }

    @Override
    public void clear() {
        this.recipeList.clear();
    }
}
