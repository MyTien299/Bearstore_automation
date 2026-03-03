package org.example.bearstore.testcase.ui.register;

import io.qameta.allure.*;
import org.example.bearstore.annotation.TestCaseID;
import org.example.bearstore.common.BaseTest;
import org.example.bearstore.managers.DriverManager;
import org.example.bearstore.steps.RegisterStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Register")
public class Bearstore_Register_TC08_VerifyRegisterFailedWithPasswordMoreThan500Characters extends BaseTest{
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

        registerStep.stepNavigateToRegisterPage();
        registerStep.stepFillRegisterForm(firstName, lastName, email, username, password, confirmPassword, company);
        registerStep.stepSubmitRegisterForm();
        registerStep.stepVerifyErrorMessage("password", "'Password' must be between 6 and 500 characters.");
    }
}
