package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void verifyThatLoginPageIsLoaded() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        startPage.openLoginPage();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void verifyThatInputFieldsAreValid() {
        String emailExpectedResult = "email";
        String passwordExpectedResult = "password";

        startPage.openLoginPage();
        String emailActualResult = loginPage.emailFieldType();
        String passwordActualResult = loginPage.passwordFieldType();

        Assert.assertEquals(emailActualResult, emailExpectedResult);
        Assert.assertEquals(passwordActualResult, passwordExpectedResult);
    }

    @Test
    public void verifyThatUserCanNotLoginIfIsNotRegistered() {
        String expectedResult = "User does not exists";
        String urlExpectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        startPage.openLoginPage();
        loginPage.loginInvalidUser();
        String actualResult = driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();
        String urlActualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(urlActualResult, urlExpectedResult);
    }

    @Test
    public void verifyThatErrorMessageAppearsIfPasswordIsInvalid() {
        String expectedResult = "Wrong password";
        String urlExpectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        startPage.openLoginPage();
        loginPage.loginInvalidPassword();
        String actualResult = driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")).getText();
        String urlActualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertEquals(urlActualResult, urlExpectedResult);
    }

    @Test
    public void verifyThatUserCanLoginUsingValidCredentials() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";

        startPage.openLoginPage();
        loginPage.login();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
        homePage.logout();
    }

    @Test
    public void verifyThatUserCanLogout() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        startPage.openLoginPage();
        loginPage.login();
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.logout();
        //driver.findElement(By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]")).click();
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
        driver.manage().deleteAllCookies();
        startPage.goToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().equals(expectedResult));
    }

}
