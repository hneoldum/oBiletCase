package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver(){

        if(driver==null){
            System.setProperty("webdriver.chrome.driver","C:\\Users\\handenur.neoldum\\Downloads\\chromedriver.exe");

            ChromeOptions ops = new ChromeOptions();
            ops.addArguments("--disable-notifications");
            ops.addArguments("start-maximized");
            driver=new ChromeDriver(ops);
        }
        return driver;
    }


    public static void closeDriver(){

        if(driver!=null){
            driver.quit();
            driver=null;
        }
    }


}
