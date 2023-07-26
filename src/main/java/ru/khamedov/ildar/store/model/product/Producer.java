package ru.khamedov.ildar.store.model.product;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;

@Entity
public class Producer extends AutoLongIdPersistentEntity {

    private String country;

    private String city;
}
