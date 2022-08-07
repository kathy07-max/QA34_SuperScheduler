package tests;

import manager.Configuration;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class RegistrationTests extends Configuration {

    @Test
    public void registrationSuccess(){
        int i = (int)((System.currentTimeMillis()/1000)%3800);

        boolean addPresent = new LoginScreen(driver)
               .fillEmail("masha00"+i+"@gmail.com")
               .fillPassword("Mm020985$")
               .submitRegistr()
               .skipWizard()
               .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }

    @AfterMethod
    public void postCondition(){
        new HomeScreen(driver).openMenu().logout();
    }
}
