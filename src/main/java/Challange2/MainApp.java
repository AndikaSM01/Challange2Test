package Challange2;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.FileWriter;

    public class MainApp {
        private Scanner scanner;
        private Menu daftarMenu;
        private Order pesanan;

        public MainApp() {
            scanner = new Scanner(System.in);
            daftarMenu = new Menu();
            pesanan = new Order();
        }

        public void tampilanMain() {
            try{
            boolean exit = false;

            while (!exit) {

                    daftarMenu.tampilanPilihanMenu();
                    System.out.print("=> ");
                    int pilihan = scanner.nextInt();
            exit = TampilanMainScreen(pilihan, exit);

                }
            }catch(InputMismatchException ime){

                System.out.println("Input harus angka/numeric");

            }
            scanner.close();
        }
        public boolean TampilanMainScreen(int pilihan, boolean exit){
            switch (pilihan) {
                case 99:
                    konfirmasiDanPembayaran();
                    break;
                case 0:
                    System.out.println("Terima kasih telah berkunjung ");
                    exit = true;
                    break;
                default:
                    if (pilihan >= 1 && pilihan <= daftarMenu.JumlahMenu) {
                        tampilanPesanan(pilihan);
                    } else {
                        tampilkanKesalahan("Nomor yang dimasukan tidak sesuai");
                    }
                    break;
            }
            return exit;
        }
        public void tampilanPesanan(int nomorMenu) {
            System.out.println("========================");
            System.out.println("Berapa pesanan anda");
            System.out.println("========================");
            System.out.println();

            ProductName menu = daftarMenu.getMenu(nomorMenu - 1);
            System.out.println(menu.getName() + "\t\t| " + menu.getPrice());
            System.out.println("(Input 0 untuk kembali)");
            System.out.print("qty => ");

            int jumlah = scanner.nextInt();

            if (jumlah > 0) {
                menu.setTotalPesanan(jumlah);
                pesanan.tambahPesanan(jumlah, menu.getPrice());
            } else {
                tampilkanKesalahan("Pesanan Tidak sesuai!");
            }
            System.out.println(" ");
        }

        public void konfirmasiDanPembayaran() {
            int jumlahPesananTotal = 0;

            System.out.println("========================");
            System.out.println("Konfirmasi dan Pembayaran");
            System.out.println("========================");

            for (int i = 0; i < daftarMenu.JumlahMenu; i++) {
                ProductName menu = daftarMenu.getMenu(i);
                int jumlahPesanan = menu.getTotalPesanan();

                if (jumlahPesanan > 0) {
                    int subtotal = menu.getPrice() * jumlahPesanan;

                    System.out.println(menu.getName() + "\t" + jumlahPesanan + "\tRp. " + subtotal);
                }
                jumlahPesananTotal += jumlahPesanan;
            }
            boolean exit = false;

            while (!exit) {

                System.out.println("------------------------");
                System.out.println("Total\t\t" +jumlahPesananTotal + "\tRp. " + pesanan.getTotalHarga());
                System.out.println("1. Konfirmasi dan Bayar");
                System.out.println("2. Kembali ke menu utama");
                System.out.println("0. Keluar aplikasi");
                System.out.print("=> ");

                int pilihan = scanner.nextInt();

                switch (pilihan) {
                    case 1:
                        tampilanStrukPembayaran();
                        tampilanCetakStruk();
                        exit = true;
                        break;
                    case 2:


                        System.out.println("Terima kasih Telah Berkunjung!");
                        System.exit(0);
                        break;
                    default:
                        tampilkanKesalahan("Nomor yang anda masukan tidak sesuai");
                        break;
                }
            }
        }

        public void tampilanCetakStruk() {
            int jumlahPesananTotal = 0;
            try {

                FileWriter fileWriter = new FileWriter("receipt.txt");
                fileWriter.write("========================\n");
                fileWriter.write(" BinarFud");
                fileWriter.write("========================\n");
                fileWriter.write(" ");
                fileWriter.write("Terima Kasih sudah Memesan");
                fileWriter.write("di BinarFud");
                fileWriter.write(" ");
                fileWriter.write("Dibawah ini adalah pesanan anda");


                for (int i = 0; i < daftarMenu.JumlahMenu; i++) {
                    ProductName menu = daftarMenu.getMenu(i);
                    int jumlahPesanan = menu.getTotalPesanan();

                    if (jumlahPesanan > 0) {
                        int subtotal = menu.getPrice() * jumlahPesanan;
                        fileWriter.write(menu.getName() + "\t" + jumlahPesanan + "\tRp. " + subtotal + "\n");
                    }
                    jumlahPesananTotal += jumlahPesanan;
                }

                fileWriter.write("------------------------+\n");
                fileWriter.write("Total\t\t" + jumlahPesananTotal + "\tRp " + pesanan.getTotalHarga() + "\n\n");
                fileWriter.write("Pembayaran : BinarCash\n");
                fileWriter.write("========================\n");
                fileWriter.write("Simpan struk ini sebagai");
                fileWriter.write("bukti Pembayaran");
                fileWriter.write("========================\n");
                fileWriter.close();

            } catch (IOException e) {
                tampilkanKesalahan(e.getMessage());
            }
        }

        public void tampilanStrukPembayaran() {
            int jumlahPesananTotal = 0;

            System.out.println("===============================");
            System.out.println("BinarFud");
            System.out.println("===============================");
            System.out.println(" ");
            System.out.println("Terima Kasih sudah memesan\t");
            System.out.println("di BinarFud");
            System.out.println(" ");
            System.out.println("Dibawah ini adalah pesanan anda");

            for (int i = 0; i < daftarMenu.JumlahMenu; i++) {
                ProductName menu = daftarMenu.getMenu(i);
                int jumlahPesanan = menu.getTotalPesanan();

                if (jumlahPesanan > 0) {
                    System.out.println(menu.getName() + "\t" + jumlahPesanan + "\tRp. " + (jumlahPesanan * menu.getPrice()));
                }
            }

            System.out.println("-------------------------------+");
            System.out.println("Total\t\t" + jumlahPesananTotal + "\tRp " + pesanan.getTotalHarga());
            System.out.println("================================");
            System.out.println("Simpan struk ini sebagai\t");
            System.out.println("bukti pembayaran");
            System.out.println("================================\n\n");

        }

        public void tampilkanKesalahan(String pesan) {
            System.out.println("Error: " + pesan);
        }

        public static void main(String[] args) {
            MainApp app = new MainApp();
            app.tampilanMain();
        }

}
