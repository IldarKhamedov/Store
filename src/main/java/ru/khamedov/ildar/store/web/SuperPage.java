package ru.khamedov.ildar.store.web;

import org.apache.wicket.markup.html.WebPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * .
 */

public class SuperPage extends WebPage {
    private static final Logger LOG = LoggerFactory.getLogger(SuperPage.class);

    public SuperPage() {
        super();
        init();
    }

    private void init() {

        SelectPanel selectPanel=new SelectPanel("selectPanel");
        add(selectPanel);

    }
}
