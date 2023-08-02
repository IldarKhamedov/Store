package ru.khamedov.ildar.store.web.viewmodel;

import org.zkoss.bind.BindUtils;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zkplus.spring.DelegatingVariableResolver;
import org.zkoss.zul.Window;
import ru.khamedov.ildar.store.dao.CategoryOfProductDAO;
import ru.khamedov.ildar.store.model.product.CategoryOfProduct;

import java.util.List;

@VariableResolver(DelegatingVariableResolver.class)
public class CategoryVM {

    @WireVariable
    private CategoryOfProductDAO categoryOfProductDAO;

    private static final String NOT_IMAGE="\\img\\notImage.png";

    public List<CategoryOfProduct> getCategoryList(){
        return categoryOfProductDAO.findAllNotDeleted();
    }

    public String getImage(CategoryOfProduct category) {
        if(category.getGeneralInformation().getImageFileList().isEmpty()){
            return NOT_IMAGE;
        }
        return "/getImage?id=" + category.getId();
    }


    @Command
    @NotifyChange("categoryList")
    public void addCategory() {
        final Window win = (Window) Executions.createComponents("addCategory.zul", null, null);
        win.addEventListener("onCategorySave",
                event -> BindUtils.postNotifyChange(null, null, CategoryVM.this, "categoryList")
        );
    }



}
