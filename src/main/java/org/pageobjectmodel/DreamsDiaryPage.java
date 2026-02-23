package org.pageobjectmodel;
import com.google.j2objc.annotations.WeakOuter;
import org.abstractpackage.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.HashMap;
import java.util.List;

public class DreamsDiaryPage extends Abstractclass
{
    WebDriver driver;
    public DreamsDiaryPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    //List<WebElement> colms = driver.findElements(By.xpath("//div[@class='content-wrapper']//table//thead//tr//th"));

    @FindBy(xpath = "//div[@class='content-wrapper']//table//thead//tr//th")
    List<WebElement> colms ;

    //List<WebElement> col_count = driver.findElements(By.xpath("//div[@class='content-wrapper']//tbody//tr"));

    @FindBy(xpath = "//div[@class='content-wrapper']//tbody//tr")
    List<WebElement> col_count;


    //(//div[@class='content-wrapper']//tbody//tr//td[3])
    @FindBy(xpath = "(//div[@class='content-wrapper']//tbody//tr//td[3])")
    List<WebElement> dream_type;


    @FindBy(tagName = "td")
    List<WebElement> allvalues;

    ////div[@class='content-wrapper']//table//tbody//td[1]

    @FindBy(xpath = "//div[@class='content-wrapper']//table//tbody//td[3]")
    List<WebElement> Dreamnames ;

    public List<WebElement> getColms()
    {
        return colms;
    }

    public List<WebElement> getCol_count()
    {
        return col_count;
    }

    public List<WebElement> getDream_type()
    {
        return dream_type;
    }

    public List<WebElement> getAllvalues()
    {
        return allvalues;
    }

    public List<WebElement> stringIntegerHashMap()
    {
        return  Dreamnames;
    }

    public DreamsTotalPage getDreamTotal()
    {
        return new DreamsTotalPage(driver);
    }

}
