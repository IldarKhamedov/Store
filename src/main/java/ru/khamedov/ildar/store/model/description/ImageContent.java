package ru.khamedov.ildar.store.model.description;

import org.hibernate.annotations.Type;
import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;
import javax.persistence.Lob;

@Entity
public class ImageContent  extends AutoLongIdPersistentEntity {

    @Type(type="org.hibernate.type.BinaryType")
    @Lob
    private byte[] content = new byte[0];

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
