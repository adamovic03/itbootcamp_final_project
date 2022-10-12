package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.*;

import java.time.Duration;

public abstract class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected StartPage startPage;
    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected HomePage homePage;
    protected CitiesPage citiesPage;
    protected ProfilePage profilePage;

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
        homePage = new HomePage(driver, driverWait);
        citiesPage = new CitiesPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
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
