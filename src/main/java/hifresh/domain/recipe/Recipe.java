package hifresh.domain.recipe;

import hifresh.domain.purchase.Product;
import hifresh.domain.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class Recipe {

    private int id;
    private String name;

    private Duration preparationTime;
    private final List<Step> steps = new ArrayList<>();
    private String description;
    private String picture;
    private List<Recipe> subRecipes = new ArrayList<>();



    public Recipe(String name) {
        this.name = name;
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


    public void addSubRecipe(Recipe subRecipe) {
        this.subRecipes.add(subRecipe);
    }


    public void addStep(int index, Step step){
        steps.add(index, step);
    }

    public void addStep(Step step){
        steps.add(step);
    }

    public void clearSteps(){
        steps.clear();
    }

    public void clearSubRecipes(){
        subRecipes.clear();
    }


    public List<Step> getSteps() {
        return steps;
    }

    public List<Recipe> getSubRecipes() {
        return subRecipes;
    }


}
