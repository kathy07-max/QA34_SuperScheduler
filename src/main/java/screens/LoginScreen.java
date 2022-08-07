package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen{
    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy (xpath  ="//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passEditText;
    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail (String email){
        should(emailEditText,10);
        type(emailEditText, email);
        return this;
    }
    public LoginScreen fillPassword(String password){
        type(passEditText, password);
        return this;
    }

    public HomeScreen submitLogin(){
        driver.hideKeyboard();
        loginButton.click();
        return new HomeScreen(driver);
    }
}
