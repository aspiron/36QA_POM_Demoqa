package pages.ElementsPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.PageBase;

import java.io.File;
import java.io.IOException;

public class UploadAndDownloadPage extends PageBase {
    public UploadAndDownloadPage(WebDriver dr) {
        super(dr);
    }

    @FindBy(id = "downloadButton")
    WebElement downloadButton;
    @FindBy(id = "uploadFile")
    WebElement uploadFile;

    public boolean verifyDownload() {
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/sampleFile.jpeg";
        File f = new File(path);

        if (f.exists()) {
            f.delete();
        }
        click(downloadButton);
        wait(3000);

        if (f.exists()) {
            f.delete();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }


    public UploadAndDownloadPage selectFile() {
        String home = System.getProperty("user.home");
        String path = home + "/Downloads/sampleFile.jpeg";
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("file already exists");
        }
        uploadFile.sendKeys(path);
        return this;
    }

    @FindBy(id = "uploadedFilePath")
    WebElement uploadedFilePath;

    public boolean checkFileIsSelected(){
        return uploadedFilePath.isDisplayed();
    }

}
