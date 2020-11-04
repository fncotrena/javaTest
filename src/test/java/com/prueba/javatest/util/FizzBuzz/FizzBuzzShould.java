package com.prueba.javatest.util.FizzBuzz;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FizzBuzzShould {

    @Test
    public void when_number_is_divisible_by_3(){

        FizzBuzz fizzBuzz= new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(3),is("Fizz"));
    }
    @Test
    public void when_number_is_divisible_by_5(){

        FizzBuzz fizzBuzz= new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(5),is("Buzz"));
    }
    @Test
    public void when_number_is_divisible_by_3_and_5(){

        FizzBuzz fizzBuzz= new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(15),is("FizzBuzz"));
    }
    @Test
    public void when_number_is_not_divisible_by_3_or_5(){

        FizzBuzz fizzBuzz= new FizzBuzz();
        assertThat(fizzBuzz.fizzBuzz(2),is("2"));
    }
}