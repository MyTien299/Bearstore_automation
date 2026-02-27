package org.example.bearstore.page;

import com.microsoft.playwright.Page;

public class RegisterPage {

    private final Page page;

    public RegisterPage(Page page) {
        this.page = page;
    }

    // ===== LOCATORS =====
    private final String loginLink = "//i[contains(@class, 'menubar-icon')]";
    private final String registerLink = "//a[contains(@class, 'register-button')]";

    private final String firstName = "#FirstName";
    private final String lastName = "#LastName";
    private final String email = "#Email";
    private final String dayDropdown = "#DateOfBirthDay";
    private final String monthDropdown = "#DateOfBirthMonth";
    private final String yearDropdown = "#DateOfBirthYear";


    private final String username = "#Username";
    private final String password = "#Password";
    private final String confirmPassword = "#ConfirmPassword";
    private final String company = "#Company";

    private final String registerBtn = "#register-button";
    private final String errorMsg = "div.validation-summary-errors li";
    private final String errorMsgEmail = "#Email-error";
    private final String errorPWMsgEmail = "//span[@data-valmsg-for='Password']";
    private final String errorCFPWMsgEmail = "#ConfirmPassword-error";


    // ===== ACTIONS =====

    public void goToRegisterPage() {
        page.click(loginLink);
        page.click(registerLink);
    }

    public void enterFirstName(String value) {
        page.fill(firstName, value);
    }

    public void enterLastName(String value) {
        page.fill(lastName, value);
    }

    public void enterEmail(String value) {
        page.fill(email, value);
    }

    public void selectDateOfBirth(String day, String month, String year) {
        page.selectOption(dayDropdown, day);
        page.selectOption(monthDropdown, month);
        page.selectOption(yearDropdown, year);
    }

    public void enterUsername(String value) {
        page.fill(username, value);
    }

    public void enterPassword(String value) {
        page.fill(password, value);
    }

    public void enterConfirmPassword(String value) {
        page.fill(confirmPassword, value);
    }

    public void enterCompany(String value) {
        page.fill(company, value);
    }

    public void clickRegister() {
        page.click(registerBtn);
    }

    public String getErrorMessage() {
        page.waitForSelector(errorMsg, new Page.WaitForSelectorOptions().setTimeout(10000));
        return page.locator(errorMsg).innerText().trim();
    }

    public String getEmailErrorMessage() {
        page.waitForSelector(errorMsgEmail, new Page.WaitForSelectorOptions().setTimeout(10000));
        return page.locator(errorMsgEmail).innerText().trim();
    }

    public String getPWErrorMessage() {
        page.waitForSelector(errorPWMsgEmail, new Page.WaitForSelectorOptions().setTimeout(10000));
        return page.locator(errorPWMsgEmail).innerText().trim();
    }

    public String getCFPWErrorMessage() {
        page.waitForSelector(errorCFPWMsgEmail, new Page.WaitForSelectorOptions().setTimeout(10000));
        return page.locator(errorCFPWMsgEmail).innerText().trim();
    }


}
