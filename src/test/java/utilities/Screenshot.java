package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static utilities.Driver.driver;

public class Screenshot {


     public static void webElementScreenshot(WebElement webElement) throws IOException {
        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File webElementSS=new File("target/screenshot/webelement"+tarih+".jpg");
        File geciciResim=webElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geciciResim,webElementSS);
    }

    public static  void tumSayfaScrennshot() throws IOException {
        TakesScreenshot tss=(TakesScreenshot) driver;
        String tarih=new SimpleDateFormat("yyMMddhhmmss").format(new Date());
        File tumSayfa=new File("target/screenshot/tumSayfa"+tarih+".jpg");
         File geciciresim=tss.getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(geciciresim,tumSayfa);


    }


}
