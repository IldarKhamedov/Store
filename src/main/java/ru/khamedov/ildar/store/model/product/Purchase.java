package ru.khamedov.ildar.store.model.product;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Purchase extends AutoLongIdPersistentEntity {

    @ManyToOne(optional = false)
    private Product product;

    private double count;

    private boolean paidFor;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double getCount() {
        return count;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public boolean isPaidFor() {
        return paidFor;
    }

    public void setPaidFor(boolean paidFor) {
        this.paidFor = paidFor;
    }
}
