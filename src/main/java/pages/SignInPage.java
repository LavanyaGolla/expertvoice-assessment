package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseDriver {

    //Variables
    public String alertContentText = "This account information is incorrect. Would you like to sign up or reset your password?";

    //Object repo
    @FindBy(xpath = "//input[@name='identifier']")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement signInButton;

    @FindBy(xpath="//h1[@class='page-title']")
    WebElement pageTitle;

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
    public SignInPage(){
        PageFactory.initElements(driver, this);
    }

    //actions
        public void setUserName(String un){
            userName.sendKeys(un);
        }

        public void setPassword(String pw){
            password.sendKeys(pw);
        }

        public String getPageTitle(){
        return pageTitle.getText();
    }

        public AlertWindow clickSignInWithInsufficientData() {
            signInButton.click();
            return new AlertWindow();
        }

        public class AlertWindow{

            //actions
            public boolean displayOfAlertWindow(){
                return alertBox.isDisplayed();
            }

            public String getAlertContent(){
                return alertContent.getText();
            }

            public SignUpPage clickSignUp(){
                signUpLink.click();
                return new SignUpPage();
            }

            public ResetPasswordPage clickResetPassword(){
                resetPasswordLink.click();
                return new ResetPasswordPage();
            }

            public SignInPage clickCloseIcon(){
                closeIcon.click();
                return new SignInPage();
            }
        }
}
