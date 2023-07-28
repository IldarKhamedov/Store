package ru.khamedov.ildar.store.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.khamedov.ildar.store.dao.AnonymousDAO;
import ru.khamedov.ildar.store.dao.SuperUserDAO;
import ru.khamedov.ildar.store.model.users.Anonymous;

import javax.annotation.Resource;

/**
 * Сервис для доступа к залогиненому на данный момент пользователю.
 */

public class AuthenticationService {
    private static final Logger LOG = LoggerFactory.getLogger(AuthenticationService.class);

    @Resource
    private AnonymousDAO anonymousDAO;

    @Resource
    private SuperUserDAO superUserDAO;

    private String httpSessionId;

    private boolean isAnonymousUser(){
        return SecurityContextHolder.getContext().getAuthentication().getPrincipal().equals("anonymousUser");
    }
    public Anonymous getLogginedUser() {
        if(isAnonymousUser()){
            return anonymousDAO.get(httpSessionId);
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String loginContext=authentication.getName();
        return superUserDAO.get(loginContext.toLowerCase());
    }

    public void setHttpSessionId(String httpSessionId) {
        this.httpSessionId = httpSessionId;
    }
}
