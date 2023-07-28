package ru.khamedov.ildar.store.web;


import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.khamedov.ildar.store.model.users.Client;
import ru.khamedov.ildar.store.model.users.Moderator;
import ru.khamedov.ildar.store.service.AuthenticationService;



/**
 * .
 */

public class SelectPanel extends Panel {

    @SpringBean
    private AuthenticationService authenticationService;

    private static final Logger LOG = LoggerFactory.getLogger(SelectPanel.class);

    public SelectPanel(String id) {
        super(id);
        Label moderatorLabel=new Label("moderator","Модератор");
        add(moderatorLabel);
        moderatorLabel.setVisible(authenticationService.getLogginedUser() instanceof Moderator);
        Label clientLabel=new Label("client","Профиль");
        add(clientLabel);
        clientLabel.setVisible(authenticationService.getLogginedUser() instanceof Client);
    }
}
