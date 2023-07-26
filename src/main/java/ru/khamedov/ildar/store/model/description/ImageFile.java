package ru.khamedov.ildar.store.model.description;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ImageFile extends AutoLongIdPersistentEntity {

    @OneToOne
    private ImageContent imageContent;

    /**
     * Размер.
     */
    private long length;
    /**
     * Тип содержимого.
     */
    private String contentType;
}
