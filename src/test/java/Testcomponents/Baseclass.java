package Testcomponents;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.pageobjectmodel.LandingPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
public class Baseclass
{
     public static WebDriver driver;
     public static LandingPage landingPage;

     public WebDriver initialize() throws IOException
     {
         ChromeOptions options = new ChromeOptions();
         FirefoxOptions options1 = new FirefoxOptions();
         options.addArguments("--guest");
         options1.addArguments("--guest");
         Properties properties = new Properties();
         FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//GlobalData.properties");
         properties.load(stream);
         String getpropertys = properties.getProperty("browser");
         if(getpropertys.equalsIgnoreCase("chrome"))
         {
             driver = new ChromeDriver(options);
         }
         else if(getpropertys.equalsIgnoreCase("firefox"))
         {
             driver = new FirefoxDriver(options1);
         }
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         return  driver;
     }

     @BeforeMethod(alwaysRun = true)
     public LandingPage launchApplication() throws IOException
     {
        driver = initialize();
        landingPage = new LandingPage(driver);
        landingPage.loadurl("https://arjitnigam.github.io/myDreams/");
        return landingPage;
     }

    public String takeScreenShoot(String testcaseName, WebDriver driver) throws IOException
    {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);

        // Save screenshot inside reports/screenshots folder
        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
        File directory = new File(folderPath);
        if (!directory.exists())
        {
            directory.mkdirs();
        }

        String fileName = testcaseName + "_" + System.currentTimeMillis() + ".png";
        String fullPath = folderPath + fileName;

        FileUtils.copyFile(source, new File(fullPath));

        // Return relative path for HTML
        return "screenshots/" + fileName;
    }

//     @AfterMethod
//     public void quit()
//     {
//         driver.quit();
//     }
}
