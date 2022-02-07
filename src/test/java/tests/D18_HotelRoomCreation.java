package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.security.Key;

public class D18_HotelRoomCreation {



    //1. Tests packagenin altına class olusturun: D18_HotelRoomCreation
    // 2. Bir metod olusturun: RoomCreateTest()

    @Test
    public void RoomCreateTest() throws InterruptedException {
        // 3.https://www.hotelmycamp.com/ adresine gidin.
        // 4. Username textbox ve password metin kutularını locate edin
        // ve aşağıdaki verileri girin. a. Username : manager b. Password : Manager1!
        // 5. Login butonuna tıklayın.
        HotelMyCampPage hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampPage.girisYap();
        // 6. Hotel Management menusunden Add Hotelroom butonuna tıklayın.

        hotelMyCampPage.hotelMangementButton.click();
        hotelMyCampPage.hotelRoomsButton.click();
        hotelMyCampPage.addHotelRoomsButton.click();


        // 7. Açılan sayfadaki tüm metin kutularına istediğiniz verileri girin.
        // 8. Save butonuna basin.
        Select select=new Select(hotelMyCampPage.idHotelDropDownBox);
        select.selectByVisibleText("Murat");
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();
        actions.sendKeys(Keys.TAB).sendKeys(faker.code().asin())
                .sendKeys(Keys.TAB).sendKeys(faker.name().name())
                .sendKeys(Keys.TAB).sendKeys(faker.address().city()).sendKeys(Keys.PAGE_DOWN).perform();

                actions.click(hotelMyCampPage.textBox).sendKeys("merhaba").
                sendKeys(Keys.TAB).sendKeys("300").perform();
        Select select1=new Select(hotelMyCampPage.RoomTypeDropDownBox);
        select1.selectByIndex(3);
        actions.sendKeys(Keys.TAB).sendKeys("2").sendKeys(Keys.TAB).sendKeys("2")
                .perform();

        hotelMyCampPage.saveButton.click();

        // 9. “HotelRoom was inserted successfully” textinin göründüğünü test edin.
        Assert.assertTrue(hotelMyCampPage.basariliKayitOnayTexti.isDisplayed());
        Thread.sleep(3000);
        // 10. OK butonuna tıklayın.
        hotelMyCampPage.okButton.click();
        // 11. Hotel rooms linkine tıklayın.
        hotelMyCampPage.hotelRoomsButton.click();
        // 12. "LIST OF HOTELROOMS" textinin göründüğünü doğrulayın..
        Assert.assertTrue(hotelMyCampPage.listOfYazisi.isDisplayed());
        hotelMyCampPage.okButton.click();


        Thread.sleep(10000);
      Driver.closeDriver();

    }
}
