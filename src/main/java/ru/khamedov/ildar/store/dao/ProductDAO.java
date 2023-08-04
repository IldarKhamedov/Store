package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import net.sf.autodao.Named;
import ru.khamedov.ildar.store.model.product.Product;
import ru.khamedov.ildar.store.model.product.Purchase;
import ru.khamedov.ildar.store.model.users.Anonymous;

import java.time.Instant;
import java.util.List;

@AutoDAO
public interface ProductDAO extends Dao<Product,Long> {


}
