package ru.khamedov.ildar.store.model.order;


import javax.persistence.Entity;
import java.time.Instant;

@Entity
public class Ordering extends AbstractOrder {

    private Instant createdTime=Instant.now();

    private Instant deliveryTime;

}
