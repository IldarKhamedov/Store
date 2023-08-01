package ru.khamedov.ildar.store.dao;

import net.sf.autodao.AutoDAO;
import net.sf.autodao.Dao;
import net.sf.autodao.Finder;
import ru.khamedov.ildar.store.model.users.Moderator;

import java.util.List;

@AutoDAO
public interface ModeratorDAO extends Dao<Moderator,String> {

    @Finder(query = "FROM Moderator m WHERE m.blocked=FALSE")
    List<Moderator> findAllModerator();
}
