package hifresh.repository.ingredient;

import hifresh.domain.recipe.Ingredient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class IngredientRepositoryListImpl implements IngredientRepository {

    private final List<Ingredient> ingredients = new ArrayList<>();
    @Override
    public Ingredient findById(int id) {
        return null;
    }

    @Override
    public List<Ingredient> findByRecipeId(int recipeId) {
        return ingredients.stream().filter(i -> i.getRecipe().getId() == recipeId).collect(Collectors.toList());
    }

    @Override
    public void update(Ingredient ingredient) {

    }

    @Override
    public Ingredient save(Ingredient ingredient) {
        ingredients.add(ingredient);
        return ingredient;
    }
}
