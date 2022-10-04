package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loadLoginPage() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homePage.openLoginPage();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkInputTypes() {
        String emailExpectedResult = "email";
        String passwordExpectedResult = "password";

        homePage.openLoginPage();
        String emailActualResult = driver.findElement(By.id("email")).getAttribute("type");
        String passwordActualResult = driver.findElement(By.id("password")).getAttribute("type");

        Assert.assertEquals(emailActualResult, emailExpectedResult);
        Assert.assertEquals(passwordActualResult, passwordExpectedResult);
    }



}
