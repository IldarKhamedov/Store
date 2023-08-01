package ru.khamedov.ildar.store.service;

import ru.khamedov.ildar.store.dao.SellerDAO;
import ru.khamedov.ildar.store.dao.StaffDAO;
import ru.khamedov.ildar.store.dao.StorekeeperDAO;
import ru.khamedov.ildar.store.enums.Position;
import ru.khamedov.ildar.store.model.users.Seller;
import ru.khamedov.ildar.store.model.users.Staff;
import ru.khamedov.ildar.store.model.users.Storekeeper;

import javax.annotation.Resource;

public class StaffService {
    @Resource
    private SellerDAO sellerDAO;

    @Resource
    private StorekeeperDAO storekeeperDAO;

    @Resource
    private StaffDAO staffDAO;



    public void createStaff(Staff staff,String position){
        if(staff.getLogin()!=null){
            staffDAO.saveOrUpdate(staff);
            return;
        }
        Staff createdStaff;
        if(Position.getPosition(position) == Position.Seller){
            createdStaff=new Seller();
            fillStaff(staff,createdStaff);
            sellerDAO.saveOrUpdate((Seller) createdStaff);
        }else {
            createdStaff=new Storekeeper();
            fillStaff(staff,createdStaff);
            storekeeperDAO.saveOrUpdate((Storekeeper) createdStaff);
        }
    }

    private void fillStaff(Staff staff,Staff staffToFill){
        staffToFill.setLogin(staff.getEmail());
        staffToFill.setFirstName(staff.getFirstName());
        staffToFill.setLastName(staff.getLastName());
        staffToFill.setEmail(staff.getEmail());
        staffToFill.setPhoneNumber(staff.getPhoneNumber());
        staffToFill.setPassword(staff.getEmail());

    }
}
