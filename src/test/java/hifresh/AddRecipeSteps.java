package hifresh;

import static org.junit.jupiter.api.Assertions.assertEquals;

import hifresh.controllers.RecipeController;
import hifresh.domain.purchase.Contract;
import hifresh.domain.purchase.DistributionCenter;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.Ingredient;
import hifresh.domain.recipe.Recipe;
import hifresh.domain.recipe.Step;
import hifresh.domain.util.Quantity;
import hifresh.domain.util.Unit;
import hifresh.repository.clause.ClauseRepository;
import hifresh.repository.contract.ContractRepository;
import hifresh.repository.distributioncenter.DistributionCenterRepository;
import hifresh.repository.ingredient.IngredientRepository;
import hifresh.repository.product.ProductRepository;
import hifresh.repository.recipe.RecipeRepository;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
@CucumberContextConfiguration
public class AddRecipeSteps {

    @Autowired
    RecipeController recipeController;

    @Autowired
    RecipeRepository recipeRepository;

    @Autowired
    ProductRepository productRepository;

    @Autowired
    DistributionCenterRepository distributionCenterRepository;

    @Autowired
    ClauseRepository clauseRepository;

    @Autowired
    ContractRepository contractRepository;

    @Autowired
    IngredientRepository ingredientRepository;



    @Given("products")
    public void products(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Product product = new Product(columns.get("product_name"));
            product.setId(Integer.parseInt(columns.get("product_id")));
            productRepository.save(product);
        }
    }

    @Given("distributioncentres")
    public void distributionCenters(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            DistributionCenter center = new DistributionCenter(columns.get("distributioncentre_name"));
            center.setId(Integer.parseInt(columns.get("distributioncentre_id")));
            distributionCenterRepository.save(center);
        }
    }

    @Given("recipes")
    public void recipes(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Recipe recipe = new Recipe(columns.get("recipe_name"));
            recipe.setId(Integer.parseInt(columns.get("recipe_id")));
            recipeRepository.save(recipe);
        }
    }


    @Given("subrecipes")
    public void subrecipes(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Recipe mainRecipe = recipeRepository.findById(Integer.parseInt(columns.get("recipe_id")));
            mainRecipe.addSubRecipe(recipeRepository.findById(Integer.parseInt(columns.get("subrecipe"))));
        }
    }



    @Given("ingredients")
    public void ingredients(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            int productId = Integer.parseInt(columns.get("product_id"));
            Product product = productRepository.findById(productId);
            int recipeId = Integer.parseInt(columns.get("recipe_id"));
            Recipe recipe = recipeRepository.findById(recipeId);
            Ingredient ingredient = new Ingredient(
                    new Quantity(
                            Unit.valueOf(columns.get("unit")),
                            Integer.parseInt(columns.get("quantity"))
                    ),
                    product,
                    recipe
                    );
            ingredient.setId(Integer.parseInt(columns.get("ingredient_id")));
            ingredientRepository.save(ingredient);
        }
    }

    @Given("steps")
    public void steps(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Step step = new Step(columns.get("description"));
            step.setId(Integer.parseInt(columns.get("step_id")));
            Recipe recipe = recipeRepository.findById(Integer.parseInt(columns.get("recipe_id")));
            recipe.addStep(Integer.parseInt(columns.get("order"))-1,step);
        }
    }



    @Given("contracts")
    public void contracts(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Product product = productRepository.findById(Integer.parseInt(columns.get("product_id")));
            DistributionCenter distributionCenter = distributionCenterRepository.findById(Integer.parseInt(columns.get("distributioncentre_id")));
            Contract contract = new Contract();
            contract.setProduct(product);
            contract.setDistributionCenter(distributionCenter);
            contract.setId(Integer.parseInt(columns.get("contract_id")));
            contractRepository.save(contract);
        }
    }

//    @Given("clauses")
//    public void clauses() {
//    }

    @When("I add recipe {int} with name {string}")
    public void iAddRecipeWithName(int recipeId, String recipeName) {
        recipeController.makeNewRecipe(recipeId, recipeName);
    }

    @And("I add ingredient {int} grammes {string} to recipe {int}")
    public void iAddIngredientGrammesToRecipe(int ingredientQuantity, String productName, int recipeId) {
        recipeController.addIngredientToRecipe(ingredientQuantity, productName, recipeId);
    }

    @And("I append a preparation step to recipe {int} with description {string}")
    public void iAppendAPreparationStepToRecipeWithDescription(int recipeId, String stepDescription) {
        recipeController.addStepToRecipe(stepDescription, recipeId);
    }


    @Then("recipe {int} should have {int} ingredients and {int} preparation steps")
    public void recipeShouldHaveIngredientsAndPreparationSteps(int recipeId, int numberOfIngredients, int numberOfPreparationSteps) {
        List<Ingredient> ingredients = ingredientRepository.findByRecipeId(recipeId);
        Recipe recipe = recipeRepository.findById(recipeId);
        assertEquals(numberOfIngredients, ingredients.size(), String.format("recipe should have %d ingredients but has %d", numberOfIngredients, ingredients.size()));
        assertEquals(numberOfPreparationSteps, recipe.getSteps().size(), String.format("recipe should have %d steps but has %d", numberOfPreparationSteps, recipe.getSteps().size()));
    }

    @And("preparation step {int} is {string}")
    public void preparationStepIs(int stepNumber, String stepDescription) {
    }

    @And("I add subrecipe {int} to recipe {int}")
    public void iAddSubrecipeToRecipe(int subRecipeId, int recipeId) {
    }

    @Then("recipe {int} should have {int} ingredients and {int} preparation steps and {int} subrecipe")
    public void recipeShouldHaveIngredientsAndPreparationStepsAndSubrecipe(int recipeId, int numberOfIngredients, int numberOfSteps, int numberOfSubRecipes) {
    }

    @When("i add a step {string} to recipe {int}")
    public void iAddAStepToRecipe(String stepDescription, int recipeId) {
    }

    @Then("the recipe has {int} steps")
    public void theRecipeHasSteps(int numberOfSteps) {
    }

    @And("the last step of recipe {int} has description {string}")
    public void theLastStepOfRecipeHasDescription(int recipeId, String description) {
    }

    @When("I add a step  {string} to recipe {int} before step {int}")
    public void iAddAStepToRecipeBeforeStep(String stepDescription, int recipeId, int stepNumber) {
    }

    @And("step {int} for recipe {int} is {string}")
    public void stepForRecipeIs(int stepNumber, int recipeId, String stepDescription) {
    }

}
