package com.prueba.javatest.util.discounts;

import java.util.ArrayList;
import java.util.List;

public class PriceCalculator {
   private List<Double> prices=new ArrayList<>();
    private double discount;

    public double getTotal() {
      double result =0;
      for (Double price:prices){
          result+=price;
      }
        return result *(1 -(discount/100));
    }

    public void addPrice(double v) {
        prices.add(v);
    }

    public void setDiscount(double discount) {

        this.discount = discount;
    }
}
