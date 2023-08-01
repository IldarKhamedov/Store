package ru.khamedov.ildar.store.security;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;
import ru.khamedov.ildar.store.dao.SuperUserDAO;
import ru.khamedov.ildar.store.model.users.*;

import javax.annotation.Resource;
import java.util.ArrayList;


/**
 * Сервис для получения информации о пользователях для Spring security.
 */
public class UserDetailsServiceImpl implements UserDetailsService {


    @Resource
    private SuperUserDAO superUserDAO;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        SuperUser superUser=superUserDAO.get(login.toLowerCase());
        if (superUser == null) {
            throw new UsernameNotFoundException("User not found!");
        }
        if (superUser instanceof Client){
            authorities.add(new SimpleGrantedAuthority("ROLE_CLIENT"));
        }
        if (superUser instanceof Moderator){
            authorities.add(new SimpleGrantedAuthority("ROLE_MODERATOR"));
        }
        if (superUser instanceof Owner){
            authorities.add(new SimpleGrantedAuthority("ROLE_OWNER"));
        }
        if (superUser instanceof Seller){
            authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
        }
        if (superUser instanceof Storekeeper){
            authorities.add(new SimpleGrantedAuthority("ROLE_STOREKEEPER"));
        }
        return new User(login, superUser.getPassword(),!superUser.isBlocked(),true, true, true, authorities);
    }
}