package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import ru.khamedov.ildar.store.model.product.CategoryOfProduct;

import java.util.List;

@AutoDAO
public interface CategoryOfProductDAO extends Dao<CategoryOfProduct,Long> {

    @Finder(query = "FROM CategoryOfProduct cat WHERE cat.generalInformation.deleted=FALSE")
    List<CategoryOfProduct> findAllNotDeleted();
}
