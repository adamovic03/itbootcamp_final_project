package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    private By myProfileButton = By.cssSelector("a.v-btn:nth-child(3)");
    private By adminButton = By.cssSelector(".btnAdmin");
    private By logoutButton = By.cssSelector("button.hidden-sm-and-down:nth-child(7)");

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

    public WebElement getMyProfileButton() {
        return getDriver().findElement(myProfileButton);
    }

    public WebElement getAdminButton() {
        return getDriver().findElement(adminButton);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
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

    public void logout() {
        getLogoutButton().click();
    }

    public void goToMyProfilePage() {
        getMyProfileButton().click();
    }

}
