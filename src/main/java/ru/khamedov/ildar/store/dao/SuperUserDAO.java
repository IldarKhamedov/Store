package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import ru.khamedov.ildar.store.model.users.SuperUser;

@AutoDAO
public interface SuperUserDAO extends Dao<SuperUser,String> {
}
