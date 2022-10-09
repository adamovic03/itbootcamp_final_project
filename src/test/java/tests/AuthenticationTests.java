package tests;

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

    @Test
    public void verifyThatUserCanNotOpenAdminCitiesPageIfNotLoggedIn() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
        authenticationAssert();
    }

    @Test
    public void verifyThatUserCanNotOpenAdminUsersPageIfNotLoggedIn() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
        authenticationAssert();
    }

}
