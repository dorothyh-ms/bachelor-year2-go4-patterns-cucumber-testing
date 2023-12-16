package hifresh.domain.pricing;

import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.Contract;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.RecipeComponent;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeightedAveragePricingStrategy implements RecipePricingStrategy{

    @Override
    public double calculateCost(RecipeComponent recipe, LocalDate date) {
        List<Ingredient> ingredients = recipe.getIngredients();
        List<Double> ingredientPricesInRecipe = new ArrayList<>();
        ingredients.forEach(ingredient -> {
            Product product = ingredient.getProduct();
            List<Contract> contracts = product.getContracts();
            List<Double> quantityPrices = new ArrayList<>();
            List<Double> quantities = new ArrayList<>();
            contracts.forEach(contract -> {
                List<Clause> clauses = contract.getClauses().stream().filter(clause -> (date.isAfter(clause.getPeriod().from()) && (date.isBefore(clause.getPeriod().to())))).toList();
                clauses.forEach(clause -> {
                    quantityPrices.add(clause.getPrice() * clause.getMaxQuantity().number());
                    quantities.add(clause.getMaxQuantity().number());
                });
            });
            double totalPrices = quantityPrices.stream().mapToDouble(Double::doubleValue).sum();
            double totalQuantities = quantities.stream().mapToDouble(Double::doubleValue).sum();
            double averagePrice = totalPrices/totalQuantities;
            double averagePriceInRecipe = averagePrice * ingredient.getQuantity().number();
            ingredientPricesInRecipe.add(averagePriceInRecipe);
        });
        return ingredientPricesInRecipe.stream().mapToDouble(Double::doubleValue).sum();
    }
}
