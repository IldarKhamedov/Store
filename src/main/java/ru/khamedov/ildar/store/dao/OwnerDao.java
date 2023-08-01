package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import ru.khamedov.ildar.store.model.users.Owner;

@AutoDAO
public interface OwnerDao extends Dao<Owner,String> {
}
