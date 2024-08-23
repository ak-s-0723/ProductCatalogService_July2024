package org.example.productcatalogservice_july2024;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void Test_AddWithTwoIntegers_RunsSucessfully() {
        //Arrange
        Calculator calculator =  new Calculator();

        //Act
        int result = calculator.add(100,150);

        //Assert
        assert(250==result);
    }

    @Test
    void Test_DivideByZero_ThrowsArithmeticException() {
        //Arrange
        Calculator calculator =  new Calculator();

        //Act and Assert
        assertThrows(ArithmeticException.class,()->calculator.divide(1,0));
    }
}