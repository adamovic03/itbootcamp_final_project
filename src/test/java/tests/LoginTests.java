package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class LoginTests {

    private WebDriver driver;
    private WebDriverWait driverWait;
    private HomePage homePage;

    @BeforeClass
    public void preparation() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com");
        homePage = new HomePage(driver, driverWait);
    }

    @Test
    public void loadLoginPage() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/login";

        homePage.openLoginPage();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }

}
