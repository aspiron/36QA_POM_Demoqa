package tests;

import ch.qos.logback.classic.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class TestBase {

    public WebDriver dr;

    Logger logger = (Logger) LoggerFactory.getLogger(TestBase.class);

    @BeforeMethod
    public void init() {
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("https://demoqa.com/");
        dr.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(enabled = false)
    public void tearDown() {
        dr.quit();
    }

    public void pause(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
