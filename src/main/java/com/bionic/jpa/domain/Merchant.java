package com.bionic.jpa.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Matrix on 03.10.2014.
 */
@Entity
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double charge;
    private int period;
    private double total;

    @OneToMany(mappedBy = "merchant", fetch = FetchType.EAGER)
    private List<Payment> payments;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="payment",
            joinColumns=@JoinColumn(name="merchantId"),
            inverseJoinColumns=@JoinColumn(name="customerId"))

    private List<Customer> customers;

    public Merchant() {
    }

     public List<Payment> getPayments() {
        return payments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getStringForPrint() {
        String txt = "id = " + id + ";   name = '" + name + "';   charge = ";
        txt += "" + charge + ";   period = " + period + ";   total = " + total;
        return txt;
    }

    @Override
    public String toString() {
        return getStringForPrint();
    }
}