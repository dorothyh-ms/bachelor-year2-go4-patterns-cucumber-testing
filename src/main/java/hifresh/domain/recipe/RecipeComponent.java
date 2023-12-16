package hifresh.domain.recipe;

import hifresh.domain.pricing.RecipePricingStrategy;
import hifresh.domain.util.Duration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class RecipeComponent {
    private int id;
    private String name;

    private Duration preparationTime;
    private final List<Step> steps = new ArrayList<>();
    private String description;
    private String picture;

    private List<Label> labels = new ArrayList<>();
    private final List<Ingredient> ingredients = new ArrayList<>();

    private RecipePricingStrategy pricingStrategy;

    public RecipeComponent() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Duration getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Duration preparationTime) {
        this.preparationTime = preparationTime;
    }

    public List<Step> getSteps() {
        return steps;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void addStep(int index, Step step){
        steps.add(index, step);
    }

    public void addStep(Step step){
        steps.add(step);
    }


    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient){
        if (!ingredients.contains(ingredient)){
            ingredients.add(ingredient);
        }
    }


    public abstract void setPricingStrategy(RecipePricingStrategy pricingStrategy);

    public abstract double calculateCost(LocalDate date);

    @Override
    public String toString() {
        return "RecipeComponent{" +
                "name='" + name + '\'' +
                '}';
    }
}
