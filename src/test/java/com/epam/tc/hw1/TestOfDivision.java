package com.epam.tc.hw1;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TestOfDivision extends TestMain {
    @Test(dataProvider = "division", dataProviderClass = DataProviderTest.class, groups = {"MultAndDiv"})
         public void testDivision(long a, long b, long expectedResult) {
        long actualResult = calculator.div(a, b);
        assertThat(actualResult).isEqualTo(expectedResult);
    }
}



