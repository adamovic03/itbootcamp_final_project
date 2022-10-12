package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends HomePage {

    private By searchField = By.id("search");
    private By addItemButton = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button/span");
    private By cityNameField = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]");
    private By saveButton = By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions " +
            "> button.btnSave.v-btn.v-btn--text.theme--light.v-size--default.green--text.text--lighten3");
    private By editButton = By.cssSelector(".v-data-table__wrapper > table:nth-child(1) > tbody:nth-child(3) > tr:nth-child(1) > td:nth-child(1) > div:nth-child(1) > button:nth-child(1)");
    private By confirmationMessage = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By deleteButton = By.cssSelector("#delete");
    private By deleteConfirmationMessage = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]");
    private By cityField = By.id("name");

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

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public WebElement getEditButton() {
        return getDriver().findElement(editButton);
    }

    public WebElement getConfirmationMessage() {
        return getDriver().findElement(confirmationMessage);
    }

    public WebElement getDeleteButton() {
        return getDriver().findElement(deleteButton);
    }

    public WebElement getDeleteConfirmationMessage() {
        return getDriver().findElement(deleteConfirmationMessage);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }


    public void createNewCity() {
        getAddItemButton().click();
        getCityField().sendKeys("Mladenovac");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //using thread sleep for button to be clickable.
        getSaveButton().click();
    }

    public void editCity() {
        getEditButton().click();
        getCityField().sendKeys(" edited");
        driver.findElement(By.cssSelector(".btnSave > span:nth-child(1)")).click();
        //path to save button.
    }

    public void searchCity() {
        getSearchField().sendKeys("Mladenovac");
    }

    public void deleteCity() {
        getDeleteButton().click();
        driver.findElement(By.cssSelector("#app > div.v-dialog__content.v-dialog__content--active > div > div " +
                "> div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3 > span")).click();
        // path for confirmation button for deleting city.
    }


}
