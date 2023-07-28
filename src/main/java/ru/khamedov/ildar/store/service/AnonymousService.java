package ru.khamedov.ildar.store.service;

import ru.khamedov.ildar.store.dao.AnonymousDAO;
import ru.khamedov.ildar.store.model.users.Anonymous;

import javax.annotation.Resource;

public class AnonymousService {

    @Resource
    private AnonymousDAO anonymousDAO;

    public void createAnonymous(String login){
        if(anonymousDAO.get(login) == null){
            anonymousDAO.saveOrUpdate(new Anonymous(login));
        }
    }
}
