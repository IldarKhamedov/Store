package ru.khamedov.ildar.store.model.description;

import org.hibernate.annotations.Type;
import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GeneralInformation extends AutoLongIdPersistentEntity {

    private String name;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    private boolean deleted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "generalInformation_id")
    private List<ImageFile> imageFileList=new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public List<ImageFile> getImageFileList() {
        return imageFileList;
    }

    public void setImageFileList(List<ImageFile> imageFileList) {
        this.imageFileList = imageFileList;
    }
}
