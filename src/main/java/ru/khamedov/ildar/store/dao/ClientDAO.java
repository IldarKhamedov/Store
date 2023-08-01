package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import ru.khamedov.ildar.store.model.users.Client;

import java.util.List;

@AutoDAO
public interface ClientDAO extends Dao<Client,String> {

    @Finder(query = "FROM Client c WHERE c.blocked=FALSE")
    List<Client> findAllClient();
}
