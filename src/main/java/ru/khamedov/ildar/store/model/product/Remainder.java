package ru.khamedov.ildar.store.model.product;

import ru.khamedov.ildar.store.enums.UnitOfMeasurement;
import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Remainder extends AutoLongIdPersistentEntity {

    @Enumerated(EnumType.STRING)
    private UnitOfMeasurement unitOfMeasurement;

    private double quantity;
}
