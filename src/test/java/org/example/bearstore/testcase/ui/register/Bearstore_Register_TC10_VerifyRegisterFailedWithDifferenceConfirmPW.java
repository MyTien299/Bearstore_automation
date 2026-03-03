package org.example.bearstore.testcase.ui.register;

import org.example.bearstore.common.BaseTest;
import io.qameta.allure.*;
import org.example.bearstore.annotation.TestCaseID;
import org.example.bearstore.managers.DriverManager;
import org.example.bearstore.steps.RegisterStep;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Authentication")
@Feature("Register")
public class Bearstore_Register_TC10_VerifyRegisterFailedWithDifferenceConfirmPW extends BaseTest {

    private RegisterStep registerStep;

    @BeforeMethod
    public void setupTest() {
        registerStep = new RegisterStep(DriverManager.getPage());
    }

    @Test
    @Story("Register with the confirm password that is not the same as the password")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Verify that the user can not register with the confirm password that is not the same as the password")
    @TestCaseID("TC_REGISTER_010")
    public void registerWithEmptyEmail() {

        final String firstName = "dao";
        final String lastName = "tien";
        final String email = "tiennnnn@gmail.com";
        final String username = "tien1234567";
        final String password = "123456";
        final String confirmPassword = "1234567";
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
        registerStep.stepVerifyErrorMessage("confirmpassword", "The password and confirmation password do not match.");
    }
}
