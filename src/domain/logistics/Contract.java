package domain.logistics;

import domain.menu.ingredient.Quantity;
import domain.menu.ingredient.Ingredient;

import java.util.List;

public class Contract {
    private Ingredient ingredient;
    private Supplier supplier;
    private Quantity maxWeeklyRecipeIngredientQuantity;
    private List<Period> periods;
    private IngredientPrice price;

}

