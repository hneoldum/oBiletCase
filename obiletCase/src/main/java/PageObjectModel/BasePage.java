package PageObjectModel;




import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Driver;



import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

public class BasePage {
    //protected Logger logger= (Logger) LoggerFactory.getLogger(getClass());
    static Logger logger= LoggerFactory.getLogger(BasePage.class);
    private WebDriver driver= Driver.getDriver();
    WebDriverWait wait=new WebDriverWait(driver,10);

    public void clickElement(WebElement element){

        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        logger.info("clicked Element : "+element);
    }
    public void waitUntilVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void sendKeys(WebElement sendKeysElement,String value){

        wait.until(ExpectedConditions.visibilityOf(sendKeysElement));
        sendKeysElement.sendKeys(value);
        logInfo("send values: "+value+" to element: "+sendKeysElement);
        logger.info("send values: "+value+" to element: "+sendKeysElement);
    }
    private void setLogger(String... classname) {
        String classN = BasePage.class.getName();
        if (classname.length > 0) {
            classN = classname[0];
        }

    }
    public void logInfo(String message, String... classname) {
        try {
            String str = new String(message.getBytes(StandardCharsets.UTF_8));
            this.setLogger(classname);
            //  this.logger.info(str);
        } catch (Throwable var) {
            throw var;
        }
    }

    public void clickElementJS(By locator) {
        JavascriptExecutor executor = (JavascriptExecutor)this.driver;
        executor.executeScript("arguments[0].click();", driver.findElement(locator));
    }
    public void hoverElement(By locator) {

        Actions actions = new Actions(this.driver);
        actions.moveToElement(driver.findElement(locator)).build().perform();
        this.logInfo("Hovered on element:  '" + locator);
    }
    public void waitUntilElementInvisible(By locator) {

        Wait<WebDriver> waitUntilElementInvisible = (new FluentWait(this.driver)).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100L)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
        waitUntilElementInvisible.until(ExpectedConditions.invisibilityOf(driver.findElement(locator)));
        this.logInfo("Element: '" + locator + "' is invisible");
    }

    public List<WebElement> findElements(By locator) {
        Wait<WebDriver> waitFindElement = (new FluentWait(this.driver)).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofMillis(100L)).ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class);
        waitFindElement.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        return this.driver.findElements(locator);
    }
}
