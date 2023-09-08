package Challange2;

import java.util.ArrayList;

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
            daftarMenu.add(new ProductName("Es Jeruk", 5000));
        }

        public void tampilanPilihanMenu() {
            System.out.println("==================================");
            System.out.println("\t Selamat Datang di BinarFud\t");
            System.out.println("==================================");

            System.out.println("Silahkan pilih makanan :");

            int i = 1;
            for (int j = 0; j < JumlahMenu; j++) {
                ProductName menu = daftarMenu.get(j);
                System.out.println(i + "." + menu.getName() + "\t\t| " + menu.getPrice());
                i++;
            }

            System.out.println("99. Pesan Dan Bayar");
            System.out.println("0. Keluar Aplikasi");
        }

        public ProductName getMenu(int i){

            return daftarMenu.get(i);
        }

}
