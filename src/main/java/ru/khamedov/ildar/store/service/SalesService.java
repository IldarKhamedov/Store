package ru.khamedov.ildar.store.service;

import ru.khamedov.ildar.store.dto.SalesDTO;
import ru.khamedov.ildar.store.model.product.Product;
import ru.khamedov.ildar.store.model.product.Purchase;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class SalesService {

    public List<SalesDTO> convertPurchaseToSalesDTO(List<Purchase> purchaseList){
        return purchaseList.stream()
                .map(purchase -> {
                    SalesDTO salesDTO=new SalesDTO();
                    Product product=purchase.getProduct();
                    salesDTO.setProduct(product.getGeneralInformation().getName());
                    salesDTO.setMoney(BigDecimal.valueOf(product.getCost()*purchase.getCount()));
                    return salesDTO;
                })
                .collect(Collectors.toList());
    }

    public double total(List<Purchase> purchaseList){
       return purchaseList.stream().mapToDouble(p->p.getCount()*p.getProduct().getCost()).sum();
    }
}
