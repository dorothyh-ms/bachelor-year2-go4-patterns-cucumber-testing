package hifresh.repository.ingredient;

import hifresh.domain.recipe.Ingredient;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@Profile(value = {"listrepo"})
public class IngredientRepositoryListImpl implements IngredientRepository {

    private final List<Ingredient> ingredientList = new ArrayList<>();
    @Override
    public Ingredient findById(int id) {
        return null;
    }

    @Override
    public List<Ingredient> findByRecipeId(int recipeId) {
        return ingredientList.stream().filter(i -> i.getRecipe().getId() == recipeId).collect(Collectors.toList());
    }


    @Override
    public Ingredient save(Ingredient ingredient) {
        if (ingredient.getId() == 0){ // if id not set
            ingredient.setId(ingredientList.stream()
                    .mapToInt(Ingredient::getId)
                    .max()
                    .orElse(1));
        }
        ingredientList.add(ingredient);
        return ingredient;
    }

    @Override
    public void clear() {
        ingredientList.clear();
    }
}
