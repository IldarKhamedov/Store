package ru.khamedov.ildar.store.model;

import net.sf.autodao.PersistentEntity;
import org.hibernate.Hibernate;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Superclass of  all entity with long id and automatically generated id.
 */
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@MappedSuperclass
public class AutoLongIdPersistentEntity implements PersistentEntity<Long> {
    /**
     * primary key of object mapped to database.
     */
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Override
    public Long getPrimaryKey() {
        return id;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        if (id == null) {
            return 0;
        } else {
            return id.hashCode();
        }
    }

    @Override
    public boolean equals(final Object obj) {
        if(obj==null){
            return false;
        }
        if (!(Hibernate.getClass(obj).equals(Hibernate.getClass(this)))) {
            return  false;
        }
        if (id == null) {
            return this == obj;
        }

        Long objId = ((AutoLongIdPersistentEntity) obj).getPrimaryKey();
        return id.equals(objId);
    }
}
