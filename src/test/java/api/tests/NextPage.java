package api.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class NextPage {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);

    }
    @Test
    public void googleNext(){
        driver.get("");
        WebElement next = driver.findElement(By.linkText("Next"));
        int count=0;
        while (next.isDisplayed()){
            try{
                next.click();
                next = driver.findElement(By.linkText("Next"));
                count++;
            }catch (NoSuchElementException e){
                System.out.println(count);
                break;
            }

        }
    }
}
