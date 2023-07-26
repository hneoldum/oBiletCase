package PageObjectModel;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class SingUpPage extends BasePage{
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhh");
    String date = simpleDateFormat.format(new Date());
    private WebDriver driver;

    public SingUpPage() {
        driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }
    public void clickMemberLogin(){
        waitUntilVisible(driver.findElement(By.xpath("//a[@class='logo']")));

        clickElement(driver.findElement(By.xpath("//a[@href='javascript:void(0)']")));
        waitUntilVisible(driver.findElement(By.id("facebook-provider")));
    }

    public void clickRegisterButton(){
        if (driver.findElement(By.xpath("//div[@class=\"body\"]//h2")).getText().equals("Register")){
            clickElementJS(By.xpath("  //button[@class=\"register register-button\"]"));

        }else {
            clickElementJS(By.xpath("//a[@class='sign-up login-to-register']"));
        }

      //  clickElement(driver.findElement(By.xpath("//a[@class='sign-up login-to-register']")));

    }
    public void typeEmail(String email){
        Random random = new Random();
        int rand = random.nextInt();
        clickElementJS(By.xpath("//*[@type='email']"));
        sendKeys(driver.findElement(By.xpath("//*[@type='email']")),email+rand+"@gmail.com");
    }
    public void typePassword(String password){
        waitUntilVisible(driver.findElement(By.xpath("//*[@type='password']")));
        clickElement(driver.findElement(By.xpath("//*[@type='password']")));
        sendKeys(driver.findElement(By.xpath("//*[@type='password']")),password);
    }

    public void clickContractCheckbox(){

        clickElement(driver.findElement(By.id("contract-checkbox")));
    }
    public void checkHomePage(){
        String text= driver.findElement(By.xpath("//a[@href='/en/member/profile']")).getText();
        Assert.assertEquals("My Account",text);
        waitUntilVisible(driver.findElement(By.xpath("//a[@href='/en/member/profile']")));
    }
}
