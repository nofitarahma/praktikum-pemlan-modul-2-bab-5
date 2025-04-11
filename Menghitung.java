import java.util.Scanner;

public class Menghitung {
    private int maksPanjang = 35;
    private int fpb;
    //method yang fungsinya membatasi panjang baris agar baris tidak melebihi panjang maksimalnya
    private void panjangBarisMaks(String baris){
        String[] barisKata = baris.split("\s+"); //split memecah baris(kalimat) di setiap spasi dan disimpan di array 
        String barisIni = ""; //inisialisasi sementara untuk menyimpan baris
        //loop untuk setiap kata yang sudah disimpan di array
        for (String kata : barisKata){
            //jika baris + kata panjangnya masih dibawah maksPanjang-1
            if ((barisIni + kata).length() <= (maksPanjang-1)) {
                //jika baris ada isinya akan ditambahkan spasi
                if (!barisIni.isEmpty()) {
                    barisIni += " ";
                }
                barisIni += kata; //kemudian kata ditambahkan ke baris
            //jika baris+kata panjangnya sudah lebih dari maksPanjang
            } else {
                System.out.println(barisIni); //cetak baris yang memenuhi maksPanjang
                barisIni = kata; //mengisi barisIni dengan kata baru
            }
        }
        System.out.println(barisIni); //cetak kata yang ada di barisIni
    }
    //method agar kalimatnya di tengah baris
    private String ditengah(String kata){
        int padding = maksPanjang - kata.length(); //buat menghitung sisa panjang baris setelah dikurangi kata
        int paddingKiri = (padding/2)-2; //ini untuk menghitung ukuran padding di sebelah kiri
        int paddingKanan = padding - paddingKiri-4; //ini untuk menghitung ukuran padding di sebelah kanan
        return " ".repeat(paddingKiri) + kata + " ".repeat(paddingKanan); //menggabungkan antara spasi sepanjang padding kiri, kata, dan padding kanan
    }
    //method untuk membuat border ==== sepanjang maksPanjang
    public void border1(){
        System.out.println("=".repeat(maksPanjang));
    }
    //method untuk membuat border ---- sepanjang maksPanjang
    public void border2(){
        System.out.println("-".repeat(maksPanjang));
    }
    //method static untuk menambah semua angka yang diinputkan
    public static void penjumlahan(double[] input){
        double hasilnya = input[0]; //inisialisasi hasil yaitu indeks ke 0 input
        for (int i = 1; i < input.length; i++){ //loop yang mulai dari indeks 1
            hasilnya += input[i]; //setiap hasilnya ditambah dengan input
        }
        ketentuanHasil(hasilnya); //memanggil method ketentuan hasil untuk menampilkan hasil sesuai format yang saya mau
    }
    //method static untuk mengurangi semua angka yang diinputkan
    public static void pengurangan(double[] input){
        double hasilnya = input[0]; //inisialisasi hasil yaitu indeks ke 0 dari input
        for (int i = 1; i < input.length; i++){ //loop yang mulai dari index ke 1
            hasilnya -= input[i]; //setiap hasilnya akan dikurangi dengan inputan
        }
        ketentuanHasil(hasilnya); //memanggil method ketentuan hasil untuk menampilkan hasil
    }
    //method perkalian untuk mengalikan semua angka yang diinputkan
    public void perkalian(double[] input){
        double hasilnya = input[0]; //inisialisasi hasil yaitu index ke 0 dari input
        for (int i = 1; i < input.length; i++){ //loop mulai dari index ke 1
            hasilnya *= input[i]; //setiap hasilnya akan dikali inputan
        }
        ketentuanHasil(hasilnya); //memanggil method untuk menampilkan hasil
    }
    //method pembagian untuk membagi angka yang diinputkan
    public void pembagian(double[] input){
        double hasilnya = input[0]; //inisialisasi hasil yaitu index ke 0 dari input
        for (int i = 1; i < input.length; i++){ //loop yang mulai dari index ke 1
            hasilnya /= input[i]; //setiap hasilnya akan dibagi dengan inputan
        }
        ketentuanHasil(hasilnya); //memanggil method untuk menampilkan hasil
    }
    //method sederhana untuk menyederhanakan sebuah pecahan
    public void sederhana(int pembilang, int penyebut){
        gcd(pembilang, penyebut); //memanggil method untuk mencari fpbnya
        pembilang /= fpb; //ini untuk menyederhanakan pembilangnya
        penyebut /= fpb; //ini untuk menyederhanakan penyebutnya
        //jika penyebut kurang dari 0 (negatif)
        if (penyebut < 0) {
            pembilang *= -1; //pembilang dikali -1
            penyebut *= -1; //penyebut dikali -1
        }
        //jika penyebutnya sama dengan 1
        if (penyebut == 1) {
            System.out.println(pembilang); //hanya menampilkan pembilang saja, contoh 2/1 = 1
        //jika tidak
        } else {
            System.out.println(pembilang + "/" + penyebut); //akan menampilkan hasil sederhanaan pecahannya
        }
    }
    //method untuk mencari faktor persekutuan terbesar dari kedua angka
    public void gcd(int i, int j){
        //loop untuk mencari fpb terjadi saat j tidak sama dengan 0
        while (j != 0) {
            //
            int k = j;
            j = i % j;
            i = k;
        }
        fpb = Math.abs(i);
    }
    //method static untuk menampilkan hasil sesuai ketentuan yang saya mau
    public static void ketentuanHasil(double hasil){
        //jika hasil tidak desimal
        if (hasil == (long) hasil) {
            System.out.println((long) hasil); //akan menampilkan bilangan bulat
        //jika tidak
        } else {
            System.out.printf("%.2f\n", hasil); //akan menampilkan hasil dengan 2 angka dibelakang koma
        }
    }
    //method untuk opsi operasi hitung
    public void operasi(Scanner input){
        border1(); //menampilkan border yang ====
        System.out.println("| " + ditengah("Operasi Hitung") + " |"); //menampilkan judul di tengah
        border1(); //menampilkan border yang ====
        panjangBarisMaks("1. Penjumlahan (+)"); //menampilkan pilihan penjumlahan
        panjangBarisMaks("2. Pengurangan (-)"); //menampilkan pilihan pengurangan
        panjangBarisMaks("3. Perkalian (x)"); //menampilkan pilihan perkalian
        panjangBarisMaks("4. Pembagian (:)"); //menampilkan pilihan pembagian
        border2(); //menampilkan border yang ----
        panjangBarisMaks("Masukkan pilihan: "); //menampilkan perintah untuk memilih
        int pilihan = input.nextInt(); //input dari user
        //jika pilihan kurang dari 1 atau pilihan lebih dari 4
        if (pilihan < 1 || pilihan > 4) {
            border2(); //menampilkan border yang ----
            panjangBarisMaks("Pilihan yang anda input tidak valid"); //akan menampilkan pesan ini
            return;
        }
        border2(); //menampilkan border yang ----
        //menampilkan perintah untuk memasukkan banyak angka yang akan di input
        panjangBarisMaks("Masukkan banyak angka yang ingin anda hitung: "); 
        int banyakAngka = input.nextInt(); //input dari user
        //jika banyak angka kurang dari 2
        if (banyakAngka < 2) {
            panjangBarisMaks("Tidak bisa, minimal mengoperasikan 2 angka"); //menampilkan pesan seperti ini
            return;
        }
        //array untuk menyimpan angka
        double[] angka  = new double[banyakAngka];
        //loop untuk input angka yang akan di hitung
        for (int i = 0; i < banyakAngka; i++){
            panjangBarisMaks("Masukkan angka nomor " + (i + 1) + ": "); //menampilkan perintah untuk memasukkan angkanya
            angka[i] = input.nextDouble(); //input dari user ditaruh di array angka
        }
        border2(); //menampilkan border yang ----
        panjangBarisMaks("Hasil: "); //menampilkan hasil
        //switch case untuk menampilkan pilihan yang dipilih
        switch (pilihan) {
            case 1:
                penjumlahan(angka); //jika memilih 1 akan memanggil method static penjumlahan
                break;
            case 2:
                pengurangan(angka); //jika memilih 2 akan memanggil method static pengurangan
                break;
            case 3:
                perkalian(angka); //jika memilih 3 akan memanggil method perkalian
                break;
            case 4:
                pembagian(angka); //jika memilih 4 akan memanggil method pembagian
                break;
        }
        border2(); //menampilkan border yang ----
    }
    //method untuk opsi menyederhanakan pecahan 
    public void menyederhanakan(Scanner input){
        border1(); //menampilkan border yang ====
        System.out.println("| " + ditengah("Menyederhanakan Pecahan") + " |"); //menampilkan judul di tengah
        border1(); //menampilkan border yang ====
        panjangBarisMaks("Masukkan angka dari pembilangnya: "); //menampilkan perintah masukkan pembilang
        int pembilang = input.nextInt(); //input dari user
        panjangBarisMaks("Masukkan angka dari penyebutnya : "); //menampilkan perintah masukkan penyebutnya
        int penyebut = input.nextInt(); //input dari user
        border2(); //menampilkan border yang ----
        //jika penyebutnya sama dengan 0
        if (penyebut == 0) {
            panjangBarisMaks("Penyebut tidak boleh sama dengan 0"); //menampilkan pesan seperti ini
        //jika tidak
        } else {
            panjangBarisMaks("Hasil Penyederhanaan:"); //menampilkan hasilnya
            sederhana(pembilang, penyebut); //memanggil method sederhana untuk menampilkan hasil sederhanaan
        }
    }
    //method untuk menampilkan menu
    public static void menu(Scanner input){
        //buat object supaya bisa memanggil method yang non static
        Menghitung menu = new Menghitung();
        menu.border1(); //menampilkan border yang ====
        System.out.println("||" + menu.ditengah("Menu") + "||"); //menampilkan judul ditengah
        menu.border1(); //menampilkan border yang ====
        menu.panjangBarisMaks("1. Operasi +, -, x, :"); //menampilkan pilihan operasi hitung
        menu.panjangBarisMaks("2. Menyederhanakan Pecahan"); //menampilkan pilihan penyederhanaan pecahan
        menu.border2(); //menampilkan border yang ----
        menu.panjangBarisMaks("Masukkan pilihan: "); //menampilkan perintah untuk memilih menu
        int pilihan = input.nextInt(); //input dari user
        menu.border2(); //menampilkan border yang ----
        //switch case untuk menampilkan pilihan yang dipilih
        switch (pilihan) {
            case 1:
                menu.operasi(input); //jika memasukkan 1 akan memanggil method operasi
                break;
            case 2:
                menu.menyederhanakan(input); //jika memasukkan 2 akan memanggil method menyederhanakan
                break;
            default:
                menu.panjangBarisMaks("Pilihan yang anda input tidak valid"); //jika memilih yang lain akan menampilkan pesan ini
                break;
        }
    }
}
