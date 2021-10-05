package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TestOfAddition extends TestMain {
    @Test(dataProvider = "addition", dataProviderClass = DataProviderTest.class, groups = {"SubAndAdd"})
    public void testAddition(long a, long b, long expectedResult) {
        long actualResult = calculator.sum(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
