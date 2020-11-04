package com.prueba.javatest.util.discounts;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PriceCalculatorShould {

    @Test
    public void total_is_the_sum_of_prices(){

        PriceCalculator calculator= new PriceCalculator();
        calculator.addPrice(10.2);
        calculator.addPrice(15.7);


        assertThat(calculator.getTotal(),is(25.9));
    }
    @Test
    public void apply_discount_to_prices(){

        PriceCalculator calculator= new PriceCalculator();
        calculator.addPrice(25.00);
        calculator.addPrice(75.00);

        calculator.setDiscount(50);

        assertThat(calculator.getTotal(),is(50.00));
    }

}