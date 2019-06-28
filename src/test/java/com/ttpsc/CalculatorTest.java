package com.ttpsc; //w nazwie klasy mialam ten pakiet czyli com.ttpsc.CalculatorTest

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)  // to dodaje, jak mam jakies parametry - bo w tych testach nie mozna sie odnosic do plikow
public class CalculatorTest {   //SHIFT +F6 - zmieni mi globalnie nazwe klasy - plik tez - i CalculatorTest tez zmieni. Ale jakbym nazwala CalculatorTest KalkulatorekTest - to juz nie zmieni
    int a;
    int b;
    int expectedResult;

    public CalculatorTest(int a, int b)
    {
        this.a=a;
        this.b=b;
        expectedResult = a +b;

    }

    @Parameterized.Parameters // bez dodania tego i RunWith na gorze nie moglabym uzywac parametrow, czyli a, b, tylko musialabym liczby wklepywac z palca
    public static Object [][] prepareValues()
    {
        return new Object[][]
                {
                        {1,2},
                        {3,4},
                        {8,10},
                        {-8,24}

                };
    }





    @Test //tu musialam alt+enter i zatwierdzic JUnit
    public void shouldReturnSumWhenAdding()
    {
    Calculator sut = new Calculator ();
    int sum = sut.add(a,b);
        Assert.assertEquals(expectedResult,sum);
    }


    @Test // trzeba ten test dodawac, zeby moc testy odpalic - jak tego nie dodam, to nie odpali mi sie to w ogole, nawet jak odpale calosc
    public void shouldReturnNegativeValueFirstParameterIsSmallerThenSecond()
    {
        Calculator sut = new Calculator();
        int actual = sut.substract(8,10);
        Assert.assertTrue(actual < 0);
    }

    @Test
    public void shouldReturnZeroWhenParametersAreSame()
    {
        Calculator sut = new Calculator();
        int actual = sut.substract (8,10);
        Assert.assertTrue(actual==0);
    }

    @Test
    public void shouldReturnZeroWhenMultiplyingByZero()
    {
       Calculator sut = new Calculator ();
       double result = sut.multiply(5,0);
       Assert.assertTrue(result ==0);
    }

    @Test
    public void shouldReturnProductWhenMultiplying()
    {
        Calculator sut = new Calculator();
        double result = sut.multiply (5,5);
        Assert.assertTrue(result==25); //jakbym uzyla assertEquals, to musze porownywac dwa te same typy

    }

    @Test
    public void shouldReturnPositiveWhenMultiplyingTwoNegativeValues()
    {
        Calculator sut = new Calculator();
        double result = sut.multiply (-2, -5);
        Assert.assertTrue(result<0);

    }

    @Test
    public void shouldReturnNegativeWhenMultiplyingOneNegative()
    {
        Calculator sut = new Calculator();
        double result = sut.multiply (-2,5);
        Assert.assertTrue(result<0);
    }

    @Test (expected = ArithmeticException.class )
    public void shouldThrowExceptionWhenDividingByZero()
    {
        Calculator sut = new Calculator();
        sut.divide(10,0);
    }



}
