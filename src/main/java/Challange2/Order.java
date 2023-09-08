package Challange2;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {

        private int jumlahPesanan;

        private int totalHarga;


        public Order() {
            this.jumlahPesanan = 0;
            this.totalHarga = 0;

        }

        public void tambahPesanan(int jumlah, int harga){

            jumlahPesanan += jumlah;
            totalHarga += (jumlah * harga);
        }

}
