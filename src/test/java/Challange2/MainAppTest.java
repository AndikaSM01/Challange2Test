package Challange2;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;


public class MainAppTest {
private Menu menu;
private Order order;
private ProductName produk;
 MainApp mainApp;
 @BeforeEach
 public void init(){
     order = new Order();
     mainApp = new MainApp();
 }
 @AfterEach
 public void tearDown(){
     mainApp= null;
 }


   @Test
   void testTambahPesanan(){
     order.tambahPesanan(2,10000);
    Assertions.assertEquals(20000, order.getTotalHarga());
    }


    @Test
    void testTampilanMainScreen(){
     String input = "1";
   // mainApp.TampilanMainScreen(99, false);
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    Assertions.assertFalse(mainApp.TampilanMainScreen(99, false));



    }

}



