package ru.khamedov.ildar.store.model.order;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;
import ru.khamedov.ildar.store.model.users.Anonymous;
import ru.khamedov.ildar.store.model.product.Product;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractOrder extends AutoLongIdPersistentEntity {


    @ManyToOne(optional = false)
    private Anonymous anonymous;

    @ElementCollection(fetch = FetchType.EAGER)
    @MapKeyColumn(name = "product_id")
    @Column(name = "count")
    private Map<Product,Double> product_id=new HashMap<>();

}
