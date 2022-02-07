package pages;

import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HotelMyCampTablePage {

    public  HotelMyCampTablePage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(xpath = "//thead//tr//th")
    public List<WebElement> sutunList;


    @FindBy(xpath = "//tbody")
    public WebElement tbodyWebElement;

    @FindBy(xpath = "//tbody//tr")
    public List<WebElement> satirlarList;

    @FindBy(xpath = "//tbody//tr/td")
    public List<WebElement> hucrelerList;


    public void sutunlariyazdir() {

        String sutunlarXpath="//tbody/tr[satir]/td[sutun]";

        WebElement sutunElement;


        for (int sutun = 1; sutun <=9 ; sutun++) {
            System.out.println(sutun+". sutun");
            for (int satir = 1; satir <=10; satir++) {
                sutunElement=Driver.getDriver().findElement(By.xpath("//tbody/tr["+satir+"]/td["+sutun+"]"));
                System.out.println(sutunElement.getText());

            }

        }

    }

    public void istenilenDatayiYazdirma(int satir, int sutun) {

        String sutunlarXpath="//tbody/tr["+satir+"]/td["+sutun+"]";

        WebElement tekDataElementi=Driver.getDriver().findElement(By.xpath(sutunlarXpath));

        System.out.println("istenen data : "+tekDataElementi.getText());


    }
}
