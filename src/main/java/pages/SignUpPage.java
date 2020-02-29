package pages;

import base.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends BaseDriver {

    //Variables
    public String pageTitleText = "Sign Up For ExpertVoice";

    //Object repo
    @FindBy(xpath="//h1[@class='page-title']")
    WebElement pageTitle;

    //initialization
    public SignUpPage(){
        PageFactory.initElements(driver, this);
    }

    //actions
    public String getPageTitle(){
        return pageTitle.getText();
    }
}
