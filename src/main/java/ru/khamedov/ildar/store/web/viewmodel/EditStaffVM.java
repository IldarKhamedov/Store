package ru.khamedov.ildar.store.web.viewmodel;


import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Window;
import ru.khamedov.ildar.store.dao.StaffDAO;
import ru.khamedov.ildar.store.enums.Position;
import ru.khamedov.ildar.store.model.users.Seller;
import ru.khamedov.ildar.store.model.users.Staff;
import ru.khamedov.ildar.store.model.users.Storekeeper;
import ru.khamedov.ildar.store.service.StaffService;
import ru.khamedov.ildar.store.web.StoreEmailValidator;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@VariableResolver(DelegatingVariableResolver.class)
public class EditStaffVM {

    private Window window;

    private Staff staff;

    private String position=Position.Seller.getName();

    @WireVariable
    private StaffDAO staffDAO;

    @WireVariable
    private StaffService staffService;

    @Init
    public void init(
            @ContextParam(ContextType.VIEW) Component view,
            @ExecutionArgParam("staff") Staff staff) {

        if(staff!=null) {
            this.staff = staff;
        } else {
            this.staff=new Staff();
        }

        this.window = (Window) view;
    }

    @Command
    public void saveStaff() {
        staffService.createStaff(staff,getPosition());
        Events.postEvent("onStaffSave", window, null);
        window.detach();
    }

    @Command
    public void cancelStaff() {
        window.detach();
    }

    public List<String> getPositionList(){
        return Arrays.asList(Position.values()).stream().map(p->p.getName()).collect(Collectors.toList());
    }




    public boolean getEditStaff(){
        return staff.getLogin() != null;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPosition() {
        if(staff.getLogin()!=null){
            if(staff instanceof Seller){
                return Position.Seller.getName();
            }
            if(staff instanceof Storekeeper){
                return Position.Storekeeper.getName();
            }
        }
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public StoreEmailValidator getEmailValidator(){
        return new StoreEmailValidator(staffDAO);
    }
}
