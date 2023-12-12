package hifresh.repository.ingredient;

import hifresh.domain.recipe.Ingredient;
import hifresh.repository.Repository;

import java.util.List;
import java.util.Optional;

public interface IngredientRepository extends Repository<Ingredient> {

    List<Ingredient> findByRecipeId(int recipeId);
}
