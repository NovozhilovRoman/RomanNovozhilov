package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TestOfSubtraction extends TestMain {
    @Test(dataProvider = "subtraction", dataProviderClass = DataProviderTest.class, groups = {"SubAndAdd"})
    public void testSubtraction(long a, long b, long expectedResult) {
        long actualResult = calculator.sub(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}
