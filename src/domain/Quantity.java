package domain;

public record Quantity(int amount, MeasurementUnit unit) {
    @Override
    public int amount() {
        return amount;
    }

    @Override
    public MeasurementUnit unit() {
        return unit;
    }
}
