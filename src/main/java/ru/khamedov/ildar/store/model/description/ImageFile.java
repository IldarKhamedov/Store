package ru.khamedov.ildar.store.model.description;

import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class ImageFile extends AutoLongIdPersistentEntity {

    @OneToOne(cascade = CascadeType.ALL)
    private ImageContent imageContent;

    /**
     * Размер.
     */
    private long length;
    /**
     * Тип содержимого.
     */
    private String contentType;

    public ImageContent getImageContent() {
        return imageContent;
    }

    public void setImageContent(ImageContent imageContent) {
        this.imageContent = imageContent;
    }

    public long getLength() {
        return length;
    }

    public void setLength(long length) {
        this.length = length;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }
}
