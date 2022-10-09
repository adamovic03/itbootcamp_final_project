package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    private By emailField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("/html/body/div/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button");
    private By localizationButton = By.cssSelector(".btnLocaleActivation");
    private By header = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/h1");
    protected Faker faker = new Faker();

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public WebElement getEmailField() {
        return getDriver().findElement(emailField);
    }

    public WebElement getPasswordField() {
        return getDriver().findElement(passwordField);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }
    public WebElement getLocalizationButton() {
        return getDriver().findElement(localizationButton);
    }
    public WebElement getHeader() {
        return getDriver().findElement(header);
    }


    public String emailFieldType() {
        return getEmailField().getAttribute("type");
    }

    public String passwordFieldType() {
        return getPasswordField().getAttribute("type");
    }

    public void loginInvalidUser() {
        getEmailField().sendKeys(faker.internet().emailAddress());
        getPasswordField().sendKeys(faker.internet().password());
        getLoginButton().click();
    }

    public void loginInvalidPassword() {
        getEmailField().sendKeys("admin@admin.com");
        getPasswordField().sendKeys(faker.internet().password());
        getLoginButton().click();
    }

    public void login() {
        getEmailField().sendKeys("admin@admin.com");
        getPasswordField().sendKeys("12345");
        getLoginButton().click();
    }

    public void setLocaleToES() {
        getLocalizationButton().click();
        driver.findElement(By.id("list-item-75")).click();
    }

    public void setLocaleToEN() {
        getLocalizationButton().click();
        driver.findElement(By.id("list-item-73")).click();
    }

    public void setLocaleToFR() {
        getLocalizationButton().click();
        driver.findElement(By.id("list-item-77")).click();
    }



}
