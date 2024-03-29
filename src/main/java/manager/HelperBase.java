package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelperBase {
    WebDriver wd;
    Logger logger = LoggerFactory.getLogger(HelperBase.class);

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }
    public void type(By locator, String text) {
        //find+ click +clear+ sendKey
        if (text != null) {
            WebElement element = wd.findElement(locator);

            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }
    public void click(By locator){
        pause(500);
        wd.findElement(locator).click();

    }
    public void submit() {
        wd.findElement(By.xpath("//button[1]")).click();
    }
    public void pause(int time){
        
    }



}
