package ru.khamedov.ildar.store.web;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import ru.khamedov.ildar.store.service.ProductService;

/**
 * Главная страница.
 */
public class IndexPage extends SuperPage {

    @SpringBean
    private ProductService productService;

    public IndexPage() {

        Label testLabel = new Label("label");
        add(testLabel);

        Link<Void> reloadLink = new Link<Void>("href") {
            @Override
            public void onClick() {
            }
        };
        add(reloadLink);
    }
}
