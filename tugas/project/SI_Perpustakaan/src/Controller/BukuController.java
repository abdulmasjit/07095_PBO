package Controller;
import Model.BukuModel;
import Entity.Buku;
import java.util.Scanner;

public class BukuController {
    // Instansiasi Object    
    BukuModel buku_m = new BukuModel();
    Scanner input = new Scanner(System.in);
    
    // Constructor    
    public BukuController(){
        
    }
    
    // Method    
    public void addBuku(){
        System.out.print("Input Kode Buku : ");
        String kode_buku = input.next();
        
        System.out.print("Input Judul : ");
        String judul = input.next();
        
        System.out.print("Input Pengarang : ");
        String pengarang = input.next();
        
        System.out.print("Input Tahun Terbit = ");
        String tahun_terbit = input.next();
        
        System.out.print("Input Stok = ");
        int stok = input.nextInt();
        
        // Add Object To Class Buku     
        buku_m.insert(new Buku(kode_buku, judul, pengarang, tahun_terbit, stok));
        System.out.print("Data Buku Berhasil Disimpan !!\n");
    }
    
    public void viewListBuku(){
        if(buku_m.getListBuku().isEmpty()){
            System.out.println("Data Buku Kosong\n");
        }else{
            int no = 0;
            for (int i = 0; i < buku_m.getListBuku().size(); i++) {
                no++;
                System.out.println("[Buku " + no + "]");
                System.out.println("Kode Buku    : " + buku_m.getListBuku().get(i).getKodeBuku());
                System.out.println("Judul        : " + buku_m.getListBuku().get(i).getJudul());
                System.out.println("Pengarang    : " + buku_m.getListBuku().get(i).getPengarang());
                System.out.println("Tahun Terbit : " + buku_m.getListBuku().get(i).getTahunTerbit());
                System.out.println("Stok         : " + buku_m.getListBuku().get(i).getStok());
            }
        }
    }
    
    public void editBuku(){
        if(buku_m.getListBuku().size()>0){
            for (int i = 0; i < buku_m.getListBuku().size(); i++) {
                System.out.println("["+i+"] "+buku_m.getListBuku().get(i).getJudul());
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
            
            System.out.print("Input Stok = ");
            int stok = input.nextInt();

            buku_m.update(selectIndex, new Buku(kode_Buku, judul, pengarang, tahun_terbit, stok));
            System.out.print("Data Buku Berhasil Diubah !!\n");
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
    
    public void deleteBuku(){
        if(buku_m.getListBuku().size()>0){
            for (int i = 0; i < buku_m.getListBuku().size(); i++) {
                System.out.println("["+i+"] "+buku_m.getListBuku().get(i).getJudul());
            }
            
            System.out.print("Pilih Index Buku : ");
            int selectIndex = input.nextInt();
            
            buku_m.delete(selectIndex);
            System.out.print("Data Buku Berhasil Dihapus !!\n");
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
}
