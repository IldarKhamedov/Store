package ru.khamedov.ildar.store.model.description;

import org.hibernate.annotations.Type;
import ru.khamedov.ildar.store.model.AutoLongIdPersistentEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GeneralInformation extends AutoLongIdPersistentEntity {

    private String name;

    @Lob
    @Type(type = "org.hibernate.type.TextType")
    private String description;

    private boolean deleted;

    @OneToMany
    @JoinColumn(name = "generalInformation_id")
    private List<ImageFile> imageFileList=new ArrayList<>();
}
