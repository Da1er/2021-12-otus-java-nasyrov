package com.nasyrov.testframework.test;

import com.nasyrov.testframework.annotation.After;
import com.nasyrov.testframework.annotation.Before;
import com.nasyrov.testframework.annotation.Test;

public class TestClassImpl {

    @Before
    public static void staticBefore() {
        System.out.println("Static before method");
    }

    @Before
    public void before() {
        System.out.println("Before method");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
    }

    @Test
    public void failureTest() {
        System.out.println("Fail test method");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
        throw new IllegalStateException("Test failure!");
    }

    @Test
    public void successTest() {
        System.out.println("Successful test method");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
    }

    @After
    public static void staticAfter() {
        System.out.println("Static after method");
    }

    @After
    public void after() {
        System.out.println("After method");
        System.out.println("Экземпляр тестового класса: " + Integer.toHexString(hashCode()));
    }

}
