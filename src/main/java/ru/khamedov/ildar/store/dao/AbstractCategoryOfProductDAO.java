package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import ru.khamedov.ildar.store.model.product.AbstractCategoryOfProduct;

@AutoDAO
public interface AbstractCategoryOfProductDAO extends Dao<AbstractCategoryOfProduct,Long> {
}
