package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Client extends SuperUser {

    public Client(String login, String firstName, String lastName, String password, String email, String phoneNumber) {
        super(login, firstName, lastName, password, email, phoneNumber);
    }

    public Client() {
    }

    @Transient
    public boolean isAnonymous() {
        return false;
    }
}
