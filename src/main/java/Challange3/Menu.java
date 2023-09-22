package Challange2;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

@Builder
@Data
@AllArgsConstructor


    public class Menu {
        private ArrayList<ProductName> daftarMenu;
        int JumlahMenu;

        public Menu() {
            this.JumlahMenu = 5;
            this.daftarMenu = new ArrayList<ProductName>();

            daftarMenu.add(new ProductName("Nasi Goreng", 15000));
            daftarMenu.add(new ProductName("Mie Goreng", 13000));
            daftarMenu.add(new ProductName("Nasi + Ayam", 18000));
            daftarMenu.add(new ProductName("Es Teh Manis", 3000));
            daftarMenu.add(new ProductName("Es Jeruk\t", 5000));
        }

        public ArrayList<ProductName>getAllMenu(){
           return daftarMenu;
    }
        public void tampilanPilihanMenu() {
            System.out.println("==================================");
            System.out.println("\t Selamat Datang di BinarFud\t");
            System.out.println("==================================");

            System.out.println("Silahkan pilih makanan :");

            AtomicInteger index = new AtomicInteger(1);
            daftarMenu.forEach(val -> {
                System.out.println(index.getAndIncrement() + "." + val.getName() + "\t| " + val.getPrice());
            });

            System.out.println("99. Pesan Dan Bayar");
            System.out.println("0. Keluar Aplikasi");



        }
        List<Order.jumlahPesanan>jumlahPesananList;

        public ProductName getMenu(int i){

            return daftarMenu.get(i);
        }

}
