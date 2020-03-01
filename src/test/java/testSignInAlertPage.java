import base.BaseDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.ResetPasswordPage;
import pages.SignInPage;
import pages.SignUpPage;

public class testSignInAlertPage extends BaseDriver {

    SignInPage signInPage;
    SignInPage.AlertWindow alertWindow;
    SignUpPage signUpPage;
    ResetPasswordPage resetPasswordPage;

    public testSignInAlertPage(){
        super();
    }

    @Before
    public void setup(){
        initializeTheBrowser();
        signInPage = new SignInPage();
        signInPage.setUserName(properties.getProperty("username"));
        alertWindow = signInPage.clickSignInWithInsufficientData();
    }

    ///
    // This test validates if the alert is displayed
    // when user clicks the Sign In button without providing the password
    // and the contents of alert box
    ///
    @Test
    public void AlertContentTest() {

        //Validating the display of the alert window and it's content
        Assert.assertTrue(alertWindow.displayOfAlertWindow());
        Assert.assertEquals(alertWindow.getAlertContent(), signInPage.alertContentText);

        //Validating the "sign up" link
        signUpPage = alertWindow.clickSignUp();
        Assert.assertEquals(signUpPage.getPageTitle(), signUpPage.pageTitleText);

        navigateBack();

        //Validating the "reset your password" link
        resetPasswordPage = alertWindow.clickResetPassword();
        Assert.assertEquals(resetPasswordPage.getPageTitle(), resetPasswordPage.pageTitleText);

        navigateBack();

        //Validating the close icon
        signInPage = alertWindow.clickCloseIcon();
        Assert.assertFalse(alertWindow.displayOfAlertWindow());
    }

    @After
    public void closeDriver(){
        driver.quit();
    }
}
