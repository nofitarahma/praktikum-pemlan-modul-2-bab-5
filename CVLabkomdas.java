import java.util.Scanner;

public class CVLabkomdas {
    private final double jaketBahanA = 100000; //final harga jaket dengan bahan A 
    private final double jaketBahanB = 125000; //final harga jaket dengan bahan B
    private final double jaketBahanC = 175000; //final harga jaket dengan bahan C
    private int maksPanjang = 50; //untuk panjang maksimal baris biar rapi
    private int totalJaketA = 0; //inisialisasi jumlah jaket dengan bahan A
    private int totalJaketB = 0; //inisialisasi jumlah jaket dengan bahan B
    private int totalJaketC = 0; //inisialisasi jumlah jaket dengan bahan C
    private double hargaPerBiji = 0; //inisialisasi harga jaket perbijinya
    private boolean lanjut = true; //inisialisasi apakah lanjut atau ga(kalo lanjut nilainya true)
    //getter yang mengembalikan nilai variable lanjut
    public boolean isLanjut() {
        return lanjut;
    }
    //getter yang mengembalikan nilai variable totalJaketA
    public int getTotalJaketA() {
        return totalJaketA;
    }
    //getter yang mengembalikan nilai variable totalJaketB
    public int getTotalJaketB() {
        return totalJaketB;
    }
    //getter yang mengembalikan nilai variable totalJaketC
    public int getTotalJaketC() {
        return totalJaketC;
    }
    //method yang fungsinya membatasi panjang baris agar baris tidak melebihi panjang maksimalnya
    private void panjangBarisMaks(String baris){
        String[] barisKata = baris.split("\\s+"); //split memecah baris(kalimat) di setiap spasi dan disimpan di array 
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
    //method untuk menghitung total harga jaket A yang dibeli sesuai jumlahnya
    public double jaketA(int jumlah){
        //jika jumlahnya lebih dari 100
        if (jumlah > 100) {
            hargaPerBiji = 95000; //harga perbijinya berubah jadi segitu
        //jika tidak
        } else {
            hargaPerBiji = jaketBahanA; //harganya sesuai dengan harga final
        }
        return hargaPerBiji * jumlah; //mengembalikan total seluruh harga jaket
    }
    //method untuk menghitung total harga jaket B yang dibeli sesuai jumlahnya
    public double jaketB(int jumlah){
        //jika jumlahnya lebih dari 100
        if (jumlah > 100) {
            hargaPerBiji = 120000; //harganya sesuai dengan harga final
        //jika tidak
        } else {
            hargaPerBiji = jaketBahanB; //harganya sesuai dengan harga final
        }
        return hargaPerBiji * jumlah; //mengembalikan total seluruh harga jaket
    }
    //method untuk menghitung total harga jaket C yang dibeli sesuai jumlahnya
    public double jaketC(int jumlah){
        //jika jumlahnya lebih dari 100
        if (jumlah > 100) {
            hargaPerBiji = 160000; //harganya sesuai dengan harga final
        //jika tidak
        } else {
            hargaPerBiji = jaketBahanC; //harganya sesuai dengan harga final
        }
        return hargaPerBiji * jumlah; //mengembalikan total seluruh harga jaket
    }
    //method untuk menampilkan rincian transaksinya(bisa dibilang ini struknya)
    public void rincianTransaksi(){
        border1(); //menampilkan border yang ====
        System.out.println("||" + ditengah("Rincian Transaksi") + "||"); //menampilkan  judul di tengah
        border1(); //menampilkan border yang ====
        double totalSemuaTransaksi = 0; //nisialisasi total transaksi
        //jika total jaket A lebih dari 0
        if (totalJaketA > 0) {
            //inisialisasi hasil total jaket A dengan double hargaTotalA
            double hargaTotalA = jaketA(totalJaketA);
            panjangBarisMaks("-Jaket A: "); //menampilkan kata tsb
            //menampilkan sesuai format yang saya mau
            panjangBarisMaks(getTotalJaketA() + " biji x " + String.format("Rp.%,.2f", hargaPerBiji) + " = " + String.format("Rp.%,.2f", hargaTotalA));
            totalSemuaTransaksi += hargaTotalA; //total harga jaket A ditambah ke total transaksi
        }
        //jika total jaket B lebih dari 0
        if (totalJaketB > 0) {
            //inisialisasi hasil total jaket B dengan double hargaTotalB
            double hargaTotalB = jaketB(totalJaketB);
            panjangBarisMaks("- Jaket B: "); //menampilkan kata tsb
            //menampilkan sesuai format yang saya mau
            panjangBarisMaks(getTotalJaketB() + " biji x " + String.format("Rp.%,.2f", hargaPerBiji) + " = " + String.format("Rp.%,.2f", hargaTotalB));
            totalSemuaTransaksi += hargaTotalB; //total harga jaket B ditambah ke total transaksi
        }
        //jika total jaket C lebih dari 0
        if (totalJaketC > 0) {
            //inisialisasi hasil total jaket C dengan double hargaTotalC
            double hargaTotalC = jaketC(totalJaketC);
            panjangBarisMaks("- Jaket C: "); //menampilkan kata tsb
            //menampilkan sesuai format yang saya mau
            panjangBarisMaks(getTotalJaketC() + " biji x " + String.format("Rp.%,.2f", hargaPerBiji) + " = " + String.format("Rp.%,.2f", hargaTotalC));
            totalSemuaTransaksi += hargaTotalC; //total harga jaket C ditambah ke total transaksi
        }
        border2(); //menampilkan border yang ----
        panjangBarisMaks("Total Transaksi: " + String.format("Rp.%,.2f", totalSemuaTransaksi)); //menampilkan nominal total transaksi
        border2(); //menampilkan border yang ----
    }
    //method untuk melanjutkan transaksi atau tidak
    public void lanjutTransaksi(Scanner input){
        border2(); //menampilkan border yang ----
        //menampilkan pilihan lanjutkan transaksi atau tidak
        panjangBarisMaks("Lanjutkan transaksi? (ya/tidak)");
        //input dri user
        String memilih = input.nextLine();
        //jika tidak sama dengan ya dan sama dengan tidak
        if (!memilih.equalsIgnoreCase("ya") && memilih.equalsIgnoreCase("tidak")) {
            rincianTransaksi(); //memanggil method rincian transaksi
            border1(); //menampilkan border yang ====
            System.out.println("| " + ditengah("~ Terimakasih ~") + " |"); //menampilkan akhiran
            border1(); //menampilkan border yang ====
            lanjut = false; //nilai lanjut menjadi false
        //jika sama dengan ya lanjut
        } else if (memilih.equalsIgnoreCase("ya")){
            lanjut = true;
        //jika tidak
        } else{
            //menampilkan kalimat pilihan tidak valid
            panjangBarisMaks("Pilihan yang anda input tidak valid");
            lanjut = true;
        }
        //jika lanjut
        if (lanjut) {
            menu(input); //menampilkan menu
        }
    }
    //method untuk menampilkan menu
    public void menu(Scanner input){
        border1(); //menampilkan border yang ====
        System.out.println("||" + ditengah("Selamat Datang di Toko Labkomdas") + "||"); //menampilkan judul di tengah
        border1(); //menampilkan border yang ====
        border2(); //menampilkan border yang ----
        System.out.println("| " + ditengah("Produk Kami") + " |"); //menampilkan judul di tengah
        border2(); //menampilkan border yang ----
        panjangBarisMaks("1. Jaket A " + String.format("Rp.%,.2f", jaketBahanA)); //menampilkan pilihan jaket A
        panjangBarisMaks("2. Jaket B " + String.format("Rp.%,.2f", jaketBahanB)); //menampilkan pilihan jaket B
        panjangBarisMaks("3. Jaket C " + String.format("Rp.%,.2f", jaketBahanC)); //menampilkan pilihan jaket C
        border2(); //menampilkan border yang ----
        panjangBarisMaks("Masukkan pilihan produk (1/2/3): "); //menampilkan perintah memasukkan pilihan
        int pilihan = input.nextInt(); //input dari user
        //jika pilihan kurang dari 1 atau pilihan lebih dari 4
        if (pilihan < 1 || pilihan > 3) {
            border2(); //menampilkan border yang ----
            panjangBarisMaks("Pilihan yang anda input tidak valid"); //akan menampilkan pesan ini
            return;
        }
        panjangBarisMaks("Masukkan jumlah jaket yang akan anda beli: "); //menampilkan perintah memasukkan jumlah jaket yg akan dibeli
        int jumlah = input.nextInt(); //input dari user
        //jika jumlah kurang dari sama dengan 0
        if (jumlah <= 0) {
            panjangBarisMaks("Maaf angka yang anda input tidak valid"); //akan menampilkan pesan seperti ini
        }
        input.nextLine(); //mengkonsumsi new line
        //switch case untuk menampilkan pilihan yang dipilih
        switch (pilihan) {
            case 1:
                totalJaketA += jumlah; //jika memilih 1, total jaket A ditambah dengan jumlah pembelian jaket A
                jaketA(jumlah); //memanggil method jaketA
                break;
            case 2:
                totalJaketB += jumlah; //jika memilih 2, total jaket B ditambah dengan jumlah pembelian jaket B
                jaketB(jumlah); //memanggil method jaketB
                break;
            case 3:
                totalJaketC += jumlah; //jika memilih 3, total jaket C ditambah dengan jumlah pembelian jaket C
                jaketC(jumlah); //memanggil method jaketC
                break;
        }
        lanjutTransaksi(input); // memanggil method lanjutTransaksi untuk tanya apakah lanjut atau ga
    }
}
