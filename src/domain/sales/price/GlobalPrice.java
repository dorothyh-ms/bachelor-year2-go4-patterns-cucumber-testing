package domain.sales.price;

import domain.sales.order.LineItem;

import java.util.List;

public class GlobalPrice implements OrderPriceStrategy {

    @Override
    public double calculatePrice(List<LineItem> lineItems) {
        return 0;
    }
}
