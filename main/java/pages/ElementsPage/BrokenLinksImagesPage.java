package pages.ElementsPage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.io.IO;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.io.IOException;
import java.util.List;

public class BrokenLinksImagesPage extends PageBase {
    public BrokenLinksImagesPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(tagName = "img")
    List<WebElement> images;

    public int checkNoBrokenImages() {
        int numberOfBrokeLImages = 0;
        for (int i = 0; i < images.size(); i++) {
            WebElement image = images.get(i);
            String imageURL = image.getAttribute("src");
            try {
                boolean isImageDisplayed = (Boolean) ((JavascriptExecutor) dr)
                        .executeScript("return (typeof arguments[0].naturalWidth != undefined && arguments[0].naturalWidth>0);", image);

                if (isImageDisplayed) {
                    System.out.println("Image displayed: " + imageURL);
                } else {
                    System.out.println("Image not displayed: " + imageURL);
                    numberOfBrokeLImages = numberOfBrokeLImages + 1;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.toString());
            }
        }
        return numberOfBrokeLImages;

    }

    @FindBy(tagName = "a")
    List<WebElement> links;

    public int checkNumberBrokenLinks() {
        int numberOfBrokenLinks = 0;
        for (int i = 0; i < links.size(); i++) {
            WebElement link = links.get(i);
            String href = link.getAttribute("href");

            int broken = 0;
            broken = checkLink(href);
            numberOfBrokenLinks = numberOfBrokenLinks + broken;

            System.out.println("Link is broken: " + broken + ". URL is " + href + ". Link element: " + link.getText());
        }
        return numberOfBrokenLinks;
    }
}
