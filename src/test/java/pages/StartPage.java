package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends BasePage {

    private By homeButton = By.xpath("/html/body/div/div/div/header/div/div[3]/a[1]");
    private By aboutButton = By.xpath("/html/body/div/div/div/header/div/div[3]/a[2]");
    private By loginButton = By.xpath("/html/body/div/div/div/header/div/div[3]/a[3]");
    private By signUpButton = By.xpath("/html/body/div/div/div/header/div/div[3]/a[4]");
    private By light_DarkModeButton = By.id("input-26");

    public StartPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public WebElement getHomeButton() {
        return getDriver().findElement(homeButton);
    }

    public WebElement getAboutButton() {
        return getDriver().findElement(aboutButton);
    }

    public WebElement getLoginButton() {
        return getDriver().findElement(loginButton);
    }

    public WebElement getSignUpButton() {
        return getDriver().findElement(signUpButton);
    }

    public WebElement getLight_DarkModeButton() {
        return getDriver().findElement(light_DarkModeButton);
    }

    public void goToHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
    }

    public void openLoginPage() {
        getLoginButton().click();
    }

    public void openSignUpPage() {
        getSignUpButton().click();
    }

}
