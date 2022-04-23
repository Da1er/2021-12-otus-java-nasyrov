package com.nasyrov;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableSet;

/**
 * HW01-gradle main class
 */
public class HelloOtus {

    public static void main(String... args) {
        guavaTest();
    }

    /**
     * Google guava test method
     */
    private static void guavaTest() {
        var carVendorNames = ImmutableSet.of("Volvo", "Skoda", "Toyota", "Renault");
        System.out.printf(
            "Vendor names: %s",
            Joiner.on(",").join(carVendorNames)
        );
    }

}
