package domain.logistics;

import domain.quantity.MeasurementUnit;

public record IngredientPrice(double moneyAmount, MeasurementUnit unit) {
}
