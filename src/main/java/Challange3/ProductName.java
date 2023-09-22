package Challange2;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductName {

        private String name;

        private int price;

        private int totalPesanan;

        public ProductName(String nama, int harga) {
            this.name = nama;
            this.price = harga;
            this.totalPesanan = 0;
        }

}
