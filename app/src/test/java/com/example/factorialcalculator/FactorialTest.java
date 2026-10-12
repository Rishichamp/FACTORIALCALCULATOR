package com.example.factorialcalculator;

import static com.example.factorialcalculator.Factorial.calculate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class FactorialTest {

    @Test
    public void smallValues() {
        assertEquals("Factorial=1", calculate("0"));
        assertEquals("Factorial=1", calculate("1"));
        assertEquals("Factorial=120", calculate("5"));
    }

    @Test
    public void largeValuesAreExact() {
        // 13! is where the old int version started returning wrong numbers.
        assertEquals("Factorial=6227020800", calculate("13"));
        assertEquals("Factorial=2432902008176640000", calculate("20"));
        assertEquals(158, Factorial.of(100).toString().length());
    }

    @Test
    public void limitsAndBadInput() {
        assertEquals("Error! Factorial works for 0 to 100", calculate("101"));
        assertEquals("Error! Factorial works for 0 to 100", calculate("999999999"));
        assertEquals("Number field can't be empty", calculate(""));
        assertEquals("Error! Please enter a smaller number", calculate("99999999999999999999"));
    }
}
