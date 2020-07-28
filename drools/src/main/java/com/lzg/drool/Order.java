package com.lzg.drool;

import java.math.BigDecimal;

public class Order {

    private int originPrice;

    private int actualPrice;

    public Order() {
    }

    public int getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(int originPrice) {
        this.originPrice = originPrice;
    }

    public int getActualPrice() {
        return actualPrice;
    }

    public void setActualPrice(int actualPrice) {
        this.actualPrice = actualPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "originPrice=" + originPrice +
                ", actualPrice=" + actualPrice +
                '}';
    }
}
