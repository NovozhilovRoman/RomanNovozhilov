package com.epam.tc.hw1;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
    @DataProvider(name = "multiplication")
    public static Object[][] dataForMultTest() {
        return new Object[][] {
                {1, 2, 2},
                {2, 10, 20},
                {12, 24, 288},
        };
    }

    @DataProvider(name = "division")
    public static Object[][] dataForDivTest() {
        return new Object[][] {
                {1, 1, 1},
                {8, 2, 4},
                {16, 4, 4},
        };
    }

    @DataProvider(name = "subtraction")
    public static Object[][] dataForSubTest() {
        return new Object[][] {
                {10, 1, 9},
                {254, 255, -1},
                {-1100, -20, -1080},
        };
    }

    @DataProvider(name = "addition")
    public static Object[][] dataForAddTest() {
        return new Object[][] {
                {1, 1, 2},
                {250, 10, 260},
                {1001, -3, 998},
        };
    }
}
