package hifresh.domain.pricing;

import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.Contract;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.RecipeComponent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MaximumPricingStategy implements RecipePricingStrategy{
    @Override
    public double calculateCost(RecipeComponent recipe, LocalDate date) {
        List<Ingredient> ingredients = recipe.getIngredients();
        double maxPrice =0.0;
        for (Ingredient ingredient : ingredients) {
            double maxIngredientPrice = 0.0;
            Product product = ingredient.getProduct();
            List<Contract> contracts = product.getContracts();
            for (Contract contract : contracts)  {
                List<Clause> clauses = contract.getClauses().stream().filter(clause -> (date.isAfter(clause.getPeriod().from()) && (date.isBefore(clause.getPeriod().to())))).toList();
                for (Clause clause : clauses) {
                    if (clause.getPrice() > maxPrice){
                        maxIngredientPrice = clause.getPrice();
                    }
                };
            };
            maxPrice += maxIngredientPrice * ingredient.getQuantity().number();
        };
        return maxPrice;
    }
}
