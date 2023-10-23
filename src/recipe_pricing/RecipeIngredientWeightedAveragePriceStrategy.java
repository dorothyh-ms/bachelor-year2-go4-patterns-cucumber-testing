package recipe_pricing;

import domain.logistics.Contract;
import domain.menu.recipe.Recipe;

import java.util.List;

public class RecipeIngredientWeightedAveragePriceStrategy implements RecipePriceStrategy {

    @Override
    public double calculatePrice(Recipe recipe, List<Contract> contracts) {
        return 0;
    }
}
