package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BaseTest {

    @Test
    public void verifyThatCitiesPageIsLoaded() {
        String urlExpectedResult = "https://vue-demo.daniel-avellaneda.com/admin/cities";

        startPage.openLoginPage();
        loginPage.login();
        homePage.openCitiesPage();
        String urlActualResult = driver.getCurrentUrl();

        Assert.assertEquals(urlActualResult, urlExpectedResult);
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }

    @Test
    public void verifyThatCreatedCityIsSaved() {
        startPage.openLoginPage();
        loginPage.login();
        homePage.openCitiesPage();
        citiesPage.createNewCity();

        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")).
                getText().contains("Saved successfully"));
    }



}
