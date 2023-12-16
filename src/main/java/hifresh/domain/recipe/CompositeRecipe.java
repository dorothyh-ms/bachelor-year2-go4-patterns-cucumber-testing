package hifresh.domain.recipe;

import hifresh.domain.pricing.RecipePricingStrategy;
import hifresh.domain.util.Duration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CompositeRecipe extends RecipeComponent{

    private int id;
    private String name;

    private Duration preparationTime;
    private final List<Step> steps = new ArrayList<>();
    private String description;
    private String picture;

    private RecipePricingStrategy pricingStrategy;
    private List<RecipeComponent> subRecipes = new ArrayList<>();

    public CompositeRecipe() {
        super();
    }



    public void addSubRecipe(RecipeComponent recipe) {
        this.subRecipes.add(recipe);
    }


    public List<RecipeComponent> getSubRecipes() {
        return subRecipes;
    }

    @Override
    public void setPricingStrategy(RecipePricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
        subRecipes.forEach(subRecipe -> {subRecipe.setPricingStrategy(pricingStrategy);});
    }

    @Override
    public double calculateCost(LocalDate date) {
        double cost = 0;
        System.out.println("running calculateCost");
        for (RecipeComponent recipeComponent : subRecipes){
            double recipeCost = recipeComponent.calculateCost(date);
            System.out.println(recipeCost);
            cost += recipeCost;
        }
        cost += pricingStrategy.calculateCost(this, date);
        return cost;
    }

    @Override
    public String toString() {
        return "CompositeRecipe{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }
}
