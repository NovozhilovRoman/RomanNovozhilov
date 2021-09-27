package com.epam.tc.hw4;

import com.epam.tc.hw4.pages.AttachmentUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult itestResult) {
        Object driver = itestResult.getTestContext().getAttribute("driver");
        if (driver != null) {
            AttachmentUtil.makeScreenshotAttachment("Failure screenshot",
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }
}
