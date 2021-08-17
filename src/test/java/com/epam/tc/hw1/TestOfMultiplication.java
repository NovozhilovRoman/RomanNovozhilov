package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TestOfMultiplication extends TestMain {
    @Test(dataProvider = "multiplication", dataProviderClass = DataProviderTest.class, groups = {"MultAndDiv"})
        public void testMultiplication(long a, long b, long expectedResult) {
        long actualResult = calculator.mult(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}

