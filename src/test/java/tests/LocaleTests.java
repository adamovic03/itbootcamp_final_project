package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BaseTest {

    @Test
    public void verifyThatLocaleIsSetToSpanish() {
        startPage.setLocaleToES();
        Assert.assertTrue(startPage.getHeader().getText().contains("Página de aterrizaje"));
    }

    @Test
    public void verifyThatLocaleIsSetToEnglish() {
        startPage.setLocaleToEN();
        Assert.assertTrue(startPage.getHeader().getText().contains("Landing"));
    }

    @Test
    public void verifyThatLocaleIsSetToFrench() {
        startPage.setLocaleToFR();
        Assert.assertTrue(startPage.getHeader().getText().contains("Page d'atterrissage"));
    }

}
