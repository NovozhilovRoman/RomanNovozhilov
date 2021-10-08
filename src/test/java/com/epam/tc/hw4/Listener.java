package com.epam.tc.hw4;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        Object webDriver = result.getTestContext().getAttribute("webDriver");
        if (webDriver != null) {
            AttachmentUtil.makeScreenshotAttachment("Failure!",
                    ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));
        }
    }
}




