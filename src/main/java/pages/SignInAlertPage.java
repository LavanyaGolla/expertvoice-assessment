package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInAlertPage extends BaseDriver {

    //Variables
    public String alertContentText = "This account information is incorrect. Would you like to sign up or reset your password?";

    //Object repo
    @FindBy(xpath="//div[@class='alert alert-error alert-in']")
    WebElement alertBox;

    @FindBy(xpath="//div[@class='alert-content']")
    WebElement alertContent;

    @FindBy(xpath="//a[@name='signUpLink']")
    WebElement signUpLink;

    @FindBy(xpath="//a[@name='passwordLink']")
    WebElement resetPasswordLink;

    @FindBy(xpath="//i[@class='fa fa-close']")
    WebElement closeIcon;

    //initialization
    public SignInAlertPage(){
        PageFactory.initElements(driver, this);
    }

    //actions
    public boolean displayOfAlertWindow(){
        return alertBox.isDisplayed();
    }

    public String getAlertContent(){
        return alertContent.getText();
    }

    public SignInPage clickCloseIcon(){
        closeIcon.click();
        return new SignInPage();
    }

    public SignUpPage clickSignUp(){
        signUpLink.click();
        return new SignUpPage();
    }

    public ResetPasswordPage clickResetPassword(){
        resetPasswordLink.click();
        return new ResetPasswordPage();
    }
}
