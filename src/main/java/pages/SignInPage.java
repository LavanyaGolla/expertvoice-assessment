package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BaseDriver {

    //Object repo
    @FindBy(xpath="//input[@name='identifier']")
    WebElement userName;

    @FindBy(xpath="//input[@name='password']")
    WebElement password;

    @FindBy(xpath="//button[@type='submit']")
    WebElement signInButton;

    @FindBy(xpath="//h1[@class='page-title']")
    WebElement pageTitle;

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

        public SignInAlertPage clickSignIn(){
            signInButton.click();
            return new SignInAlertPage();
        }

        public String getPageTitle(){
            return pageTitle.getText();
        }
}
