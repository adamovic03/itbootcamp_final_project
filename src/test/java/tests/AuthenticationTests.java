package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTests extends BaseTest{

    @Test
    public void verifyThatUserCanNotOpenHomePageIfNotLoggedIn() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        authenticationAssert();
    }

    @Test
    public void verifyThatUserCanNotOpenProfilePageIfNotLoggedIn() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        authenticationAssert();
    }


}
