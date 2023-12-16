package hifresh.domain.pricing;

import hifresh.domain.recipe.RecipeComponent;

import java.time.LocalDate;

public interface RecipePricingStrategy {
    double calculateCost(RecipeComponent recipe, LocalDate date);
}
