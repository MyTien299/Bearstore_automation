package org.example.bearstore.allure;

import io.qameta.allure.Allure;

public class AllureUtils {

    public static void step(String message) {
        Allure.step(message);
    }

    public static void attachText(String name, String content) {
        Allure.addAttachment(name, content);
    }
}
