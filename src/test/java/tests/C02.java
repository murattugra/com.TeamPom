package tests;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HotelMyCampPage;
import pages.HotelMyCampTablePage;

public class C02 {
    HotelMyCampPage hotelMyCampPage;
    HotelMyCampTablePage hotelMyCampTablePage;

    @Test
    public void giris(){
        //● Bir class oluşturun : D18_WebTables
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://qa-environment.concorthotel.com/admin/HotelRoomAdmin adresine gidin
        //○ Username : manager ○ Password : Manager2!
        hotelMyCampPage=new HotelMyCampPage();
        hotelMyCampTablePage=new HotelMyCampTablePage();
        hotelMyCampPage.girisYap();

    }
    @Test(dependsOnMethods = "giris")
    public void table() throws InterruptedException {
        //● table( ) metodu oluşturun
        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        Thread.sleep(3000);
        System.out.println(hotelMyCampTablePage.sutunList.size());
        //○ Table’daki tum body’i ve başlıkları(headers) konsolda yazdırın.
        System.out.println(hotelMyCampTablePage.tbodyWebElement.getText());

        for (WebElement each: hotelMyCampTablePage.sutunList
             ) {
            System.out.println("Basliklar : "+each.getText());
        }



    } @Test(dependsOnMethods = "giris")
    public void printRows(){
        //● printRows( ) metodu oluşturun //tr
        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        System.out.println(hotelMyCampTablePage.satirlarList.size());
        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
          hotelMyCampTablePage.satirlarList.stream().forEach(t-> System.out.println(t.getText()));
        //○ 4.satirdaki(row) elementleri konsolda yazdırın.
        System.out.println("4. satirdaki elementler  : "+hotelMyCampTablePage.satirlarList.get(3).getText());


    } @Test(dependsOnMethods = "giris")
    public void printCells(){
        //● printCells( ) metodu oluşturun //td
        //○ table body’sinde bulunan toplam hücre(cell) sayısını bulun.
        System.out.println(hotelMyCampTablePage.hucrelerList.size());
        //○ Table body’sinde bulunan hücreleri(cells) konsolda yazdırın.
        System.out.println("Body daki tum hucreler*******************");
        hotelMyCampTablePage.hucrelerList.stream().forEach(t-> System.out.println(t.getText()));

    } @Test(dependsOnMethods = "giris")
    public void printColumns(){

        //● printColumns( ) metodu oluşturun
        //○ table body’sinde bulunan toplam sutun(column) sayısını bulun.
        System.out.println(hotelMyCampTablePage.sutunList.size()*hotelMyCampTablePage.satirlarList.size());
        //○ Table body’sinde bulunan sutunlari(column) konsolda yazdırın.
        hotelMyCampTablePage.sutunlariyazdir();
        //○ 5.column daki elementleri konsolda yazdırın.

        // 4. satirdaki 5. hucresindaki datayi yazdirin

        hotelMyCampTablePage.istenilenDatayiYazdirma(4,5);






    }



}


