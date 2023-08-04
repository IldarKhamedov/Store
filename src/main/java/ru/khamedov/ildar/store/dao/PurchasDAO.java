package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import net.sf.autodao.Named;
import ru.khamedov.ildar.store.model.product.Purchase;

import java.time.Instant;
import java.util.List;

@AutoDAO
public interface PurchasDAO extends Dao<Purchase,Long> {

    @Finder(query = "SELECT purchase FROM Ordering ord "+
            " LEFT JOIN ord.purchaseList as purchase"+
            " WHERE ord.createdTime >:period "+
            " AND " +
            " purchase.product.seller.login=:login "+
            " AND "+
            " purchase.paidFor=TRUE "
    )
    List<Purchase> findProductOfOrderingBySellerAndPeriod(@Named("login")String login,
                                                          @Named("period") Instant period);
}
