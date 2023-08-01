package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import ru.khamedov.ildar.store.model.users.Seller;


import java.util.List;

@AutoDAO
public interface SellerDAO extends Dao<Seller,String> {

    @Finder(query = "FROM Seller s WHERE s.blocked=FALSE")
    List<Seller> findAllSeller();
}
