package ru.khamedov.ildar.store.model.product;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;
import ru.khamedov.ildar.store.model.description.GeneralInformation;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public abstract class AbstractCategoryOfProduct extends AutoLongIdPersistentEntity {

    @OneToOne
    @Basic(optional = false)
    private GeneralInformation generalInformation;

}
