package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage{

    private By name = By.id("name");
    private By email = By.id("email");
    private By password = By.id("password");
    private By confirmPassword = By.id("confirmPassword");
    private By signUpButton = By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button");
    private By logoutButton = By.xpath("/html/body/div/div[1]/div/header/div/div[3]/button[1]");
    private Faker faker = new Faker();

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return driverWait;
    }

    public WebElement getName() {
        return getDriver().findElement(name);
    }

    public WebElement getEmail() {
        return getDriver().findElement(email);
    }

    public WebElement getPassword() {
        return getDriver().findElement(password);
    }

    public WebElement getConfirmPassword() {
        return getDriver().findElement(confirmPassword);
    }

    public WebElement getSignUpButton() {
        return getDriver().findElement(signUpButton);
    }

    public WebElement getLogoutButton() {
        return getDriver().findElement(logoutButton);
    }

    public String emailFieldType() {
        return getEmail().getAttribute("type");
    }

    public String passwordFieldType() {
        return getPassword().getAttribute("type");
    }

    public String confirmPasswordFieldType() {
        return getConfirmPassword().getAttribute("type");
    }

    public void signupWithExistingUser() {
        getName().sendKeys("Test Test");
        getEmail().sendKeys("admin@admin.com");
        getPassword().sendKeys("123654");
        getConfirmPassword().sendKeys("123654");
        getSignUpButton().click();
    }

    public void signup() {
        getName().sendKeys("Milos Adamovic");
        getEmail().sendKeys("milos.adamovic@itbootcamp.rs");
        getPassword().sendKeys("12346");
        getConfirmPassword().sendKeys("12346");
        getSignUpButton().click();
    }

    public void logout() {
        getLogoutButton().click();
    }

}
