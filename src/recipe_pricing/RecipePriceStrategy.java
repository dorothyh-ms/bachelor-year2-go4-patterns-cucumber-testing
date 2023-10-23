package recipe_pricing;

// put at top level of directory because this is only used in Service classes

import domain.logistics.Contract;
import domain.menu.recipe.Recipe;
import domain.menu.recipe.RecipeIngredient;

import java.util.List;

public interface RecipePriceStrategy {


    double calculatePrice(Recipe recipe, List<Contract> contracts);
}
