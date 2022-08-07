package tests;

import manager.Configuration;
import models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;


public class LoginTest extends Configuration {

    @Test
    public void loginTestSuccess(){
        boolean addPresent = new LoginScreen(driver)
               .fillEmail("katermax07@mail.ru")
               .fillPassword("Rr020985$")
               .submitLogin()
               .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test (enabled = false)
    public void loginTestSuccess2(){
        boolean addPresent = new LoginScreen(driver)
               .fillEmail("katermax07@mail.ru")
               .fillPassword("Rr020985$")
               .submitLogin()
               .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public void loginSuccessModel() {
        User user = new User().setEmail("masha00@gmail.com").setPassword("Mm020985$");
        boolean addPresent = new LoginScreen(driver)
               .complexLogin(user)
               .isFabAddPresent();
        Assert.assertTrue(addPresent);
    }
    @Test
    public void testNegativeLoginModelWrongPassword(){ // (noa@gmail.com + Nn12345$)
        User user = new User().setEmail("masha00@gmail.com").setPassword("Mm024985$");
        new LoginScreen(driver)
               .complexNegativeLogin(user)
               .checkErrorMessage("Wrong email or password")
               .confirmError(); // click Ok btn
    }

    @AfterMethod
    public void postCondition(){
        new HomeScreen(driver).openMenu().logout();
    }

}
