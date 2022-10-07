package tests;

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

}
