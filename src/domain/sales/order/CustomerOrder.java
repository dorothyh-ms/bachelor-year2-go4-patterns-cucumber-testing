package domain.sales.order;

import domain.delivery.OrderStatus;
import domain.sales.customer.Customer;
import domain.sales.payment.Payment;
import domain.sales.price.OrderPriceStrategy;

import java.time.LocalDate;

public class CustomerOrder {
    private LocalDate dateOrdered;
    private OrderPriceStrategy pricingStrategy;
    private OrderStatus orderStatus;

    private Customer customer;

    private Payment payment;
}
