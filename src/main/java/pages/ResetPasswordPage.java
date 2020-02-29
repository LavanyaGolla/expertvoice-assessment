package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends BaseDriver {

    //Variables
    public String pageTitleText = "Reset Password";

    //Object repo
    @FindBy(xpath="//h1[@class='page-title']")
    WebElement pageTitle;

    //initialization
    public ResetPasswordPage(){
        PageFactory.initElements(driver, this);
    }

    //actions
    public String getPageTitle(){
        return pageTitle.getText();
    }
}
