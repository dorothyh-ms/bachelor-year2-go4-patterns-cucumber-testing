package hifresh.domain.recipe;

import hifresh.domain.purchase.Product;
import hifresh.domain.util.Quantity;

import java.util.Objects;

public class Ingredient {

    private int id;
    private Quantity quantity;
    private Product product;

    private RecipeComponent recipe;

    public Ingredient(Quantity quantity, Product product) {
        this.quantity = quantity;
        this.product = product;
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

    public RecipeComponent getRecipe() {
        return recipe;
    }

    public void setRecipe(RecipeComponent recipeComponent) {
        if (this.recipe != recipeComponent){
            this.recipe = recipeComponent;
        }
    }





    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", product=" + product +
                '}';
    }
}
