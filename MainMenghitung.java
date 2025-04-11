import java.util.Scanner; //import kelas scanner
//deklarasi kelas
public class MainMenghitung {
    //main method
    public static void main(String[] args) {
        //untuk membaca input dari user
        Scanner input = new Scanner(System.in);
        //loop agar muncul terus menunya
        while (true) {
            //memanggil menu dengan className.methodName(arguments)
            //tanpa menginstan object dari class karena menu sifatnya static
            Menghitung.menu(input); 
        }
    }
}
