import com.bionic.jpa.domain.Customer;
import com.bionic.jpa.domain.Merchant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.sql.Date;

/**
 * Created by Matrix on 03.10.2014.
 */
public class Main {

    final static Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String UNIT_NAME = "CashM";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        testFind();
        createCustomer();

    }

    private static void createCustomer(){
        factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Customer customer = new Customer();
        customer.setAddress("Address");
        customer.setEmail("Email");
        customer.setCcno("ccNo");
        customer.setName("Name");
        customer.setCctype("ccType");
        customer.setMaturity(new Date(55555));

        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        logger.info("New Customer = {}", customer);
    }

    private static void testFind(){
        factory = Persistence.createEntityManagerFactory(UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        Merchant merch = null;
        Customer customer = null;
        try {

            merch = em.find(Merchant.class, 1);
            customer = em.find(Customer.class, 1);
        } finally {
            em.close();
        }

        if (merch != null) {
            System.out.println(merch.getStringForPrint());
        }

        if (customer != null) {
            System.out.println(customer);
        }
    }
}
