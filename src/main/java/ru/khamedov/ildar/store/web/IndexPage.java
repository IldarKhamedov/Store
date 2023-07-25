package ru.khamedov.ildar.store.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;

/**
 * Главная страница.
 */
public class IndexPage extends WebPage {

    public IndexPage() {

        Label testLabel = new Label("label", "Test label.");
        add(testLabel);

        Link<Void> reloadLink = new Link<Void>("href") {
            @Override
            public void onClick() {
                setResponsePage(getPage());
            }
        };
        add(reloadLink);
    }
}
