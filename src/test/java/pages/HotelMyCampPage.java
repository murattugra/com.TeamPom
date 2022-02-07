package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class HotelMyCampPage {

     public HotelMyCampPage(){

      PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//a[text()='Log in']")
    public WebElement ilkLoginLinki;

    @FindBy(xpath = "//input[@id='UserName']")
    public WebElement usernameBox;

    @FindBy(xpath = "//input[@id='Password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//input[@id='btnSubmit']")
    public WebElement loginButonu;

    @FindBy(xpath = "//span[.='Try again please']")
    public WebElement gecersizGirisYazisi;

    @FindBy(xpath = "(//div[@class='row'])[2]")
    public WebElement loginCercevesi;

    @FindBy(xpath = "//span[.='Hotel Management']")
    public WebElement hotelMangementButton;

    @FindBy(xpath = "//a[@href='/admin/HotelRoomAdmin']")
    public WebElement hotelRoomsButton;

    @FindBy(xpath = "//span[.='Add Hotelroom ']")
    public WebElement addHotelRoomsButton;

    @FindBy(xpath = "//select[@id='IDHotel']")
    public WebElement idHotelDropDownBox;

    @FindBy(xpath = "//select[@id='IDGroupRoomType']")
    public WebElement RoomTypeDropDownBox;

   @FindBy(xpath = "//textarea[@title='Rich Text Editor, Description']")
    public  WebElement textBox;

   @FindBy(xpath = "//button[.='Save']")
   public WebElement saveButton;

    @FindBy (xpath = "//div[text()='HotelRoom was inserted successfully']")
    public WebElement basariliKayitOnayTexti;

   @FindBy(xpath = "//button[.='OK']")
   public WebElement okButton;

   @FindBy(xpath = "//span[.='List Of Hotelrooms']")
   public WebElement listOfYazisi;

    public void girisYap(){
        Driver.getDriver().get(ConfigReader.getProperty("HMCUrl"));
        ilkLoginLinki.click();
        usernameBox.sendKeys(ConfigReader.getProperty("HMCValidUsername"));
        passwordBox.sendKeys(ConfigReader.getProperty("HMCValidPassword"));
        loginButonu.click();

    }

}
