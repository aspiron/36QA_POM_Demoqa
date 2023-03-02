package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;

public abstract class PageBase {

    public WebDriver dr;

    public PageBase(WebDriver dr) {
        this.dr = dr;
        PageFactory.initElements(dr, this);
    }

    public void click(WebElement element) {
        element.click();
    }

    public void type(WebElement element, String text) {
        if (text != null) {
            element.click();
            element.clear();
            element.sendKeys(text);
        }
    }


    public void clickWithJSExecutor(WebElement element, int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("window.scrollBy(" + x + "," + y + ")");
        click(element);
    }

    public void typeWithJSExecutor(WebElement element, int x, int y, String text) {
        if (text != null) {
            clickWithJSExecutor(element, x, y);
            element.clear();
            element.sendKeys(text);
        }
    }

    public void wait(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void goDown(Keys keyboardBtn){
        new Actions(dr).keyDown(keyboardBtn).perform();
    }

    public void hideAds(){
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("document.getElementById('adplus-anchor').style.display='none'");
    }

    public void removeAds(){
        JavascriptExecutor js = (JavascriptExecutor) dr;
        js.executeScript("document.getElementById('adplus-anchor').remove()");
        js.executeScript("document.getElementById('widget-pl-272943').remove()");
    }


    public Keys getCtrlCmd(){
        Keys cmdCtrl = null;
        String os = System.getProperty("os.name");
        System.out.println(os);

        if (os.startsWith("Win"))
        {
            cmdCtrl = Keys.CONTROL;
            return cmdCtrl;
        }
        else if (os.startsWith("Mac"))
        {
            cmdCtrl = Keys.COMMAND;
            return cmdCtrl;
        }
        return null;
    }



    public int checkLink(String link) {
        try {
            URL url = new URL(link);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setConnectTimeout(5000);
            connection.connect();
            if (connection.getResponseCode() >= 400) {
                return 1;
            } else {
                return 0;
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.toString());
            return 1;
        }
    }






}
