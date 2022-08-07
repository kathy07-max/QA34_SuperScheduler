package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.User;
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
    @FindBy (xpath = "//*[@ resource-id='android:id/message']")
    MobileElement errorMessage;

    @FindBy (xpath = "//*[@resource-id='android:id/button1']")
    MobileElement okButton;

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
       public WizardScreen submitRegistr(){
        driver.hideKeyboard();
        loginButton.click();
        return new WizardScreen(driver);
    }
    public HomeScreen complexLogin(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        submitLogin();
        return new HomeScreen(driver);
    }
    public LoginScreen  complexNegativeLogin(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        submitLogin();
        return this;
    }
    public LoginScreen checkErrorMessage(String text){
        shouldHave(errorMessage,text,5);
        return this;
    }
    public void confirmError() {
        okButton.click();
    }
}
