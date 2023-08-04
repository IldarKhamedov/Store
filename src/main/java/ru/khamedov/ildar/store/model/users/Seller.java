package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;

@Entity
public class Seller extends Staff{

    private double percentageOfSales=10;

    public Seller(String login, String firstName, String lastName, String password, String email, String phoneNumber) {
        super(login, firstName, lastName, password, email, phoneNumber);
    }

    public Seller() {
        super();
    }

    public double getPercentageOfSales() {
        return percentageOfSales;
    }

    public void setPercentageOfSales(double percentageOfSales) {
        this.percentageOfSales = percentageOfSales;
    }
}
