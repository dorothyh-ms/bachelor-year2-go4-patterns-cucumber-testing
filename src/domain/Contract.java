package domain;

import java.util.List;

public class Contract {
    private Ingredient ingredient;
    private Supplier supplier;
    private Quantity maxWeeklyQuantity;
    private List<Period> periods;
    private IngredientPrice price;

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Quantity getMaxWeeklyQuantity() {
        return maxWeeklyQuantity;
    }

    public void setMaxWeeklyQuantity(Quantity maxWeeklyQuantity) {
        this.maxWeeklyQuantity = maxWeeklyQuantity;
    }

    public List<Period> getPeriods() {
        return periods;
    }

    public void setPeriods(List<Period> periods) {
        this.periods = periods;
    }

    public IngredientPrice getPrice() {
        return price;
    }

    public void setPrice(IngredientPrice price) {
        this.price = price;
    }
}

