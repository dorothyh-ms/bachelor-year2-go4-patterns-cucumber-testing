package hifresh;

import hifresh.controllers.RecipeController;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.Matchers.closeTo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class CalculateCostOfARecipeSteps extends CucumberIntegrationTest {
    @Autowired
    RecipeController recipeController;

    LocalDate recipeCostCalculationDate;


    @Given("the date is {int}-{int}-{int}")
    public void theDateIs(int year, int month, int day) {
        recipeCostCalculationDate = LocalDate.of(year, month, day);
    }

    @Then("the average cost of recipe {int} is {double}")
    public void theAverageCostOfRecipeIs(int recipeId, double recipeCost) {
        recipeController.setPricingStrategy(recipeId, "weightedaverage");
        double actualRecipeCost = recipeController.calculateCost(recipeId, recipeCostCalculationDate);
        assertEquals(recipeCost, actualRecipeCost, 0.0000001,  String.format("recipe with id %d should have price %f but has price %f", recipeId, recipeCost, actualRecipeCost));

    }
}
