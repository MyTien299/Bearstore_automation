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
public class Bearstore_Register_TC06_VerifyRegisterFailedWithEmptyEmail extends BaseTest {

    private RegisterStep registerStep;

    @BeforeMethod
    public void setupTest() {
        registerStep = new RegisterStep(DriverManager.getPage());
    }

    @Test
    @Story("Register with empty email")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that user cannot register when Email field is empty")
    @TestCaseID("TC_REGISTER_006")
    public void registerWithEmptyEmail() {

        final String firstName = "tien";
        final String lastName = "dao";
        final String email = "";
        final String username = "tien_new_123";
        final String password = "tien123";
        final String confirmPassword = "tien123";
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
        registerStep.stepVerifyErrorMessage("email", "'Email' should not be empty.");
    }
}
