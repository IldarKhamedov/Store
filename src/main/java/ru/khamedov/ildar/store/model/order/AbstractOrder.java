package ru.khamedov.ildar.store.model.order;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;
import ru.khamedov.ildar.store.model.product.Purchase;
import ru.khamedov.ildar.store.model.users.Anonymous;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class AbstractOrder extends AutoLongIdPersistentEntity {


    @ManyToOne(optional = false)
    private Anonymous anonymous;


    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "abstractOrder_id")
    private List<Purchase> purchaseList=new ArrayList<>();

}
