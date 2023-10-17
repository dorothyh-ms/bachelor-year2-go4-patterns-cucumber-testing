package domain;

import java.util.List;

public class Recipe {
    private List<String> instructionSteps;
    private List<RecipeIngredient> recipeIngredients;

    public List<String> getInstructionSteps() {
        return instructionSteps;
    }

    public void setInstructionSteps(List<String> instructionSteps) {
        this.instructionSteps = instructionSteps;
    }

    public List<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(List<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }
}
