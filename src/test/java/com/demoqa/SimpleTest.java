package com.demoqa;

import org.junit.jupiter.api.*;

public class SimpleTest {
    @BeforeAll
    static void initDB() {
        System.out.println("###     BeforeAll");
    }

    @BeforeEach
    void openYaPage() {
        System.out.println("###     BeforeEach");
       // Selenide.open("https://yandex.ru");
    }
    @AfterEach
    void close() {
        System.out.println("###     AfterEach");
//        WebDriverRunner.closeWindow();
    }

    @AfterAll
    static void cleanDB() {
        System.out.println("###     AfterAll");
    }

    @Test
    void assertTest() {
        System.out.println("###     @Test0");

    }
    @Test
    void assertTest1() {
        System.out.println("###     @Test1");

    }
}
