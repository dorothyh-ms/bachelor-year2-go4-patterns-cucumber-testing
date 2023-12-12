package hifresh.repository.recipe;


import hifresh.domain.recipe.Recipe;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class RecipeRepositoryListImpl implements RecipeRepository{

    private final List<Recipe> recipeList = new ArrayList<>();

    public Recipe findById(int recipeId) {
        Optional<Recipe> recipe = recipeList.stream().filter(r -> r.getId() == recipeId).findFirst();
        return recipe.orElse(null);
    }


    @Override
    public Recipe save(Recipe recipe) {
        recipeList.add(recipe);
        return recipe;
    }

    @Override
    public void update(Recipe recipe) {
        Recipe recipeToUpdate = recipeList.stream().filter(r -> r.getId() == recipe.getId()).findFirst().get();
        recipeToUpdate.setDescription(recipe.getDescription());
        recipeToUpdate.setName(recipe.getName());
        recipeToUpdate.setPicture(recipe.getPicture());
        recipe.clearSubRecipes();
        recipe.getSubRecipes().forEach(recipeToUpdate::addSubRecipe);

    }
}
