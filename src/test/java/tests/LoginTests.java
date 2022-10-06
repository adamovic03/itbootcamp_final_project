package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {

    @Test
    public void loadLoginPage() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        startPage.openLoginPage();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void checkInputTypes() {
        String emailExpectedResult = "email";
        String passwordExpectedResult = "password";

        startPage.openLoginPage();
        String emailActualResult = loginPage.emailFieldType();
        String passwordActualResult = loginPage.passwordFieldType();

        Assert.assertEquals(emailActualResult, emailExpectedResult);
        Assert.assertEquals(passwordActualResult, passwordExpectedResult);
    }

    @Test
    public void displayErrorWhenUserDoesNotExist() {
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
    public void displayErrorWhenPasswordIsWrong() {
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
    public void login() {
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
    }

    @Test(dependsOnMethods = {"login"} )
    public void logout() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]")).isDisplayed());
        driver.findElement(By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[2]")).click();
        String actualResult = driver.getCurrentUrl();
        Assert.assertEquals(actualResult, expectedResult);
        driver.manage().deleteAllCookies();
        startPage.goToHomePage();
        Assert.assertTrue(driver.getCurrentUrl().equals(expectedResult));
    }

}
