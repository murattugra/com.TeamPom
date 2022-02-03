package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.Driver;
import utilities.Screenshot;

import java.io.File;
import java.io.IOException;

public class HotelMyCampNegativeTest {


    HotelMyCampPage hotelMyCampPag;

    @Test
    public void test01() throws IOException {
        // 1 ) Bir Class olustur : NegativeTest
        //2) Bir test method olustur NegativeLoginTest()
        //https://www.hotelmycamp.com/ adresine git
        Driver.getDriver().get("https://www.hotelmycamp.com/");
        //login butonuna bas
        hotelMyCampPag=new HotelMyCampPage();
        hotelMyCampPag.ilkLoginLinki.click();
        //test data username: manager1 ,
        hotelMyCampPag.usernameBox.sendKeys("manager1");
        //test data password : manager1!
        hotelMyCampPag.passwordBox.sendKeys("manager1!");
        hotelMyCampPag.loginButonu.click();
        //Degerleri girildiginde sayfaya girilemedigini test et
        Assert.assertTrue(hotelMyCampPag.gecersizGirisYazisi.isDisplayed());
        Screenshot.webElementScreenshot(hotelMyCampPag.loginCercevesi);
        Screenshot.tumSayfaScrennshot();

    }

}
