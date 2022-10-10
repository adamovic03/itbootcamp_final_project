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
        citiesPage.logout();
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

    @Test (dependsOnMethods = {"verifyThatCityIsEdited"})
    public void verifyThatEditedCityIsDisplayed() {
        String expectedResult = "Mladenovac edited";

        startPage.openLoginPage();
        loginPage.login();
        homePage.openCitiesPage();
        String actualResult = citiesPage.getCityNameField().getText();

        Assert.assertEquals(actualResult, expectedResult);
        citiesPage.logout();
    }

    @Test (dependsOnMethods = {"verifyThatEditedCityIsDisplayed"})
    public void deleteCity() {
        String expectedResult = "Deleted successfully\nCLOSE";

        startPage.openLoginPage();
        loginPage.login();
        homePage.openCitiesPage();
        citiesPage.searchCity();

        Assert.assertTrue(citiesPage.getCityNameField().getText().contains("Mladenovac"));

        citiesPage.deleteCity();
        //used thread sleep because waits didn't work to catch actual result. This way works brilliantly.
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String actualResult = citiesPage.getDeleteConfirmationMessage().getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

}
