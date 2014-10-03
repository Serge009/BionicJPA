import com.bionic.jpa.domain.Customer;
import com.bionic.jpa.domain.Merchant;

import javax.persistence.*;

/**
 * Created by Matrix on 03.10.2014.
 */
public class Main {
    private static final String UNIT_NAME = "CashM";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
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
