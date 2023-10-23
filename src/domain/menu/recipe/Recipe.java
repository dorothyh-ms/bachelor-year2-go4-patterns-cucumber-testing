package domain.menu.recipe;

import domain.menu.recipe.Label;
import domain.menu.recipe.RecipeIngredient;

import java.util.List;

public abstract class Recipe {
    private List<String> instructionSteps;
    private List<RecipeIngredient> recipeIngredients;
    private List<RecipeLabel> labels;

}
