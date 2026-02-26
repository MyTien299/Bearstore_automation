package org.example.bearstore.steps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.example.bearstore.page.RegisterPage;

public class RegisterStep {

    private final RegisterPage registerPage;

    public RegisterStep(Page page) {
        this.registerPage = new RegisterPage(page);
    }

    @Step("Navigate to Register page from Home")
    public void navigateToRegister() {
        registerPage.goToRegisterPage();
    }

    @Step("Fill registration form")
    public void fillForm(String first, String last, String email,
                         String username, String pass,
                         String confirm, String company) {

        registerPage.enterFirstName(first);
        registerPage.enterLastName(last);
        registerPage.selectDateOfBirth("29", "9", "2004");
        registerPage.enterEmail(email);
        registerPage.enterUsername(username);
        registerPage.enterPassword(pass);
        registerPage.enterConfirmPassword(confirm);
        registerPage.enterCompany(company);
    }

    @Step("Click Register button")
    public void submitForm() {
        registerPage.clickRegister();
    }

    @Step("Get error message")
    public String getErrorMessage() {
        return registerPage.getErrorMessage();
    }

    @Step("Get email error message")
    public String getEmailErrorMessage() {
        return registerPage.getEmailErrorMessage();
    }

    @Step("Get password error message")
    public String getPWErrorMessage() {
        return registerPage.getPWErrorMessage();
    }

    @Step("Get password error message")
    public String getCFPWErrorMessage() {
        return registerPage.getCFPWErrorMessage();
    }


}
