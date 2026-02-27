package org.example.bearstore.managers;

import com.microsoft.playwright.*;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {

    private static Playwright playwright;
    private static Browser browser;
    private static BrowserContext context;
    private static Page page;

    public static void initBrowser() {
        try {
            // Ensure Playwright won't try to auto-download browsers from within the IDE test JVM.
            // We'll require a manual install of Chromium (one-time) using the provided mvn command.
            Map<String, String> env = new HashMap<>(System.getenv());
            env.put("PLAYWRIGHT_SKIP_BROWSER_DOWNLOAD", "1");

            // Create Playwright with the modified environment
            Playwright.CreateOptions options = new Playwright.CreateOptions().setEnv(env);
            DriverManager.playwright = Playwright.create(options);

            // Launch Chromium (must be installed beforehand)
            DriverManager.browser = DriverManager.playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false)
            );
            DriverManager.context = DriverManager.browser.newContext();
            DriverManager.page = DriverManager.context.newPage();
        } catch (Exception e) {
            System.err.println("Failed to initialize browser: " + e.getMessage());
            System.err.println("Make sure Chromium is installed by running:");
            System.err.println("mvn exec:java -Dexec.mainClass=\"com.microsoft.playwright.CLI\" -Dexec.args=\"install chromium\"");
            throw new RuntimeException("Browser initialization failed", e);
        }
    }

    public static Page getPage() {
        return page;
    }

    public static void quit() {
        try {
            if (context != null) context.close();
            if (browser != null) browser.close();
            if (playwright != null) playwright.close();
        } catch (Exception e) {
            System.err.println("Error during browser cleanup: " + e.getMessage());
        }
    }
}
