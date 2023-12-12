package hifresh;

import hifresh.controllers.RecipeController;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


//@SpringBootTest
//@CucumberContextConfiguration
public class CalculateCostOfARecipeSteps {
    @Autowired
    RecipeController recipeController;

    LocalDate recipeCostCalculationDate;

    @ParameterType("\\d{2}\\-\\d{2}\\-\\d{4}")
    public LocalDate formattedDate(String dateString) {
        return LocalDate.parse(dateString, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }
    @Given("the date is {formattedDate}")
    public void theDateIs(LocalDate date) {
        recipeCostCalculationDate = date;
    }

    @Then("the average cost of recipe {int} is {double}")
    public void theAverageCostOfRecipeIs(int recipeId, double recipeCost) {
    }
}
