package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CitiesTests extends BaseTest {

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

        Assert.assertTrue(citiesPage.getConfirmationMessage().getText().contains("Saved successfully"));
        citiesPage.logout();
    }

    @Test (dependsOnMethods = {"verifyThatCreatedCityIsSaved"})
    public void verifyThatCityIsEdited() {
        startPage.openLoginPage();
        loginPage.login();
        homePage.openCitiesPage();
        citiesPage.editCity();

        Assert.assertTrue(citiesPage.getConfirmationMessage().getText().contains("Saved successfully"));
        citiesPage.logout();
    }



}
