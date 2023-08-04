package ru.khamedov.ildar.store.model.product;


import ru.khamedov.ildar.store.model.*;
import ru.khamedov.ildar.store.model.description.GeneralInformation;
import ru.khamedov.ildar.store.model.description.GroupCode;
import ru.khamedov.ildar.store.model.description.IndividualCode;
import ru.khamedov.ildar.store.model.users.Seller;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"groupCode_id", "individualCode_id"})})
public  class Product extends AutoLongIdPersistentEntity {

    @OneToOne(optional = false)
    private GeneralInformation generalInformation;

    private Double cost;

    @ManyToOne(optional = false)
    private Producer producer;

    @OneToOne(optional = false)
    private Remainder remainder;

    @ManyToOne(optional = false)
    private GroupCode groupCode;

    @OneToOne(optional = false)
    private IndividualCode individualCode;

    @ManyToOne(optional = false)
    private Seller seller;

    public GeneralInformation getGeneralInformation() {
        return generalInformation;
    }

    public void setGeneralInformation(GeneralInformation generalInformation) {
        this.generalInformation = generalInformation;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public Remainder getRemainder() {
        return remainder;
    }

    public void setRemainder(Remainder remainder) {
        this.remainder = remainder;
    }

    public GroupCode getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(GroupCode groupCode) {
        this.groupCode = groupCode;
    }

    public IndividualCode getIndividualCode() {
        return individualCode;
    }

    public void setIndividualCode(IndividualCode individualCode) {
        this.individualCode = individualCode;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }
}
