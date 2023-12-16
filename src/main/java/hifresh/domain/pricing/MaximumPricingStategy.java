package hifresh.domain.pricing;

import hifresh.domain.recipe.RecipeComponent;

import java.time.LocalDate;

public class MaximumPricingStategy implements RecipePricingStrategy{
    @Override
    public double calculateCost(RecipeComponent recipe, LocalDate date) {
        return 0;
    }
}
