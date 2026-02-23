package org.pageobjectmodel;
import org.abstractpackage.Abstractclass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.time.Duration;
public class LandingPage extends Abstractclass
{
        WebDriver driver;
    //WebElement gettingWelcomeMsg = driver.findElement(By.xpath("//div[@class='loading-animation']//h1"));

    @FindBy(xpath = "//div[@class='loading-animation']//h1")
    WebElement gettingWelcomeMsg;

    // WebElement gettingLoadingMsg = driver.findElement(By.xpath("//div[@class='loading-animation']//p"));
    @FindBy(xpath = "//div[@class='loading-animation']//p")
    WebElement gettingLoadingMsg  ;

    //WebElement loadingimg = driver.findElement(By.xpath("//div[@class='loading-animation']"));
    //        boolean disappear = wait.until(ExpectedConditions.invisibilityOf(loadingimg));

    By  loadingimg = By.xpath("//div[@class='loading-animation']");

    public boolean disappearloading()
    {
       return waitOfINVisibilityOfWebElement(loadingimg);
    }

    //  WebElement dreamicon = driver.findElement(By.xpath("//div[@class='dream-icon']"));
    //        boolean flag = wait.until(ExpectedConditions.visibilityOf(dreamicon)).isDisplayed();
    //        Assert.assertTrue(flag);

    @FindBy(xpath = "//div[@class='dream-icon']")
    WebElement dreamicon;

    public boolean appearDreamicon()
    {
       return waitOfVisibilityOfWebElementReturnType(dreamicon);
    }


    // WebElement gettingExplore = driver.findElement(By.xpath("//div[@id='mainContent']//p"));
    //        String text = wait.until(ExpectedConditions.visibilityOf(gettingExplore)).getText();

    @FindBy(xpath = "//div[@id='mainContent']//p")
    WebElement gettingExplore;
    public String gettingExplores()
    {
        waitOfVisibilityOfWebElement(gettingExplore);
        return gettingExplore.getText();
    }

    //WebElement mydreamBtn = driver.findElement(By.xpath("//button[@id='dreamButton']"));
    //        wait.until(ExpectedConditions.visibilityOf(mydreamBtn)).click();

    @FindBy(xpath = "//button[@id='dreamButton']")
    WebElement mydreamBtn;

    public DreamsDiaryPage clickbutton(int i) throws InterruptedException
    {
        waitOfVisibilityOfWebElement(mydreamBtn);
        mydreamBtn.click();
        Thread.sleep(2000L);
        changeHandler(i);
        return new DreamsDiaryPage(driver);
    }

    public String Welcome()
    {
        return  gettingWelcomeMsg.getText();
    }

    public String loading()
    {
        return gettingLoadingMsg.getText();
    }


    public LandingPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void loadurl(String url)
    {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(url);
    }




}
