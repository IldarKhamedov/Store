package ru.khamedov.ildar.store.model.users;

import javax.persistence.Entity;
import javax.persistence.Transient;

@Entity
public class Client extends SuperUser {

    @Transient
    public boolean isAnonymous() {
        return false;
    }
}
