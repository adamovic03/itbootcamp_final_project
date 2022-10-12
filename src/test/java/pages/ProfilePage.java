package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {

    private By nameField = By.id("name");
    private By phoneField = By.id("phone");
    private By cityField = By.id("city");
    private By cityFieldClear = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[4]/span/div/div/div[1]/div[1]/div[1]/div/button");
    private By cityConfirm = By.cssSelector("#app > div.v-menu__content.theme--light.menuable__content__active.v-autocomplete__content");
    private By countryField = By.id("country");
    private By urlTwitterField = By.id("urlTwitter");
    private By urlGitHubField = By.id("urlGitHub");
    private By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button");
    private String firstName = faker.name().firstName();
    private String lastName = faker.name().lastName();
    private String name = firstName + " " + lastName;
    private String phone = String.valueOf(faker.phoneNumber().cellPhone());
    private String city = "New York";
    private String country = faker.address().country();
    private String twitter = "http://twitter.com/" + firstName.toLowerCase() + lastName.toLowerCase();
    private String gitHub = "http://github.com/" + firstName.toLowerCase() + lastName.toLowerCase();

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public WebElement getNameField() {
        return getDriver().findElement(nameField);
    }

    public WebElement getPhoneField() {
        return getDriver().findElement(phoneField);
    }

    public WebElement getCityField() {
        return getDriver().findElement(cityField);
    }

    public WebElement getCityFieldClear() {
        return getDriver().findElement(cityFieldClear);
    }

    public WebElement getCityConfirm() {
        return getDriver().findElement(cityConfirm);
    }

    public WebElement getCountryField() {
        return getDriver().findElement(countryField);
    }

    public WebElement getUrlTwitterField() {
        return getDriver().findElement(urlTwitterField);
    }

    public WebElement getUrlGitHubField() {
        return getDriver().findElement(urlGitHubField);
    }

    public WebElement getSaveButton() {
        return getDriver().findElement(saveButton);
    }

    public void inputDataAndSubmit() throws InterruptedException {
        getNameField().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        getNameField().sendKeys(name);
        getPhoneField().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        getPhoneField().sendKeys(phone);
        getCityFieldClear().click();
        getCityField().sendKeys(city);
        getCityConfirm().click();
        getCountryField().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        getCountryField().sendKeys(country);
        getUrlTwitterField().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        getUrlTwitterField().sendKeys(twitter);
        getUrlGitHubField().sendKeys(Keys.CONTROL, "a", Keys.DELETE);
        getUrlGitHubField().sendKeys(gitHub);
        getSaveButton().click();
    }

    public boolean correctData() {
        if (getNameField().getAttribute("value").equals(name) && getPhoneField().getAttribute("value").equals(phone) &&
                getCityField().getAttribute("value").equals(city) && getCountryField().getAttribute("value").equals(country) &&
                getUrlTwitterField().getAttribute("value").equals(twitter) && getUrlGitHubField().getAttribute("value").equals(gitHub)) {
            return true;
        }
        return false;
    }

}
