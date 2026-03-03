package org.example.bearstore.steps;

import com.microsoft.playwright.Page;
import io.qameta.allure.Step;
import org.example.bearstore.page.RegisterPage;
import org.example.bearstore.testcase.ui.register.Bearstore_Register_TC03_VerifyRegisterFailedWithExistingUsername;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegisterStep {
    private static final Logger logger = LogManager.getLogger(RegisterStep.class);
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

    // STEP 1
    @Step("Step 1 – Navigate to Register Page")
    public void stepNavigateToRegisterPage() {
        logger.info("Step 1 – Navigate to Register Page");
        registerPage.goToRegisterPage();
    }

    // STEP 2
    @Step("Step 2 – Fill register form with username: {username}")
    public void stepFillRegisterForm(String firstName, String lastName, String email, String username, String password, String confirmPassword, String company) {
        logger.info("Step 2 – Fill register form with username: {}", username);
        registerPage.enterFirstName(firstName);
        registerPage.enterLastName(lastName);
        registerPage.selectDateOfBirth("29", "9", "2004");
        registerPage.enterEmail(email);
        registerPage.enterUsername(username);
        registerPage.enterPassword(password);
        registerPage.enterConfirmPassword(confirmPassword);
        registerPage.enterCompany(company);
    }

    // STEP 3
    @Step("Step 3 – Click Register button")
    public void stepSubmitRegisterForm() {
        logger.info("Step 3 – Click Register button");
        registerPage.clickRegister();
    }

    // STEP 4
    @Step("Step 4 – Verify error message displayed")
    public void stepVerifyErrorMessage(String errorType, String expectedMessage) {
        logger.info("Step 4 – Verify error message displayed");
        String actualError;

        switch (errorType.toLowerCase()) {

            case "summary":
                actualError = registerPage.getErrorMessage();
                break;

            case "email":
                actualError = registerPage.getEmailErrorMessage();
                break;

            case "password":
                actualError = registerPage.getPWErrorMessage();
                break;

            case "confirmpassword":
                actualError = registerPage.getCFPWErrorMessage();
                break;

            default:
                throw new RuntimeException("Invalid error type: " + errorType);
        }

        Assert.assertTrue(
                actualError.contains(expectedMessage),
                "Expected error message not displayed. Actual: " + actualError
        );
    }

//    @Step("Get error message")
//    public String getErrorMessage() {
//        return registerPage.getErrorMessage();
//    }
//
//    @Step("Get email error message")
//    public String getEmailErrorMessage() {
//        return registerPage.getEmailErrorMessage();
//    }
//
//    @Step("Get password error message")
//    public String getPWErrorMessage() {
//        return registerPage.getPWErrorMessage();
//    }
//
//    @Step("Get password error message")
//    public String getCFPWErrorMessage() {
//        return registerPage.getCFPWErrorMessage();
//    }


}
