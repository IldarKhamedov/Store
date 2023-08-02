package ru.khamedov.ildar.store.model.product;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CategoryOfProduct extends AbstractCategoryOfProduct{

    @OneToMany(mappedBy = "categoryOfProduct")
    private List<SubCategoryOfProduct> subCategoryOfProductList=new ArrayList<>();

    public List<SubCategoryOfProduct> getSubCategoryOfProductList() {
        return subCategoryOfProductList;
    }

    public void setSubCategoryOfProductList(List<SubCategoryOfProduct> subCategoryOfProductList) {
        this.subCategoryOfProductList = subCategoryOfProductList;
    }
}
