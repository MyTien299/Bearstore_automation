package org.example.bearstore.managers;

import com.microsoft.playwright.*;
import org.example.bearstore.constants.AppConfig;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    // Create Playwright and Browser (use for @BeforeClass)
    public static void initPlaywrightAndBrowser() {
        if (playwright == null) {
            Map<String, String> env = new HashMap<>(System.getenv());
            env.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");
            Playwright.CreateOptions options = new Playwright.CreateOptions().setEnv(env);
            playwright = Playwright.create(options);

            browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(AppConfig.HEADLESS)
            );
        }
    }

    // Create Context and Page (use for @BeforeMethod)
    public static void initContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.setDefaultTimeout(40000);
        page.setDefaultNavigationTimeout(40000);
    }

    public static Page getPage() {
        return page;
    }

    // Close Context and Page (use for @AfterMethod)
    public static void closeContext() {
        if (context != null) {
            context.close();
        }
    }

    // Close Browser and Playwright (use for @AfterClass)
    public static void quit() {
        if (browser != null) browser.close();
        if (playwright != null) playwright.close();
        playwright = null;
    }
}
