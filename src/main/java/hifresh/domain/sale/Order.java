package hifresh.domain.sale;

import hifresh.domain.util.Week;

import java.time.LocalDate;
import java.util.List;

public class Order {
    private Week week;
    private LocalDate orderDate;

    private Customer customer;

    private Transport transport;

    private WeekOffer offer;
    private List<Meal> meals;

    private double getDiscount(){
        return 0.0;
    }
}
