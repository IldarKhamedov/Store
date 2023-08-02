package ru.khamedov.ildar.store.web.servlets;


import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.HttpRequestHandler;
import ru.khamedov.ildar.store.DataLoader;
import ru.khamedov.ildar.store.dao.CategoryOfProductDAO;
import ru.khamedov.ildar.store.model.product.CategoryOfProduct;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class ImageServlet implements HttpRequestHandler {

    private static final Logger LOG = LoggerFactory.getLogger(DataLoader.class);

    @Resource
    private CategoryOfProductDAO categoryOfProductDAO;


    @Override
    public void handleRequest(HttpServletRequest request, HttpServletResponse response) {

        Long id = Long.parseLong(request.getParameter("id"));
        CategoryOfProduct categoryOfProduct = categoryOfProductDAO.get(id);
        response.setContentType(categoryOfProduct.getGeneralInformation().getImageFileList().get(0).getContentType());
        byte[] contentBytes = categoryOfProduct.getGeneralInformation().getImageFileList().get(0).getImageContent().getContent();
        try (InputStream inputStream = new ByteArrayInputStream(contentBytes)) {
            OutputStream outputStream = response.getOutputStream();
            IOUtils.copy(inputStream, outputStream);

        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
    }
}