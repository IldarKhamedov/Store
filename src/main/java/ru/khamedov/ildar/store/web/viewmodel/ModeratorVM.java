package ru.khamedov.ildar.store.web.viewmodel;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Window;
import ru.khamedov.ildar.store.dao.StaffDAO;
import ru.khamedov.ildar.store.model.users.Seller;
import ru.khamedov.ildar.store.model.users.Staff;
import ru.khamedov.ildar.store.model.users.Storekeeper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@VariableResolver(DelegatingVariableResolver.class)
public class ModeratorVM {

    @WireVariable
    private StaffDAO staffDAO;

    private boolean seller=false;

    private boolean storekeeper=false;

    private boolean blocked=false;

    public List<Staff> getStaffList(){
        return staffDAO.findStaffByFilter(seller,storekeeper,blocked);
    }

    @Command
    @NotifyChange("staffList")
    public void findStaffByFilter(){

    }

    @Command
    @NotifyChange("staffList")
    public void blockedUser(@BindingParam("staff")Staff staff){
        staffDAO.saveOrUpdate(staff);
    }

    @Command
    @NotifyChange("staffList")
    public void deletedUser(@BindingParam("staff")Staff staff){
        staff.setDeleted(true);
        staffDAO.saveOrUpdate(staff);
    }


    @Command
    public void editStaff(@BindingParam("staff")Staff staff) {
        Map<String, Staff> args=new HashMap<>();
        args.put("staff",staff);
        final Window win = (Window) Executions.createComponents("editStaff.zul", null, args);
        win.addEventListener("onStaffSave",
                event -> BindUtils.postNotifyChange(null, null, ModeratorVM.this, "staffList")
        );
    }


    public String getPosition(Staff staff){
        if(staff instanceof Seller){
            return "продавец";
        }
        if(staff instanceof Storekeeper){
            return "кладовщик";
        }
        return "";
    }

    public boolean isSeller() {
        return seller;
    }

    public boolean isStorekeeper() {
        return storekeeper;
    }

    public void setSeller(boolean seller) {
        this.seller = seller;
    }

    public void setStorekeeper(boolean storekeeper) {
        this.storekeeper = storekeeper;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }
}
