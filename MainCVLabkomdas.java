import java.util.Scanner; //import kelas scanner
//deklarasi kelas
public class MainCVLabkomdas {
    //main method
    public static void main(String[] args) {
        //object untuk membaca input dari user
        Scanner input = new Scanner(System.in);
        //object untuk memanggil method di kelas CVLabkomdas
        CVLabkomdas transaksi = new CVLabkomdas();
        //saat nilai isLanjut() true, akan loop terus
        while (transaksi.isLanjut()) {
            transaksi.menu(input); //memanggil menu
        }
    }
}
