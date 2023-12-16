package hifresh.service;


import hifresh.domain.pricing.RecipePricingStrategyFactory;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.domain.util.Quantity;
import hifresh.domain.util.Unit;
import hifresh.repository.contract.ContractRepository;
import hifresh.repository.ingredient.IngredientRepository;
import hifresh.repository.product.ProductRepository;
import hifresh.repository.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final ContractRepository contractRepository;

    private final ProductRepository productRepository;

    private final IngredientRepository ingredientRepository;


    @Override
    public void setPricingStrategy(int recipeId, String type) {
        RecipeComponent recipe = recipeRepository.findById(recipeId);
        recipe.setPricingStrategy(RecipePricingStrategyFactory.getPricingStrategy(type));
    }

    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ContractRepository contractRepository, ProductRepository productRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.contractRepository = contractRepository;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
    }



    @Override
    public RecipeComponent addRecipe(int id, String recipeName) {
        RecipeComponent recipe = new CompositeRecipe();
        recipe.setName(recipeName);
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }

    @Override
    public void addStepToRecipe(int recipeId, String stepDescription) {
        recipeRepository.addStepToRecipe(recipeId, stepDescription);
    }

    @Override
    public void addSubRecipeToRecipe(int subRecipeId, int recipeId) {
        CompositeRecipe mainRecipe = recipeRepository.findCompositeRecipeById(recipeId);
        RecipeComponent subRecipe = recipeRepository.findById(subRecipeId);
        mainRecipe.addSubRecipe(subRecipe);
    }

    @Override
    public void addStepToRecipeAtIndex(int recipeId, String stepDescription, int indexToInsert) {
        recipeRepository.addStepToRecipe(recipeId, stepDescription, indexToInsert);
    }

    @Override
    public void addIngredientToRecipe(int recipeId, String productName, int ingredientQuantity) {
        Product product = productRepository.findByName(productName);
        Ingredient ingredient = new Ingredient(new Quantity(Unit.GRAM, ingredientQuantity), product);
        ingredientRepository.save(ingredient);
        recipeRepository.addIngredientToRecipe(recipeId, ingredient);
    }


    @Override
    public double calculateCost(int recipeId, LocalDate purchaseDate) {
        RecipeComponent recipe = recipeRepository.findById(recipeId);
        return recipe.calculateCost(purchaseDate);
    }


}
