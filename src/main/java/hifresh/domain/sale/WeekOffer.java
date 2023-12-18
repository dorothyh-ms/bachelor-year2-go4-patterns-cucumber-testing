package hifresh.domain.sale;

import hifresh.domain.recipe.CompositeRecipe;
import hifresh.domain.recipe.RecipeComponent;
import hifresh.domain.util.Week;

import java.util.List;

public class WeekOffer {
    private Week week;
    private double salesPricePerPerson;

    private List<RecipeComponent> recipes;
}
