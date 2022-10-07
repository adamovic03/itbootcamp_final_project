package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By homeButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/a[1]");
    private By aboutButton = By.cssSelector("a.v-btn:nth-child(2)");
    private By myProfileButton = By.cssSelector("a.v-btn:nth-child(3)");
    private By darkModeButton = By.id("input-26");
    private By adminButton = By.cssSelector(".btnAdmin");
    private By logoutButton = By.cssSelector("button.hidden-sm-and-down:nth-child(7)");
    private By localizationButton = By.cssSelector(".btnLocaleActivation");

    public HomePage() {
    }

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
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

    public WebElement getMyProfileButton() {
        return getDriver().findElement(myProfileButton);
    }

    public WebElement getDarkModeButton() {
        return getDriver().findElement(darkModeButton);
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public WebElement getLocalizationButton() {
        return getDriver().findElement(localizationButton);
    }

    public void openCitiesPage() {
        getAdminButton().click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("#list-item-112")).click();
    }

}
