package com.juaracoding;

public class Utils {

    public static void delay (long detik) {
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void customAssertEquals(String actual, String expected) {
        if (actual.equals(expected)){
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }


}
