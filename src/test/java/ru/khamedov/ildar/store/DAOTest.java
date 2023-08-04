package ru.khamedov.ildar.store;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import ru.khamedov.ildar.store.dao.ProductDAO;
import ru.khamedov.ildar.store.dao.PurchasDAO;

import javax.annotation.Resource;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
@Rollback
public class DAOTest {

    @Resource
    private PurchasDAO purchasDAO;

    @Ignore
    @Test 
    public void findProduct() {
        String seller="seller2";
        Instant periodInstant=Instant.now().minus(10, ChronoUnit.DAYS);
        purchasDAO.findProductOfOrderingBySellerAndPeriod(seller,periodInstant);

    }


}
