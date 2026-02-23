package org.example;
import Testcomponents.Baseclass;
import model.ModelClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pageobjectmodel.DreamsDiaryPage;
import org.pageobjectmodel.DreamsTotalPage;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Listeners(Testcomponents.Listenersclass.class)
public class FunctionalTesting extends Baseclass
{
    public static ModelClass modelClass = new ModelClass();
    public DreamsDiaryPage dreamsDiaryPage;
    public DreamsTotalPage dreamsTotalPage;

    @Test(priority = 1)
    public  void loading()
    {
        Assert.assertEquals(modelClass.getWelcomeMsg(),landingPage.Welcome());
        Assert.assertEquals(modelClass.getLoadingMsg(),landingPage.loading());
        System.out.println((landingPage.disappearloading()) ? "Disappeared" : "Not Disappeared");
    }

    @Test(priority = 2)
    public void landing() throws InterruptedException
    {
        Assert.assertTrue(landingPage.appearDreamicon());
        Assert.assertEquals(landingPage.gettingExplores(),modelClass.getExploreText());
        dreamsDiaryPage = landingPage.clickbutton(1);
    }


    @Test(priority = 3)
    public void dreams() throws InterruptedException
    {
        dreamsDiaryPage = landingPage.clickbutton(1);
        modelClass.setList("Dream Name","Days Ago","Dream Type");
        List<WebElement> colms = dreamsDiaryPage.getColms();
        for(int i = 0;i<colms.size();i++)
        {
            Assert.assertEquals(modelClass.getList().get(i),colms.get(i).getText());
        }
        List<WebElement> col_count = dreamsDiaryPage.getCol_count();
        Assert.assertEquals(col_count.size(), 10);
    }

    @Test(priority = 4)
    public void onlygoodandbad() throws InterruptedException
    {
        dreamsDiaryPage = landingPage.clickbutton(1);
        List<WebElement> dreamType = dreamsDiaryPage.getDream_type();
        for (WebElement element : dreamType)
        {
            String type = element.getText();
            Assert.assertTrue(type.equals("Good") || type.equals("Bad"), "Type is neither Good nor Bad");
        }
    }

    @Test(priority = 5)
    public void checkallfilled() throws InterruptedException
    {
        dreamsDiaryPage = landingPage.clickbutton(1);
        List<WebElement> elements = dreamsDiaryPage.getAllvalues();
        for(WebElement e  : elements)
        {
            String extract = e.getText();
            Assert.assertFalse(extract.isEmpty());
            System.out.println(extract);
        }
    }

    @Test()
    public void countingdreams() throws InterruptedException
    {
        dreamsDiaryPage = landingPage.clickbutton(2);
        List<WebElement>  dreamnames = dreamsDiaryPage.stringIntegerHashMap();
        HashMap<String,Integer> map = new HashMap<>();
        for(WebElement e : dreamnames)
        {
            String name = e.getText();
            map.put(name,map.getOrDefault(name,0)+1);
        }
        for(Map.Entry<String,Integer> mapp : map.entrySet())
        {
            System.out.println(mapp.getKey()+" "+mapp.getValue());
        }
        dreamsDiaryPage.changeHandler(2);
        dreamsTotalPage = dreamsDiaryPage.getDreamTotal();
        List<WebElement> dream = dreamsTotalPage.getDreamType();
        for(WebElement e : dream)
        {
            List<WebElement> cols = e.findElements(By.tagName("td"));
            String dreamType = cols.get(0).getText().trim();
            String count = cols.get(1).getText().trim();
            if(dreamType.equalsIgnoreCase("Good Dreams"))
            {
                for(Map.Entry<String,Integer> mapp : map.entrySet())
                {
                    int num = mapp.getValue();
                    if(Integer.toString(num).equals(count))
                    {
                        System.out.println("Good Dreams Matched");
                    }
                }
            }
            if(dreamType.equalsIgnoreCase("Bad Dreams"))
            {
                for(Map.Entry<String,Integer> mapp : map.entrySet())
                {
                    int num = mapp.getValue();
                    if(Integer.toString(num).equals(count))
                    {
                        System.out.println("Bad Dreams Matched");
                    }
                }
            }
        }
    }
}
