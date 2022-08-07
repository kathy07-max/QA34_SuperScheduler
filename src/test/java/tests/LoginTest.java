package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LoginTest extends Configuration {

    @Test
    public void testLoginSuccess(){
        boolean addPresent = new SplashScreen(driver).checkCurrentVersion("0.0.3")
               .fillEmail("katermax07@mail.ru")
               .fillPassword("Rr020985$")
               .submitLogin()
               .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
}
