package ru.khamedov.ildar.store.model.product;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class SubCategoryOfProduct extends AbstractCategoryOfProduct{

    @ManyToOne
    private CategoryOfProduct categoryOfProduct;

    public CategoryOfProduct getCategoryOfProduct() {
        return categoryOfProduct;
    }

    public void setCategoryOfProduct(CategoryOfProduct categoryOfProduct) {
        this.categoryOfProduct = categoryOfProduct;
    }
}
