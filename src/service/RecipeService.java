package service;

import domain.Contract;
import domain.Recipe;
import domain.RecipeIngredient;
import repository.ContractRepository;
import repository.RecipeRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RecipeService {

    private RecipeRepository recipeRepository;
    private ContractRepository contractRepository;

    public double getAverageRecipePurchasePrice(int recipeId, LocalDate date) {
        Recipe recipe = recipeRepository.findById(recipeId);
        List<RecipeIngredient> recipeIngredients = recipe.getRecipeIngredients();
        double totalAveragePrice = 0;
        List<Double> averageIngredientPrices = new ArrayList<>();
        recipeIngredients.forEach(recipeIngredient -> {
            double totalQuantity = 0;
            List<Contract> contracts = contractRepository.findByIngredientAndDate(recipeIngredient.getIngredient(), date);


        });
        return 0.0;
    }
}
