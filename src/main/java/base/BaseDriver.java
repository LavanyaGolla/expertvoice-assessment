package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseDriver {
    public static WebDriver driver;
    public static Properties properties;

    public BaseDriver(){
        try{
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream("src/main/java/config/config.properties");
            properties.load(inputStream);
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void initializeTheBrowser(){
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
            driver = new ChromeDriver();
        }
        if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
            driver = new FirefoxDriver();
        }

        driver.get(properties.getProperty("url"));
    }

    public static void navigateBack(){
        driver.navigate().back();
    }

}
