package praktikum_modul1;
import java.util.ArrayList;
import java.util.Scanner;
public class main {
    ArrayList <Abdul07095_BukuEntity> dataBuku = new ArrayList();
    Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        main app = new main();
        System.out.println("Selamat Datang Di Sistem Informasi Perpustakaan !!");
        app.viewMenu();
    }
    
    void viewMenu(){
        int pil;
        do{
            System.out.println("=== Menu Navigation ====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Buku");
            System.out.println("3. Ubah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("5. Keluar");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    addBuku();
                    break;
                case 2 : 
                    viewListBuku();
                    break;
                case 3 : 
                    editBuku();
                    break;
                case 4 : 
                    deleteBuku();
                    break;
            }
        }while (pil!=5);
    }
    
    void addBuku(){
        System.out.print("Input Kode Buku : ");
        String Abdul07095_kodeBuku = input.next();
        
        System.out.print("Input Judul : ");
        String Abdul07095_judul = input.next();
        
        System.out.print("Input Pengarang : ");
        String Abdul07095_pengarang = input.next();
        
        System.out.print("Input Tahun Terbit = ");
        String Abdul07095_tahunTerbit = input.next();
        
        // Add Object To Class Buku     
        dataBuku.add(new Abdul07095_BukuEntity(Abdul07095_kodeBuku, Abdul07095_judul, Abdul07095_pengarang, Abdul07095_tahunTerbit));
        System.out.print("Data Buku Berhasil Disimpan !!\n");
    }
    
    void viewListBuku(){
        if(dataBuku.size()>0){
            int no = 0;
            for (int i = 0; i < dataBuku.size(); i++) {
                no++;
                System.out.println("---[Buku " + no + "]---");
                System.out.println(dataBuku.get(i).getKodeBuku());
                System.out.println(dataBuku.get(i).getJudul());
                System.out.println(dataBuku.get(i).getPengarang());
                System.out.println(dataBuku.get(i).getTahunTerbit());
            }
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
    
    void editBuku(){
        if(dataBuku.size()>0){
            for (int i = 0; i < dataBuku.size(); i++) {
                System.out.println("["+i+"] "+dataBuku.get(i).getJudul());
            }
             
            System.out.print("Pilih Index Buku : ");
            int selectIndex = input.nextInt();
            
            // Input data            
            System.out.print("Input Kode Buku : ");
            String kode_Buku = input.next();

            System.out.print("Input Judul : ");
            String judul = input.next();

            System.out.print("Input Pengarang : ");
            String pengarang = input.next();

            System.out.print("Input Tahun Terbit = ");
            String tahun_terbit = input.next();

            dataBuku.set(selectIndex, new Abdul07095_BukuEntity(kode_Buku, judul, pengarang, tahun_terbit));
            System.out.print("Data Buku Berhasil Diubah !!\n");
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
    
    void deleteBuku(){
        if(dataBuku.size()>0){
            for (int i = 0; i < dataBuku.size(); i++) {
                System.out.println("["+i+"] "+dataBuku.get(i).getJudul());
            }
            
            System.out.print("Pilih Index Buku : ");
            int selectIndex = input.nextInt();
            
            dataBuku.remove(selectIndex);
            System.out.print("Data Buku Berhasil Dihapus !!\n");
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
}
