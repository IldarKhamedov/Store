package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;

@Entity
public class Staff extends SuperUser {

    private double salary=50000;

    private boolean deleted;

    public Staff(String login, String firstName, String lastName, String password, String email, String phoneNumber) {
        super(login, firstName, lastName, password, email, phoneNumber);
    }

    public Staff() {
        super();
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
