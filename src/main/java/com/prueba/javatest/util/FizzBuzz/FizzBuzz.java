package com.prueba.javatest.util.FizzBuzz;

public class FizzBuzz {
    public static String fizzBuzz(int i) {


        if((i%3)==0 && (i %5)==0) return "FizzBuzz";
        if((i%3)==0) return "Fizz";
        if((i%5)==0) return "Buzz";
        else
            return String.valueOf(i);

    }
}
