package ru.khamedov.ildar.store.model.description;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;

@Entity
public abstract class Code extends AutoLongIdPersistentEntity {

    private long number;

}
