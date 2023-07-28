package ru.khamedov.ildar.store.web;


import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.protocol.http.servlet.ServletWebRequest;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.cycle.RequestCycle;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.web.WebAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;

/**
 *  Login page for authentication of anonymous.
 */
public class SignInPage extends WebPage{




    public SignInPage() {


        add(new Label("error", new IModel<String>() {
            @Override
            public String getObject() {
                Request request = RequestCycle.get().getRequest();
                final HttpServletRequest containerRequest = ((ServletWebRequest) request).getContainerRequest();
                Object lastException = WebUtils.getSessionAttribute(containerRequest,WebAttributes.AUTHENTICATION_EXCEPTION);
                WebUtils.setSessionAttribute(containerRequest,WebAttributes.AUTHENTICATION_EXCEPTION, null);
                if(lastException instanceof BadCredentialsException){
                    return "Неправильные логин или пароль";
                }
                return lastException==null?"":lastException.toString();
            }
        }));
    }
}
