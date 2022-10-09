package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest{

    @Test
    public void verifyThatLocaleIsSetToSpanish() {
        loginPage.setLocaleToES();
        Assert.assertTrue(loginPage.getHeader().getText().contains("Página de aterrizaje"));
    }

    @Test
    public void verifyThatLocaleIsSetToEnglish() {
        loginPage.setLocaleToEN();
        Assert.assertTrue(loginPage.getHeader().getText().contains("Landing"));
    }

    @Test
    public void verifyThatLocaleIsSetToFrench() {
        loginPage.setLocaleToFR();
        Assert.assertTrue(loginPage.getHeader().getText().contains("Page d'atterrissage"));
    }



}
