package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import ru.khamedov.ildar.store.model.users.Anonymous;

@AutoDAO
public interface AnonymousDAO extends Dao<Anonymous,String> {
}
