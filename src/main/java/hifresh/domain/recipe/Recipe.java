package hifresh.domain.recipe;

import hifresh.domain.pricing.RecipePricingStrategy;

import java.time.LocalDate;
import java.util.List;

public class Recipe extends RecipeComponent{

    public Recipe() {
        super();
    }

    private RecipePricingStrategy pricingStrategy;


    @Override
    public void setPricingStrategy(RecipePricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    @Override
    public double calculateCost(LocalDate date) {
        return pricingStrategy.calculateCost(this, date);
    }
}
