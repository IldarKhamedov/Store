package ru.khamedov.ildar.store.service;

import org.springframework.stereotype.Service;
import ru.khamedov.ildar.store.api.DefaultApi;
import ru.khamedov.ildar.store.dao.ProductDAO;
import ru.khamedov.ildar.store.dao.PurchasDAO;
import ru.khamedov.ildar.store.dao.SellerDAO;
import ru.khamedov.ildar.store.dao.StaffDAO;
import ru.khamedov.ildar.store.dto.InlineResponse200;
import ru.khamedov.ildar.store.dto.SellerDTO;
import ru.khamedov.ildar.store.model.product.Purchase;
import ru.khamedov.ildar.store.model.users.Seller;
import ru.khamedov.ildar.store.model.users.Staff;

import javax.annotation.Resource;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.core.Response;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class RestService  implements DefaultApi {

    @Resource
    private StaffDAO staffDAO;

    @Resource
    private PurchasDAO purchasDAO;

    @Resource
    private SellerDAO sellerDAO;

    @Resource
    private SalesService salesService;

    @Override
    public InlineResponse200 getSalary(String login) {
        Staff staff=staffDAO.get(login);
        if(staff==null){
            throw new ClientErrorException("Сотрудник не найден", Response.Status.NOT_FOUND);
        }
        InlineResponse200 inlineResponse200=new InlineResponse200();
        inlineResponse200.setSalary(BigDecimal.valueOf(staff.getSalary()));
        return inlineResponse200;
    }

    @Override
    public SellerDTO getSalesByPeriod(String login, Integer period) {
        Instant periodInstant=Instant.now().minus(period, ChronoUnit.DAYS);
        List<Purchase> purchaseList=purchasDAO.findProductOfOrderingBySellerAndPeriod(login,periodInstant);
        SellerDTO sellerDTO=new SellerDTO();
        Seller seller=sellerDAO.get(login);
        if(purchaseList.isEmpty() && seller==null){
            throw new ClientErrorException("Сотрудник не найден", Response.Status.NOT_FOUND);
        }
        sellerDTO.setFirstName(seller.getFirstName());
        sellerDTO.setLastName(seller.getLastName());
        sellerDTO.setDateOfHiring(Date.from(seller.getCreated()));
        sellerDTO.setSalary(BigDecimal.valueOf(seller.getSalary()));
        sellerDTO.setPercentage(BigDecimal.valueOf(seller.getPercentageOfSales()));
        sellerDTO.setSales(salesService.convertPurchaseToSalesDTO(purchaseList));
        sellerDTO.setTotal(BigDecimal.valueOf(salesService.total(purchaseList)));
        return sellerDTO;



    }
}
