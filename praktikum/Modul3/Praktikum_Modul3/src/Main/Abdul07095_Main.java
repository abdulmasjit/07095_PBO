package Main;
import Entity.*;
import Controller.*;
import java.util.Date;
import java.util.Scanner;

public class Abdul07095_Main {
    Scanner input = new Scanner(System.in);
    Abdul07095_AnggotaController anggota_c = new Abdul07095_AnggotaController();
    Abdul07095_BukuController buku_c = new Abdul07095_BukuController();
    Abdul07095_PeminjamanController pinjam_c = new Abdul07095_PeminjamanController();
    Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    String [] statusPeminjaman = {"Belum Dikembalikan", "Dikembalikan"};
    
    public static void main(String[] args) {
        Abdul07095_Main app = new Abdul07095_Main();
        System.out.println("Selamat Datang Di Sistem Informasi Perpustakaan !!");
        app.viewMenu();
    }
    
    // =================================== Menu Navagation =====================================
    public void viewMenu(){
        anggota_c.dataAnggotaSementara();
        buku_c.dataBukuSementara();
        int pil;
        do{
            System.out.println("=== Menu Utama ====");
            System.out.println("1. Anggota");
            System.out.println("2. Buku");
            System.out.println("3. Peminjaman");
            System.out.println("4. Pengembalian");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    menuAnggota();
                    break;
                case 2 :
                    menuBuku();
                    break;
                case 3 : 
                    menuPeminjaman();
                    break;
                case 4 : 
                    pengembalian();
                    break;
            }
        }while (pil!=0);
    }
    
    public void menuAnggota(){
        int pil;
        do{
            System.out.println("=== Menu Anggota ====");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Daftar Anggota");
            System.out.println("0. Menu Utama");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    addAnggota();
                    break;
                case 2 :
                    viewAnggota();
                    break;
            }
        }while (pil!=0);
    }
    
     public void menuBuku(){
        int pil;
        do{
            System.out.println("=== Menu Buku ====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Daftar Buku");
            System.out.println("0. Menu Utama");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    addBuku();
                    break;
                case 2 :
                    viewBuku();
                    break;
            }
        }while (pil!=0);
    }
    
    public void menuPeminjaman(){
        int pil;
        do{
            System.out.println("=== Menu Peminjaman ====");
            System.out.println("1. Peminjaman");
            System.out.println("2. Daftar Peminjaman");
            System.out.println("0. Menu Utama");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    peminjaman();
                    break;
                case 2 :
                    viewListPeminjaman();
                    break;
            }
        }while (pil!=0);
    }
    
    // =================================== Anggota =====================================
    public void viewAnggota(){
        if(anggota_c.viewAnggota().size()>0){
            for(int i = 0; i < anggota_c.viewAnggota().size(); i++){
                System.out.println("No ID : "+anggota_c.viewAnggota().get(i).getNoId()
                                   +"\nNama : "+anggota_c.viewAnggota().get(i).getNama()
                                   +"\nNo.Telp : "+anggota_c.viewAnggota().get(i).getNoTelp()
                                   +"\nJenis Anggota : "+ja.jenisAnggota[anggota_c.viewAnggota().get(i).getJenisAnggota()]
                );
                System.out.println("======================================================");
            }
        }else{
            System.out.println("Data Anggota Kosong\n");
        }
    }
    
    public void addAnggota(){
        try {
            System.out.print("Input No ID : ");
            String no_id = input.next();

            System.out.print("Input Nama : ");
            String nama = input.next();

            System.out.print("Input No Telp : ");
            String no_telp = input.next();

            for (int i = 0; i < ja.jenisAnggota.length; i++) {
                System.out.println("["+i+"] "+ja.jenisAnggota[i]);
            }
            System.out.print("Pilih Jenis Anggota = ");
            int jenis = input.nextInt();

            // Add Object To Class   
            anggota_c.insertAnggota(no_id, nama, no_telp, jenis);
            System.out.print("Data Anggota Berhasil Disimpan !!\n");
        } catch (Exception e) {
            System.out.print("Simpan Anggota Gagal !!\n");
        }
    }
    
    // =================================== Buku =====================================
    public void addBuku(){
        try {
            System.out.print("Input Kode Buku : ");
            String kodeBuku = input.next();

            System.out.print("Input Judul : ");
            String judul = input.next();

            System.out.print("Input Pengarang : ");
            String pengarang = input.next();
            
            System.out.print("Input Tahun Terbit : ");
            String tahunTerbit = input.next();
            
            System.out.print("Input Stok : ");
            int stok = input.nextInt();

            // Add Object To Class   
            buku_c.insertBuku(kodeBuku, judul, pengarang, tahunTerbit, stok);
            System.out.print("Data Buku Berhasil Disimpan !!\n");
        } catch (Exception e) {
            System.out.print("Simpan Buku Gagal !!\n");
        }
    }
    
    public void viewBuku(){
        if(buku_c.viewBuku().size()>0){
            for(int i = 0; i < buku_c.viewBuku().size(); i++){
                System.out.println("Kode Buku : "+buku_c.viewBuku().get(i).getKodeBuku()
                                   +"\nJuduk : "+buku_c.viewBuku().get(i).getJudulBuku()
                                   +"\nPengarang : "+buku_c.viewBuku().get(i).getPengarang()
                                   +"\nTahun Terbit : "+buku_c.viewBuku().get(i).getTahunTerbit()
                                   +"\nStok : "+buku_c.viewBuku().get(i).getStok()
                );
                System.out.println("------------------------------------------------------------");
            }
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
    
    // =================================== Peminjaman =====================================
    public void peminjaman(){
        System.out.print("Masukan ID Anggota : ");
        String noId = input.next();
        int cekAnggota = anggota_c.cari(noId);
        int cekBuku = -1;
        
        if(cekAnggota==-1){
            System.out.println("Ooops, Anggota tidak ditemukan ! ");
        }else{
            System.out.println("ID Anggota : "+anggota_c.getDetail(cekAnggota).getNoId());
            System.out.println("Nama Anggota : "+anggota_c.getDetail(cekAnggota).getNama());
            System.out.println("-------------------------------------------------------------------------------");                
            // Cek Tanggungan Peminjaman            
            int cekPeminjaman = pinjam_c.cekPeminjamanAnggota(noId, "0");
            if(cekPeminjaman != -1){
                System.out.println("Ooops, Anggota masih mempunyai tanggungan peminjaman ! \n");
            }else{
                // Pengecekan Buku
                String ulang = "";
                do{
                    System.out.print("Masukan Kode Buku : ");
                    String kodeBuku = input.next();
                    cekBuku = buku_c.cari(kodeBuku);
                    if(cekBuku == -1){
                        System.out.println("Ooops, Buku tidak ditemukan ! ");
                        System.out.print("Cari buku lagi (y/t) ? ");
                        ulang = input.next();
                    }else{
                        System.out.println("Kode Buku   : "+buku_c.getDetail(cekBuku).getKodeBuku());
                        System.out.println("Judul Buku  : "+buku_c.getDetail(cekBuku).getJudulBuku());
                        System.out.println("Stok        : "+buku_c.getDetail(cekBuku).getStok());
                        System.out.println("-------------------------------------------------------------------------------");              
                        System.out.println("1. Lanjutkan Transaksi ");
                        System.out.println("2. Cari Buku Lagi ");
                        System.out.print("pilih : ");
                        ulang = input.next();
                        ulang = (ulang.equals("2")) ? "y" : "t";
                    }
                }while (ulang.equals("y") || ulang.equals("Y"));
                
                if(cekBuku != -1){
                    // Langkah Selanjutnya    
                    System.out.println("");
                    System.out.println("Detail Peminjaman");
                    System.out.print("Jumlah : ");
                    int jumlah = input.nextInt(); // Jumlah yang dipinjam

                    System.out.print("Tanggal Pinjam (dd/mm/yy) : ");
                    Date tglPinjam = new Date(input.next()); // input tanggal pinjam

                    System.out.print("Tanggal Kembali (dd/mm/yy) : ");
                    Date tglKembali = new Date(input.next()); // input tanggal kembali

                    // mencetak bukti peminjaman buku
                    System.out.println("");
                    System.out.println("Cetak Peminjaman");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("ID Anggota   : "+anggota_c.getDetail(cekAnggota).getNoId()+"    |    Tanggal Pinjam  : "+tglPinjam);
                    System.out.println("Nama Anggota : "+anggota_c.getDetail(cekAnggota).getNama()+"    |    Tanggal Kembali : "+tglKembali);
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("No  |  Nama buku  |  Jumlah");
                    System.out.println("-------------------------------------------------------------------------------");
                    System.out.println("1. "+" | "+buku_c.getDetail(cekBuku).getJudulBuku()+"  |  "+jumlah);
                    System.out.println("-------------------------------------------------------------------------------");

                    System.out.print("Apakah Anda ingin menyimpan peminjaman ? (y/t) ");
                    String konfirmasi = input.next();

                    if(konfirmasi.equals("y") || konfirmasi.equals("Y")){
                        // Proses Simpan Peminjaman
                        pinjam_c.insertPeminjaman(buku_c.getDetail(cekBuku), anggota_c.getDetail(cekAnggota), jumlah, tglPinjam, tglKembali);
                        System.out.println("Peminjaman berhasil disimpan !\n");
                    }else{
                        System.out.println("Peminjaman berhasil dibatalkan !\n");
                    }
                    // End Peminjaman  
                }
                          
            }
        }
    }
    
    public void viewListPeminjaman(){
        // mencetak daftar peminjaman buku
        System.out.println ("\r");
        System.out.println("Daftar Peminjaman Buku");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("No. |  Nama Anggota  |  Buku  |  Tgl Pinjam  |  Tgl Kembali  |  Status");
        System.out.println("------------------------------------------------------------------------------");
        
        if(pinjam_c.viewPeminjaman().size()>0){
            for (int i=0;i<pinjam_c.viewPeminjaman().size();i++) {
                String namaAnggota = pinjam_c.viewPeminjaman().get(i).getAnggota().getNoId()+ " - " +pinjam_c.viewPeminjaman().get(i).getAnggota().getNama(); 
                String buku = pinjam_c.viewPeminjaman().get(i).getBuku().getKodeBuku()+ " - " +pinjam_c.viewPeminjaman().get(i).getBuku().getJudulBuku(); 
                
                System.out.println(
                        (i+1)+".  |  "
                        + namaAnggota +"  |  "
                        + buku +"  |  "
                        + pinjam_c.viewPeminjaman().get(i).getTglPinjam()+"  |  "
                        + pinjam_c.viewPeminjaman().get(i).getTglKembali()+"  |  "
                        + statusPeminjaman[Integer.parseInt(pinjam_c.viewPeminjaman().get(i).getStatus())]);
                System.out.println("------------------------------------------------------------------------------");
            }
        }else{
            System.out.println("Daftar Peminjaman Kosong !\n");
        }
    }
    
    public void pengembalian(){
        System.out.print("Masukan ID Anggota : ");
        String noId = input.next();
        int cekAnggota = anggota_c.cari(noId);
        
        if(cekAnggota==-1){
            System.out.println("Ooops, Anggota tidak ditemukan ! ");
        }else{
            System.out.println("ID Anggota : "+anggota_c.getDetail(cekAnggota).getNoId());
            System.out.println("Nama Anggota : "+anggota_c.getDetail(cekAnggota).getNama());
            System.out.println("-------------------------------------------------------------------------------");                
            // Cek Tanggungan Peminjaman            
            int cekPeminjaman = pinjam_c.cekPeminjamanAnggota(noId, "0");
            if(cekPeminjaman == -1){
                System.out.println("Anggota tidak mempunyai tanggungan peminjaman ! \n");
            }else{
                // mencetak bukti peminjaman buku
                String buku = pinjam_c.getDetail(cekPeminjaman).getBuku().getKodeBuku()+ " - " +pinjam_c.getDetail(cekPeminjaman).getBuku().getJudulBuku(); 
                System.out.println("Cetak Peminjaman");
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("ID Anggota   : "+pinjam_c.getDetail(cekPeminjaman).getAnggota().getNoId()+"    |    Tanggal Pinjam  : "+pinjam_c.getDetail(cekPeminjaman).getTglPinjam());
                System.out.println("Nama Anggota : "+pinjam_c.getDetail(cekPeminjaman).getAnggota().getNama()+"    |    Tanggal Kembali : "+pinjam_c.getDetail(cekPeminjaman).getTglKembali());
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("No  |  Nama buku  |  Jumlah  |  Status");
               
                System.out.println("-------------------------------------------------------------------------------");
                System.out.println("1. "+" | "+buku+"  |  "+pinjam_c.getDetail(cekPeminjaman).getJumlah()+"  |  "+statusPeminjaman[Integer.parseInt(pinjam_c.getDetail(cekPeminjaman).getStatus())]);
                System.out.println("-------------------------------------------------------------------------------\n");
                
                // Update status
                updateStatusPeminjaman(cekPeminjaman, pinjam_c.getDetail(cekPeminjaman));
            }
        }
    }
    
    public void updateStatusPeminjaman(int index, Abdul07095_PeminjamanEntity pinjam){
        try {
            String konfirmasi;
            System.out.print("Lanjutkan transaksi pengembalian (y/t) ");
            konfirmasi = input.next();
            if(konfirmasi.equals("y") || konfirmasi.equals("Y")){
                pinjam_c.updateStatus(index, pinjam);
                System.out.println("Pengembalian buku sukses ! \n");
            }else{
                System.out.println("Pengembalian buku dibatalkan ! \n");
            }
        } catch (Exception e) {
            System.out.println("Pengembalian buku dibatalkan ! \n");
        }
    }
}
