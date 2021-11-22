package com.company;

public class Main {
// numbers in double because when I try to divide for example int 18/5, i get 3 without 0.6
    public static void main(String[] args) {
        Chain chainCalc1= new Plus();
        Chain chainCalc2= new Minus();
        Chain chainCalc3= new Multiply();
        Chain chainCalc4= new Divide();

        chainCalc1.setNextChain(chainCalc2);
        chainCalc2.setNextChain(chainCalc3);
        chainCalc3.setNextChain(chainCalc4);

        Numbers request = new Numbers(18, "/", 5);
        chainCalc1.calculate(request);


        }
    }


