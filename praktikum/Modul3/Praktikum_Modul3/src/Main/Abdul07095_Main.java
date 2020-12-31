package Main;
import Entity.*;
import Controller.*;
import java.util.Scanner;

public class Abdul07095_Main {
    Scanner input = new Scanner(System.in);
    Abdul07095_AnggotaController anggota_c = new Abdul07095_AnggotaController();
    Abdul07095_BukuController buku_c = new Abdul07095_BukuController();
    Abdul07095_PeminjamanController pinjam_c = new Abdul07095_PeminjamanController();
    Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    
    public static void main(String[] args) {
        Abdul07095_Main app = new Abdul07095_Main();
        System.out.println("Selamat Datang Di Sistem Informasi Perpustakaan !!");
        app.viewMenu();
    }
    
    // =================================== Menu Navagation =====================================
    public void viewMenu(){
        int pil;
        do{
            System.out.println("=== Menu Utama ====");
            System.out.println("1. Anggota");
            System.out.println("2. Daftar Buku");
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
                    viewBuku();
                    break;
                case 3 : 
                    menuPeminjaman();
                    break;
                case 4 : 
                    System.out.println("Pengembalian");
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
                    System.out.println("Menu Daftar Peminjaman");
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
    }
    
    // =================================== Buku =====================================
    public void viewBuku(){
        buku_c.dataBukuSementara();
        if(buku_c.viewBuku().size()>0){
            for(int i = 0; i < buku_c.viewBuku().size(); i++){
                System.out.println("Kode Buku : "+buku_c.viewBuku().get(i).getKodeBuku()
                                   +"\nJuduk : "+buku_c.viewBuku().get(i).getJudulBuku()
                                   +"\nPengarang : "+buku_c.viewBuku().get(i).getPengarang()
                                   +"\nTahun Terbit : "+buku_c.viewBuku().get(i).getTahunTerbit()
                                   +"\nStok : "+buku_c.viewBuku().get(i).getStok()
                );
                System.out.println("======================================================");
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
        if(cekAnggota==-1){
            System.out.println("Ooops, Anggota tidak ditemukan ! ");
        }else{
            System.out.println("Nama Anggota : "+anggota_c.getDetail(cekAnggota).getNama());
            System.out.println("=========================================");                
            // Cek Tanggungan Peminjaman            
            int cekPeminjaman = pinjam_c.cekPeminjamanAnggota(noId, "0");
            if(cekPeminjaman != -1){
                System.out.println("Ooops, Anggota masih mempunyai tanggungan peminjaman ! ");
            }else{
                // Pengecekan Buku
                String ulang = "";
                int cekBuku;
                do{
                    System.out.print("Masukan Kode Buku : ");
                    String kodeBuku = input.next();
                    cekBuku = buku_c.cari(kodeBuku);
                    if(cekBuku == -1){
                        System.out.println("Ooops, Buku tidak ditemukan ! ");
                        System.out.print("Cari buku lagi (y/t) ? ");
                        ulang = input.next();
                    }else{
                        ulang = "t";
                    }
                }while (ulang.equals("y") || ulang.equals("Y"));
            }
            // Selanjutnya tinggal input tgl dan jumlah
            // lalu cetak peminjaman (view)
            // Simpan
        }
    }
    
    public void viewListPeminjaman(){
        
    }
}
