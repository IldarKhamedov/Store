package ru.khamedov.ildar.store.service;

import org.springframework.stereotype.Service;
import ru.khamedov.ildar.store.dao.ProductDAO;

import javax.annotation.Resource;

@Service
public class ProductService {

    @Resource
    private ProductDAO productDAO;

    public void createProduct(){
    }
}
