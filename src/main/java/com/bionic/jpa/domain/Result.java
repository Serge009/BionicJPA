package com.bionic.jpa.domain;

/**
 * Created by oper4 on 03.10.2014.
 */
public class Result {

    private String name;
    private Double sum;

    public Result() {
    }

    public Result(String name, Double sum) {
        this.name = name;
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", sum=" + sum +
                '}';
    }
}
