package org.pageobjectmodel;

import org.abstractpackage.Abstractclass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DreamsTotalPage extends Abstractclass
{
    WebDriver driver;
    public DreamsTotalPage(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    ////div[@class='content-wrapper']//table//tbody//tr//td
    @FindBy(xpath = "//div[@class='content-wrapper']//table//tbody//tr//td")
    List<WebElement> dreamType;

    public List<WebElement> getDreamType()
    {
        return dreamType;
    }
}
