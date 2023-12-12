package hifresh.domain.purchase;

import hifresh.domain.util.Quantity;

import java.time.LocalDate;

public class Purchase {
    private Quantity quantity;
    private LocalDate orderDate;
    private LocalDate confirmationDate;
    private PurchaseState state;
    private boolean withContract;

    private Clause clause;
}
