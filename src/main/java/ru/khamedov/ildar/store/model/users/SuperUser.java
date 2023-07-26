package ru.khamedov.ildar.store.model.users;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public abstract class SuperUser extends Anonymous {

    private String firstName;

    private String lastName;

    @Column(nullable = false)
    private String password;

    private String activationCode;

    @Email
    private String email;

    @Size(min=6, max = 11)
    private String phoneNumber;
}
