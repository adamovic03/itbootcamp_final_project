package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyProfileTest extends BaseTest {

    @Test
    public void verifyThatUserCanChangeProfileData() throws InterruptedException {
        String expectedResult = "Profile saved successfuly\nCLOSE";

        startPage.openLoginPage();
        loginPage.login();
        Thread.sleep(500);
        //used for page to load and 'my profile' button to be clickable. Tried with explicit wait -> error null pointer.
        homePage.goToMyProfilePage();
        Thread.sleep(500);
        //used for profile page to load and fields to be available. Tried with explicit wait -> error null pointer.
        profilePage.inputDataAndSubmit();
        String actualResult = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")).getText();
        //path for message that data is saved successfully.

        Assert.assertEquals(actualResult, expectedResult);
        Assert.assertTrue(profilePage.correctData());


    }

}
