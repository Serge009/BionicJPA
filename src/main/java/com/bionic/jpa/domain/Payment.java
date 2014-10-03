package com.bionic.jpa.domain;

import javax.persistence.*;

/**
 * Created by oper4 on 03.10.2014.
 */
@Entity
public class Payment {

    @Id
    @GeneratedValue
    private int id;
    private long dt;



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "merchantId")
    private Merchant merchant;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customerId")
    private Customer customer;

    private String goods;
    private double total;
    private double charge;

    public Payment() {
    }

    public Payment(int id, long dt, Merchant merchant, Customer customer, String goods, double total, double charge) {
        this.id = id;
        this.dt = dt;
        this.merchant = merchant;
        this.customer = customer;
        this.goods = goods;
        this.total = total;
        this.charge = charge;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getGoods() {
        return goods;
    }

    public void setGoods(String goods) {
        this.goods = goods;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getCharge() {
        return charge;
    }

    public void setCharge(double charge) {
        this.charge = charge;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", dt=" + dt +
                ", goods='" + goods + '\'' +
                ", total=" + total +
                ", charge=" + charge +
                '}' +
                ",\n\t merchant=" + merchant +
                ",\n\t customer=" + customer;
    }
}
