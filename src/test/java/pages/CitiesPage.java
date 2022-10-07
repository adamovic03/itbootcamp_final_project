package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends HomePage{

    private By searchField = By.id("search");
    private By addItemButton = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span");
    private By cityNameField = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");

    public CitiesPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public WebElement getSearchField() {
        return getDriver().findElement(searchField);
    }

    public WebElement getAddItemButton() {
        return getDriver().findElement(addItemButton);
    }

    public WebElement getCityNameField() {
        return getDriver().findElement(cityNameField);
    }

    public void createNewCity() {
        getAddItemButton().click();
        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Mladenovac");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.findElement(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.btnSave.v-btn.v-btn--text.theme--light.v-size--default.green--text.text--lighten3")).click();
    }



}
