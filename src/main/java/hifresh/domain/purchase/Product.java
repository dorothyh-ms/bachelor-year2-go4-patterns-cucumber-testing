package hifresh.domain.purchase;

import hifresh.domain.util.Unit;

import java.util.ArrayList;
import java.util.List;

public class Product {

    private int id;
    private String name;
    private Unit unit;

    private final List<Contract> contracts = new ArrayList<>();
    public Product(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }


    public void addContract(Contract contract) {
        if (!contracts.contains(contract)){
            contracts.add(contract);
        }
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", unit=" + unit +
                '}';
    }

    public List<Contract> getContracts() {
        return contracts;
    }
}
