package ru.khamedov.ildar.store.model.users;

import net.sf.autodao.PersistentEntity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Anonymous implements PersistentEntity<String> {

    @Id
    private String login;


    public Anonymous(String login) {
        this.login = login;
    }

    public Anonymous() {
    }

    @Override
    public String getPrimaryKey() {
        return login;
    }

    @Transient
    public boolean isAnonymous() {
        return true;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
