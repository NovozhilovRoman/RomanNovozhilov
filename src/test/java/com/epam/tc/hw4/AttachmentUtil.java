package com.epam.tc.hw4;

import io.qameta.allure.Attachment;

public class AttachmentUtil {
    @Attachment(type = "image/png")
    public static byte[] makeScreenshotAttachment(final String name, final byte[] source) {
        return source;
    }
}
