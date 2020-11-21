package si_perpustakaan;
import Controller.*;
import java.util.Scanner;

public class Main {
    BukuController buku = new BukuController();
    PetugasController petugas = new PetugasController();
    Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        Main app = new Main();
        app.menu_awal();
    }  
    
    public void menu_awal(){
        petugas.DataPetugas();
        int select;
        
        do{
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Pilih : ");
            select = input.nextInt();
            
            if(select == 1){
                System.out.println("Silahkan Login menggunakan username dan password !!");
                System.out.print("ID/Username : ");
                String username = input.next();
                System.out.print("Password : ");
                String pass = input.next();
                login(username, pass);   
            }
        }while (select != 2);
    }
    
    // Method
    public void login(String id_petugas, String password){
        boolean isLogin = false;
        int i;
        // Cek Login
        for (i = 0; i < petugas.petugas_m.getListPetugas().size(); i++) {
            if(id_petugas.equals(petugas.petugas_m.getListPetugas().get(i).getNoId()) && password.equals(petugas.petugas_m.getListPetugas().get(i).getPassword())){
                isLogin = true;
                break;
            }else{
                isLogin = false;
            }
        }
        
        // Get Index Login        
        if(isLogin){
            System.out.println("");
            System.out.println("Selamat Datang " + petugas.petugas_m.getListPetugas().get(i).getNama()+ " Di Sistem Informasi Perpustakaan !!");
            viewMenu();
        }else{
            System.out.println("Username Atau Password Salah\n");
        }
    }
    
    public void viewMenu(){
        int pil;
        do{
            System.out.println("=== Menu Navigation ====");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Buku");
            System.out.println("3. Ubah Buku");
            System.out.println("4. Hapus Buku");
            System.out.println("0. Keluar");
            System.out.print("Pilih : ");
            pil = input.nextInt();

            switch(pil){
                case 1 :
                    buku.addBuku();
                    break;
                case 2 : 
                    buku.viewListBuku();
                    break;
                case 3 : 
                    buku.editBuku();
                    break;
                case 4 : 
                    buku.deleteBuku();
                    break;
            }
        }while (pil!=0);
    }
}
