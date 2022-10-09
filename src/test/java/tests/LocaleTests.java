package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void verifyThatLocaleIsSetToSpanish() {
        loginPage.setLocaleToES();
        Assert.assertTrue(loginPage.getHeader().getText().contains("Página de aterrizaje"));
    }



}
