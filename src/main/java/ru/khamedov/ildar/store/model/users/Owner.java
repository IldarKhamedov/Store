package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;

@Entity
public class Owner extends SuperUser{

    public Owner(String login, String firstName, String lastName, String password, String email, String phoneNumber) {
        super(login, firstName, lastName, password, email, phoneNumber);
    }
}
