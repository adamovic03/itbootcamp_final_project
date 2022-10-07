package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test
    public void verifyThatSignupPageIsLoaded() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        startPage.openSignUpPage();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyThatInputFieldsAreValid() {
        String emailExpectedResult = "email";
        String passwordExpectedResult = "password";
        String confirmPasswordExpectedResult = "password";

        startPage.openSignUpPage();
        String nameActualResult = signupPage.emailFieldType();
        String passwordActualResult = signupPage.passwordFieldType();
        String confirmPasswordActualResult = signupPage.confirmPasswordFieldType();

        Assert.assertEquals(nameActualResult, emailExpectedResult);
        Assert.assertEquals(passwordActualResult, passwordExpectedResult);
        Assert.assertEquals(confirmPasswordActualResult, confirmPasswordExpectedResult);
    }

    @Test
    public void displayErrorsWhenUserAlreadyExists() {
        String expectedResult = "E-mail already exists";
        String urlExpectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        startPage.openSignUpPage();
        signupPage.signupWithExistingUser();
        String actualResult = driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li")).getText();
        String urlActualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(urlActualResult, urlExpectedResult);
    }

    @Test
    public void verifyThatUserCanSignUpUsingValidCredentials() {
        String expectedResult = "IMPORTANT: Verify your account";

        startPage.openSignUpPage();
        signupPage.signup();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualResult = driver.findElement(By.xpath("/html/body/div/div[4]/div/div/div[1]")).getText();

        Assert.assertEquals(actualResult, expectedResult);
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[3]/button/span")).click();
        signupPage.logout();
    }

}
