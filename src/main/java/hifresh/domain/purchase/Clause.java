package hifresh.domain.purchase;

import hifresh.domain.util.Interval;
import hifresh.domain.util.Quantity;

public class Clause {

    private int id;
    private double price;
    private Interval period;

    private Quantity maxQuantity;

    private Contract contract;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Interval getPeriod() {
        return period;
    }

    public void setPeriod(Interval period) {
        this.period = period;
    }

    public Quantity getMaxQuantity() {
        return maxQuantity;
    }

    public void setMaxQuantity(Quantity maxQuantity) {
        this.maxQuantity = maxQuantity;
    }


    public void setContract(Contract contract) {
        if (this.contract != contract){
            this.contract = contract;
        }
    }

    @Override
    public String toString() {
        return "Clause{" +
                "id=" + id +
                ", price=" + price +
                ", period=" + period +
                ", maxQuantity=" + maxQuantity +
                ", contract=" + contract +
                '}';
    }
}
