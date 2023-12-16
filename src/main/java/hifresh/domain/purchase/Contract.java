package hifresh.domain.purchase;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Contract {
    private int id;
    private LocalDate signDate;
    private Product product;
    private final List<Clause> clauses = new ArrayList<>();
    private Supplier supplier;
    private DistributionCenter distributionCenter;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDate signDate) {
        this.signDate = signDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        if (this.product != product) {
        this.product = product;
    }
    }


    public List<Clause> getClauses() {
        return clauses;
    }



    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public DistributionCenter getDistributionCenter() {
        return distributionCenter;
    }

    public void setDistributionCenter(DistributionCenter distributionCenter) {
        this.distributionCenter = distributionCenter;
    }

    public void addClause(Clause clause){
        if (!clauses.contains(clause)){
            clauses.add(clause);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contract contract = (Contract) o;
        return id == contract.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", product=" + product +
                '}';
    }
}
