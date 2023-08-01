package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import net.sf.autodao.Named;
import ru.khamedov.ildar.store.model.users.Staff;

import java.util.List;

@AutoDAO
public interface StaffDAO extends Dao<Staff,String> {



    @Finder(query = " SELECT stf FROM Staff stf" +
            " LEFT JOIN Seller slr ON  stf.login=slr.login" +
            " LEFT JOIN Storekeeper skr ON stf.login=skr.login" +
            " WHERE " +
            " ( "+
                " (" +
                    " slr IS NOT NULL " +
                            " AND " +
                    " :isSeller=TRUE "
                     +
                " ) "+
                " OR "+
                " ( "+
                     " skr IS NOT NULL"+
                        " AND " +
                    " :isStorekeeper=TRUE " +
                " ) "+
            " ) "+
            " AND "+
            " stf.blocked=:isBlocked "+
            " AND "+
            " stf.deleted=FALSE "
            )
    List<Staff> findStaffByFilter(@Named("isSeller")boolean isSeller,
                                  @Named("isStorekeeper")boolean isStorekeeper,
                                  @Named("isBlocked")boolean isBlocked);

    @Finder(query = "SELECT COUNT(staff)>0 FROM Staff staff WHERE staff.login=:login")
    boolean isExistStaffByLogin(@Named("login") String login);
}
