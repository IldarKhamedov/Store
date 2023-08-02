package ru.khamedov.ildar.store.web.viewmodel;


import org.zkoss.bind.annotation.*;
import org.zkoss.util.media.Media;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Window;
import ru.khamedov.ildar.store.dao.AbstractCategoryOfProductDAO;
import ru.khamedov.ildar.store.model.description.GeneralInformation;
import ru.khamedov.ildar.store.model.description.ImageFile;
import ru.khamedov.ildar.store.model.product.AbstractCategoryOfProduct;
import ru.khamedov.ildar.store.model.product.CategoryOfProduct;
import ru.khamedov.ildar.store.util.Utils;

import java.io.IOException;


@VariableResolver(DelegatingVariableResolver.class)
public class AddCategoryVM {

    private Window window;

    private AbstractCategoryOfProduct abstractCategoryOfProduct;

    @WireVariable
    private AbstractCategoryOfProductDAO abstractCategoryOfProductDAO;

    @Init
    public void init(@ContextParam(ContextType.VIEW) Component view) {
        this.window = (Window) view;
        GeneralInformation generalInformation=new GeneralInformation();
        abstractCategoryOfProduct=new CategoryOfProduct();
        abstractCategoryOfProduct.setGeneralInformation(generalInformation);
    }

    @Command
    public void saveCategory() {
        abstractCategoryOfProductDAO.saveOrUpdate(abstractCategoryOfProduct);
        Events.postEvent("onCategorySave", window, null);
        window.detach();
    }

    @Command
    public void cancelCategory() {
        window.detach();
    }




    @Command
    public void addPicture(@BindingParam("media") Media media) throws IOException {
        abstractCategoryOfProduct.getGeneralInformation().getImageFileList().add(Utils.loadImageFile(media,new ImageFile()));
    }

    public AbstractCategoryOfProduct getAbstractCategoryOfProduct() {
        return abstractCategoryOfProduct;
    }
}
