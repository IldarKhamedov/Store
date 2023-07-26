package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import ru.khamedov.ildar.store.model.product.Product;

@AutoDAO
public interface ProductDAO extends Dao<Product,Long> {
}
