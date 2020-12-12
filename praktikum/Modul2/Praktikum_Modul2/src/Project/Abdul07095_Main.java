package Project;
import Entity.*;
import Model.*;
import java.util.Scanner;

public class Abdul07095_Main {
    Scanner input = new Scanner(System.in);
    Abdul07095_AnggotaModel anggota_m = new Abdul07095_AnggotaModel();
    Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    
    public static void main(String[] args) {
        Abdul07095_Main app = new Abdul07095_Main();
        System.out.println("Selamat Datang Di Sistem Informasi Perpustakaan !!");
        app.viewMenu();
    }
    
    void viewMenu(){
        int pil;
        do{
            System.out.println("=== Menu Navigation ====");
            System.out.println("1. Tambah Anggota");
            System.out.println("2. Lihat Anggota");
            System.out.println("3. Ubah Anggota");
            System.out.println("4. Hapus Anggota");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    add();
                    break;
                case 2 :
                    anggota_m.view();
                    break;
                case 3 : 
                    edit();
                    break;
                case 4 : 
                    delete();
                    break;
            }
        }while (pil!=0);
    }
    
    void add(){
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
        anggota_m.insert(new Abdul07095_AnggotaEntity(no_id, nama, no_telp, jenis));
        System.out.print("Data Anggota Berhasil Disimpan !!\n");
    }
    
    void edit(){
        if(anggota_m.getListAnggota().size()>0){
            for (int i = 0; i < anggota_m.getListAnggota().size(); i++) {
                System.out.println("["+i+"] "+anggota_m.getListAnggota().get(i).getNama());
            }
            System.out.print("Pilih Index Anggota : ");
            int selectIndex = input.nextInt();

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

            anggota_m.update(selectIndex, new Abdul07095_AnggotaEntity(no_id, nama, no_telp, jenis));
            System.out.print("Data Anggota Berhasil Diubah !!\n");
        }else{
            System.out.println("Data Anggota Kosong\n");
        }
    }
    
    void delete(){
        if(anggota_m.getListAnggota().size()>0){
            for (int i = 0; i < anggota_m.getListAnggota().size(); i++) {
                System.out.println("["+i+"] "+anggota_m.getListAnggota().get(i).getNama());
            }
            
            System.out.print("Pilih Index Anggota : ");
            int selectIndex = input.nextInt();

            anggota_m.delete(selectIndex);
            System.out.print("Data Anggota Berhasil Dihapus !!\n");
        }else{
            System.out.println("Data Anggota Kosong\n");
        }
    }
}
