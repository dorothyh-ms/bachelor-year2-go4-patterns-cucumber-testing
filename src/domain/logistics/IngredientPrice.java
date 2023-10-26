package domain.logistics;

import domain.menu.ingredient.MeasurementUnit;

public record IngredientPrice(double moneyAmount, MeasurementUnit unit) {
}
