package com.bionic.jpa.domain;

import javax.persistence.*;

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

    public Merchant() {
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
}