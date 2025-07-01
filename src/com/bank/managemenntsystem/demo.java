package com.bank.managemenntsystem;

import java.util.Random;

public class demo {
    public static void main(String[] args) {
        Random random = new Random();
        String pinNo = "" + Math.abs((random.nextInt(1000,9999)));
        System.out.println(pinNo);
    }
}
