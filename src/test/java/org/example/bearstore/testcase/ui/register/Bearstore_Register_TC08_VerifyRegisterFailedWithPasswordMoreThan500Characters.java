package org.example.bearstore.testcase.ui.register;

import io.qameta.allure.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.bearstore.annotation.TestCaseID;
import org.example.bearstore.common.BaseTest;
import org.example.bearstore.managers.DriverManager;
import org.example.bearstore.steps.RegisterStep;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Register")
public class Bearstore_Register_TC08_VerifyRegisterFailedWithPasswordMoreThan500Characters extends BaseTest{
    private static final Logger logger =
            LogManager.getLogger(Bearstore_Register_TC08_VerifyRegisterFailedWithPasswordMoreThan500Characters.class);

    private RegisterStep registerStep;

    @BeforeMethod
    public void setupTest() {
        registerStep = new RegisterStep(DriverManager.getPage());
    }

    @Test
    @Story("Register with password of more than 500 characters")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can not register with a password of more than 500 characters.")
    @TestCaseID("TC_REGISTER_008")
    public void registerWithEmptyEmail() {

        final String firstName = "dao";
        final String lastName = "tien";
        final String email = "";
        final String username = "tien1234567";
        final String password = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg";
        final String confirmPassword = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefg";
        final String company = "TMA";

        Allure.addAttachment("Test Data",
                "Firstname: " + firstName +
                        "\nLastname: " + lastName +
                        "\nEmail: " + email +
                        "\nUsername: " + username +
                        "\nPassword: " + password +
                        "\nConfirmPassword: " + confirmPassword +
                        "\nCompany: " + company);

        step_Navigate_To_Register_Page();
        step_Fill_Register_Form(firstName, lastName, email, username, password, confirmPassword, company);
        step_Submit_Register_Form();
        step_Verify_Email_Error_Message_Displayed();
    }

    @Step("Step 1 – Navigate to Register Page")
    private void step_Navigate_To_Register_Page() {
        logger.info("Step 1 – Navigate to Register Page");
        registerStep.navigateToRegister();
    }

    @Step("Step 2 – Fill register form with empty email")
    private void step_Fill_Register_Form(
            String firstName,
            String lastName,
            String email,
            String username,
            String password,
            String confirmPassword,
            String company) {

        logger.info("Step 2 – Fill register form (Email is empty)");
        registerStep.fillForm(
                firstName,
                lastName,
                email,
                username,
                password,
                confirmPassword,
                company
        );
    }

    @Step("Step 3 – Click Register button")
    private void step_Submit_Register_Form() {
        logger.info("Step 3 – Click Register button");
        registerStep.submitForm();
    }

    @Step("Step 4 – Verify error message displayed")
    private void step_Verify_Email_Error_Message_Displayed() {
        logger.info("Step 4 – Verify error message displayed");
        String actualError = registerStep.getPWErrorMessage();
        String expected = "'Password' must be between 6 and 500 characters.";

        logger.info("Expected error: {}", expected);
        logger.info("Actual error: {}", actualError);

        Assert.assertTrue(actualError.contains(expected), "Expected password error message not displayed. Actual: " + actualError);
        logger.info("Verification passed!");
    }
}
