package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BaseTest {

    @Test
    public void visitSignupPage() {
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/signup";

        startPage.openSignUpPage();
        String actualResult = driver.getCurrentUrl();

        Assert.assertEquals(actualResult, expectedResult);
    }



}
