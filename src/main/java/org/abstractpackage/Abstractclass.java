package org.abstractpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class Abstractclass
{
    WebDriver driver;
    public Abstractclass(WebDriver driver)
    {
        this.driver = driver;
    }
    public void waitOfVisibilityOfWebElement(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public boolean waitOfVisibilityOfWebElementReturnType(WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }
    public boolean waitOfINVisibilityOfWebElement(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
    }
    public boolean waitOfINVisibilityOfByElement(By element)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.pollingEvery(Duration.ofMillis(200));
      return   wait.until(ExpectedConditions.invisibilityOfElementLocated(element));
    }
    public void changeHandler(int i) throws InterruptedException
    {
        Set<String> handles = driver.getWindowHandles();
        List<String> windows = new ArrayList<>(handles);
        Thread.sleep(2000L);
        driver.switchTo().window(windows.get(i));
    }
}
