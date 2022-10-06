package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.SignupPage;
import pages.StartPage;
import pages.LoginPage;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected StartPage startPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;

    @BeforeClass
    public void preparation() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        startPage = new StartPage(driver, driverWait);
        loginPage = new LoginPage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
    }

    @BeforeMethod
    public void getBasePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void exitBrowser() {
        driver.quit();
    }

}
