package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;

@Entity
public class Storekeeper extends Staff{

    private  double bonus=20;

    public Storekeeper(String login, String firstName, String lastName, String password, String email, String phoneNumber) {
        super(login, firstName, lastName, password, email, phoneNumber);
    }

    public Storekeeper() {
        super();
    }
}
