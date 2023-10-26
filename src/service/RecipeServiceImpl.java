package service;

import recipe_pricing.RecipePriceStrategy;
import repository.ContractRepositoryImpl;
import repository.RecipeRepositoryImpl;

public class RecipeServiceImpl implements RecipeService {
    private RecipeRepositoryImpl recipeRepository;
    private ContractRepositoryImpl contractRepository;
    private RecipePriceStrategy recipePriceStrategy;

    public void setRecipePriceStrategy(RecipePriceStrategy recipePriceStrategy) {
        this.recipePriceStrategy = recipePriceStrategy;
    }
}
