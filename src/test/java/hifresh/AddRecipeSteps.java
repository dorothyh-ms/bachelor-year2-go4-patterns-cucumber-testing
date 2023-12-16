package hifresh;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import hifresh.controllers.RecipeController;
import hifresh.domain.purchase.Clause;
import hifresh.domain.purchase.Contract;
import hifresh.domain.purchase.DistributionCenter;
import hifresh.domain.purchase.Product;
import hifresh.domain.recipe.*;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.domain.util.Interval;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Map;


public class AddRecipeSteps extends CucumberIntegrationTest{

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


    private int currentRecipeId;

    @Given("products")
    public void products(DataTable dataTable) {
        productRepository.clear();
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Product product = new Product(columns.get("product_name"));
            product.setId(Integer.parseInt(columns.get("product_id")));
            productRepository.save(product);
        }
    }

    @Given("distributioncentres")
    public void distributionCenters(DataTable dataTable) {
        distributionCenterRepository.clear();
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            DistributionCenter center = new DistributionCenter(columns.get("distributioncentre_name"));
            center.setId(Integer.parseInt(columns.get("distributioncentre_id")));
            distributionCenterRepository.save(center);
        }
    }

    @Given("recipes")
    public void recipes(DataTable dataTable) {
        recipeRepository.clear();
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            RecipeComponent recipe = new CompositeRecipe();
            recipe.setName(columns.get("recipe_name"));
            recipe.setDescription(columns.get("recipe_description"));
            recipe.setId(Integer.parseInt(columns.get("recipe_id")));
            recipeRepository.save(recipe);
        }
    }


    @Given("subrecipes")
    public void subrecipes(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            RecipeComponent recipe = recipeRepository.findCompositeRecipeById(Integer.parseInt(columns.get("subrecipe")));
            CompositeRecipe mainRecipe = recipeRepository.findCompositeRecipeById(Integer.parseInt(columns.get("recipe_id")));
            mainRecipe.addSubRecipe(recipe);
        }
    }



    @Given("ingredients")
    public void ingredients(DataTable dataTable) {
        ingredientRepository.clear();
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            int productId = Integer.parseInt(columns.get("product_id"));
            Product product = productRepository.findById(productId);
            int recipeId = Integer.parseInt(columns.get("recipe_id"));
            Ingredient ingredient = new Ingredient(
                    new Quantity(
                            Unit.valueOf(columns.get("unit")),
                            Double.parseDouble(columns.get("quantity"))
                    ),
                    product
                    );
            ingredient.setId(Integer.parseInt(columns.get("ingredient_id")));
            recipeRepository.addIngredientToRecipe(recipeId, ingredient);
            ingredientRepository.save(ingredient);
        }
    }

    @Given("steps")
    public void steps(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Step step = new Step(columns.get("description"));
            step.setId(Integer.parseInt(columns.get("step_id")));
            RecipeComponent recipe = recipeRepository.findById(Integer.parseInt(columns.get("recipe_id")));
            recipe.addStep(Integer.parseInt(columns.get("order"))-1,step);
        }
    }



    @Given("contracts")
    public void contracts(DataTable dataTable) {
        contractRepository.clear();
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            DistributionCenter distributionCenter = distributionCenterRepository.findById(Integer.parseInt(columns.get("distributioncentre_id")));
            Contract contract = new Contract();
            contract.setDistributionCenter(distributionCenter);
            contract.setId(Integer.parseInt(columns.get("contract_id")));
            contractRepository.save(contract);
            productRepository.addContractToProduct(Integer.parseInt(columns.get("product_id")), contract);

        }
    }

    @Given("clauses")
    public void clauses(DataTable dataTable) {
        clauseRepository.clear();
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            Quantity quantity = new Quantity(Unit.valueOf(columns.get("unit")), Double.parseDouble(columns.get("maxQuantity")));
            Interval interval = new Interval(LocalDate.parse(columns.get("start_date")), LocalDate.parse(columns.get("end_date")));
            double price = Double.parseDouble(columns.get("price"));
            Clause clause = new Clause();
            clause.setPrice(price);
            clause.setMaxQuantity(quantity);
            clause.setPeriod(interval);
            clause.setId(Integer.parseInt(columns.get("clause_id")));
            clauseRepository.save(clause);
            contractRepository.setClauseOfContract(
                    Integer.parseInt(columns.get("contract_id")),
                    clause);
        }
    }

    @When("I add recipe {int} with name {string}")
    public void iAddRecipeWithName(int recipeId, String recipeName) {
        currentRecipeId = recipeId;
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
        RecipeComponent recipe = recipeRepository.findById(recipeId);
        int actualNumberOfIngredients = recipe.getIngredients().size();
        int actualNumberOfSteps = recipe.getSteps().size();
        assertEquals(numberOfIngredients, actualNumberOfIngredients, String.format("recipe with id %d should have %d ingredients but has %d %s", recipeId, numberOfIngredients, actualNumberOfIngredients, recipe.getIngredients()));
        assertEquals(numberOfPreparationSteps, actualNumberOfSteps, String.format("recipe with id %d should have %d steps but has %d", recipeId, numberOfPreparationSteps, actualNumberOfSteps));
    }

    @And("preparation step {int} is {string}")
    public void preparationStepIs(int stepNumber, String stepDescription) {
        RecipeComponent compositeRecipe = recipeRepository.findById(currentRecipeId);
        Step step = compositeRecipe.getSteps().get(stepNumber-1);
        String actualStepDescription = step.getDescription();
        assertEquals(stepDescription, actualStepDescription , String.format("preparation step should be %s but is %s", stepDescription, actualStepDescription));
    }

    @And("I add subrecipe {int} to recipe {int}")
    public void iAddSubrecipeToRecipe(int subRecipeId, int recipeId) {
        recipeController.addSubRecipeToRecipe(subRecipeId, recipeId);
    }

    @Then("recipe {int} should have {int} ingredients and {int} preparation steps and {int} subrecipe")
    public void recipeShouldHaveIngredientsAndPreparationStepsAndSubrecipe(int recipeId, int numberOfIngredients, int numberOfSteps, int numberOfSubRecipes) {

        CompositeRecipe compositeRecipe = recipeRepository.findCompositeRecipeById(recipeId);
        int actualNumberOfSteps = compositeRecipe.getSteps().size();
        int actualNumberOfSubRecipes = compositeRecipe.getSubRecipes().size();
        int actualNumberOfIngredients = compositeRecipe.getIngredients().size();
        assertEquals(numberOfIngredients, actualNumberOfIngredients, String.format("recipe with id %d should have %d ingredients but has %d ingredients", recipeId, numberOfIngredients, actualNumberOfIngredients));
        assertEquals(numberOfSteps, actualNumberOfSteps, String.format("recipe with id %d should have %d steps but has %d", recipeId, numberOfSteps, actualNumberOfSteps));
        assertEquals(numberOfSubRecipes, actualNumberOfSubRecipes, String.format("recipe with id %d should have %d subrecipes but has %d", recipeId, numberOfSubRecipes, actualNumberOfSubRecipes));
    }

    @When("i add a step {string} to recipe {int}")
    public void iAddAStepToRecipe(String stepDescription, int recipeId) {
        currentRecipeId = recipeId;
        System.out.println(currentRecipeId);
        recipeController.addStepToRecipe(stepDescription, recipeId);
    }

    @Then("the recipe has {int} steps")
    public void theRecipeHasSteps(int numberOfSteps) {
        RecipeComponent recipe = recipeRepository.findById(currentRecipeId);
        assertNotNull(recipe, String.format("Recipe %d should not be null", currentRecipeId));
        int actualNumberOfSteps = recipe.getSteps().size();
        assertEquals(numberOfSteps, actualNumberOfSteps, String.format("recipe %d should have %d steps but has %d steps", currentRecipeId, numberOfSteps, actualNumberOfSteps ));
    }

    @And("the last step of recipe {int} has description {string}")
    public void theLastStepOfRecipeHasDescription(int recipeId, String description) {
        RecipeComponent recipe = recipeRepository.findById(recipeId);
        List<Step> steps = recipe.getSteps();
        String lastStepDescription = steps.get(steps.size()-1).getDescription();
        assertEquals(description, lastStepDescription, String.format("last step of compositeRecipe should have description %s but has description %s", description, lastStepDescription));

    }

    @When("I add a step  {string} to recipe {int} before step {int}")
    public void iAddAStepToRecipeBeforeStep(String stepDescription, int recipeId, int stepNumber) {
        currentRecipeId = recipeId;
        recipeController.insertStepIntoRecipe(stepDescription, recipeId, stepNumber);
    }

    @And("step {int} for recipe {int} is {string}")
    public void stepForRecipeIs(int stepNumber, int recipeId, String stepDescription) {
        RecipeComponent recipe = recipeRepository.findById(recipeId);
        String actualDescription = recipe.getSteps().get(stepNumber-1).getDescription();
        assertEquals(stepDescription, actualDescription, String.format("recipe step %d should be %s but is %s", stepNumber, stepDescription, actualDescription));
    }

}
