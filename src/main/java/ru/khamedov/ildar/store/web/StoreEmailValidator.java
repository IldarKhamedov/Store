package ru.khamedov.ildar.store.web;

import org.apache.commons.validator.routines.EmailValidator;
import org.zkoss.bind.ValidationContext;
import org.zkoss.bind.validator.AbstractValidator;
import ru.khamedov.ildar.store.dao.StaffDAO;

public class StoreEmailValidator extends AbstractValidator {

    private StaffDAO staffDAO;

    public StoreEmailValidator(StaffDAO staffDAO) {
        this.staffDAO = staffDAO;
    }

    private static final String ERROR_EMAIL ="Введите email";
    private static final String ERROR_LOGIN ="Замените логин";
    @Override
    public void validate(ValidationContext validationContext) {
        EmailValidator emailValidator=EmailValidator.getInstance();
        String email = (String) validationContext.getProperty().getValue();
        if(!emailValidator.isValid(email)){
            addInvalidMessage(validationContext, ERROR_EMAIL);
            return;
        }
        if(staffDAO.isExistStaffByLogin(email)){
            addInvalidMessage(validationContext, ERROR_LOGIN);
        }


    }


}
