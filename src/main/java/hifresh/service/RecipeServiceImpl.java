package hifresh.service;


import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.Recipe;
import hifresh.domain.purchase.Product;
import hifresh.domain.util.Quantity;
import hifresh.domain.util.Unit;
import hifresh.repository.contract.ContractRepository;
import hifresh.repository.ingredient.IngredientRepository;
import hifresh.repository.product.ProductRepository;
import hifresh.repository.recipe.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;

    private final ContractRepository contractRepository;

    private final ProductRepository productRepository;

    private final IngredientRepository ingredientRepository;


    @Autowired
    public RecipeServiceImpl(RecipeRepository recipeRepository, ContractRepository contractRepository, ProductRepository productRepository, IngredientRepository ingredientRepository) {
        this.recipeRepository = recipeRepository;
        this.contractRepository = contractRepository;
        this.productRepository = productRepository;
        this.ingredientRepository = ingredientRepository;
    }



    @Override
    public Recipe addRecipe(int id, String recipeName) {
        Recipe recipe = new Recipe(recipeName);
        recipe.setId(id);
        return recipeRepository.save(recipe);
    }

    @Override
    public void addStepToRecipe(int recipeId, String stepDescription) {
        recipeRepository.addStepToRecipe(recipeId, stepDescription);
    }

    @Override
    public void addStepToRecipeAtIndex(int recipeId, String stepDescription, int indexToInsert) {
        recipeRepository.addStepToRecipe(recipeId, stepDescription, indexToInsert);
    }

    @Override
    public void addIngredientToRecipe(int recipeId, String productName, int ingredientQuantity) {
        Recipe recipe = recipeRepository.findById(recipeId);
        Product product = productRepository.findByName(productName);
        Ingredient ingredient = new Ingredient(new Quantity(Unit.GRAM, ingredientQuantity), product, recipe);
        ingredientRepository.save(ingredient);
    }


    @Override
    public double calculateCost(int recipeId) {
        return 0;
    }


}
