package ru.khamedov.ildar.store;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import ru.khamedov.ildar.store.dao.*;
import ru.khamedov.ildar.store.model.users.*;

import javax.annotation.Resource;

public class DataLoader implements InitializingBean{

    @Resource
    private ModeratorDAO moderatorDAO;
    @Resource
    private ClientDAO clientDAO;
    @Resource
    private SellerDAO sellerDAO;
    @Resource
    private StorekeeperDAO storekeeperDAO;
    @Resource
    private OwnerDao ownerDao;

    @Resource
    private ApplicationContext applicationContext;


    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        applicationContext.getBean(DataLoader.class).fillBase();
    }


    @Transactional
    public void fillBase(){
        generateUsers();
    }
    private void generateUsers(){
        if(moderatorDAO.findAllModerator().isEmpty()){
            moderatorDAO.saveOrUpdate(new Moderator("moderator","moderator","moderator","moderator","moderator@mail.ru","1234567"));
            ownerDao.saveOrUpdate(new Owner("owner","owner","owner","owner","owner@mail.ru","1234567"));
        }
        if(clientDAO.findAllClient().isEmpty()){
            for(int i=1;i<=10;i++){
                clientDAO.saveOrUpdate(new Client("client"+i,"client"+i,"client"+i,"client"+i,"client"+i+"@mail.ru","1234567"));
                sellerDAO.saveOrUpdate(new Seller("seller"+i,"seller"+i,"seller"+i,"seller"+i,"seller"+i+"@mail.ru","1234567"));
                storekeeperDAO.saveOrUpdate(new Storekeeper("storekeeper"+i,"storekeeper"+i,"storekeeper"+i,"storekeeper"+i,"storekeeper"+i+"@mail.ru","1234567"));
            }
        }
    }
}