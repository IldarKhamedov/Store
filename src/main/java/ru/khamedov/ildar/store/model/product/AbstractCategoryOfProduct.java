package ru.khamedov.ildar.store.model.product;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;
import ru.khamedov.ildar.store.model.description.GeneralInformation;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public abstract class AbstractCategoryOfProduct extends AutoLongIdPersistentEntity {

    @OneToOne(optional = false,cascade = CascadeType.ALL)
    private GeneralInformation generalInformation;

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }
}
