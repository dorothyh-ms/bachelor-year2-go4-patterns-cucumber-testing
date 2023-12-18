package hifresh.domain.purchase;

import hifresh.domain.sale.Transport;
import hifresh.domain.util.Quantity;

import java.time.LocalDate;

public class Purchase {
    private Quantity quantity;
    private LocalDate orderDate;
    private LocalDate confirmationDate;
    private PurchaseState state;

    private Transport transport;
    private boolean withContract;

    private Clause clause;
}
