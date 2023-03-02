package pages.data;

import org.openqa.selenium.WebDriver;
import pages.PageBase;

public class TextBoxData extends PageBase {

    public TextBoxData(WebDriver dr) {
        super(dr);
    }

    public static final String FULLNAME = "Alex";
    public static final String EMAIL = "alex@gmail.com";
    public static final String ADDRESS = "10318, Germany, Berlin, Marksburgstrasse 1";


}
