package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;

@Entity
public class Moderator extends Staff{

    public Moderator(String login, String firstName, String lastName, String password, String email, String phoneNumber) {
        super(login, firstName, lastName, password, email, phoneNumber);
    }

    public Moderator() {
        super();
    }
}
