package hifresh.domain.recipe;

import hifresh.domain.purchase.Product;
import hifresh.domain.util.Quantity;
import hifresh.domain.util.Unit;

public class Ingredient {

    private int id;
    private Quantity quantity;
    private Product product;

    private Recipe recipe;

    public Ingredient(Quantity quantity, Product product, Recipe recipe) {
        this.quantity = quantity;
        this.product = product;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Quantity getQuantity() {
        return quantity;
    }

    public void setQuantity(Quantity quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
}
