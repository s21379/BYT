package com.company;

import java.util.Scanner;

public class Numbers {
    private double number1;
    private double number2;

    private String calculatingWanted;

    public Numbers(int newNumber1,String calcWanted, int newNumber2 ){
        number1= newNumber1;
        calculatingWanted = calcWanted;
        number2= newNumber2;

    }
public double getNumber1(){return number1;}
public double getNumber2(){return  number2;}
public String getCalcWanted(){return calculatingWanted;}

}
