package ru.khamedov.ildar.store.model.product;


import ru.khamedov.ildar.store.model.*;
import ru.khamedov.ildar.store.model.description.GeneralInformation;
import ru.khamedov.ildar.store.model.description.GroupCode;
import ru.khamedov.ildar.store.model.description.IndividualCode;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"groupCode_id", "individualCode_id"})})
public  class Product extends AutoLongIdPersistentEntity {

    @OneToOne(optional = false)
    private GeneralInformation generalInformation;

    private Double cost;

    @OneToOne
    private Producer producer;

    @OneToOne
    private Remainder remainder;

    @OneToOne
    private GroupCode groupCode;

    @OneToOne
    private IndividualCode individualCode;

}
