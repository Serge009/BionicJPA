import com.bionic.jpa.domain.Customer;
import com.bionic.jpa.domain.Merchant;
import com.bionic.jpa.domain.Payment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

/**
 * Created by Matrix on 03.10.2014.
 */
public class Main {

    final static Logger logger = LoggerFactory.getLogger(Main.class);

    private static final String UNIT_NAME = "CashM";
    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(UNIT_NAME);
    private static EntityManager em = factory.createEntityManager();

    public static void main(String[] args) {
        /*testFind();
        createCustomer();
        updateCustomer();*/
//        findAllMerchants();
//        findAllPaymentsByMerchant();
//        findCustomersByTotal();
        totalPaymentsSum();
    }

    private static void createCustomer() {


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

    private static void testFind() {

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

    private static void updateCustomer() {

        Customer customer = em.find(Customer.class, 9);

        try {
            em.getTransaction().begin();
            customer.setAddress("New Address");
            em.getTransaction().commit();
        } finally {
            em.close();
        }

        logger.info("Customer updated: {}", customer);
    }

    private static void findAllMerchants(){

        TypedQuery<Merchant> query = em.createQuery("SELECT m FROM Merchant m WHERE m.total > 0", Merchant.class);
        List<Merchant> merchants = null;

        try {
            merchants = query.getResultList();
        } finally {
            em.close();
        }


            for (Merchant merchant : merchants) {
                logger.info("{}", merchant);
            }

    }

    private static void findAllPaymentsByMerchant(){

        Merchant merchant = em.find(Merchant.class, 2);
        TypedQuery<Payment> query = em.createQuery("SELECT p FROM Payment p", Payment.class);
        List<Payment> payments = null;

        try {
            payments = query.getResultList();
        } finally {
            em.close();
        }


        for (Payment payment : payments) {
            logger.info("{}", payment);
        }

    }

    private static void findCustomersByTotal(){
        TypedQuery<Customer> query = em.createQuery("SELECT DISTINCT c FROM Customer c INNER JOIN Payment p ON p.customer = c WHERE p.total > 500", Customer.class);
        List<Customer> customers = null;

        try {
            customers = query.getResultList();
        } finally {
            em.close();
        }


        for (Customer customer : customers) {
            logger.info("{}", customer);
        }

    }

    private static void totalPaymentsSum(){
        TypedQuery<Double> query = em.createQuery("SELECT SUM(p.total) FROM Payment p", Double.class);
        Double sum = query.getSingleResult();
        logger.info("Total sum = {}", sum);
        em.close();
    }
}
