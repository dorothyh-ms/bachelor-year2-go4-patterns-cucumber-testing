package domain.sales.price;

import domain.sales.order.LineItem;

import java.util.List;

public interface OrderPriceStrategy {
    public double calculatePrice(List<LineItem> lineItems);
}
