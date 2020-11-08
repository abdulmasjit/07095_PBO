package si_perpustakaan;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList <Petugas> dataPetugas = new ArrayList();
    static ArrayList <Buku> dataBuku = new ArrayList();
    static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        DataPetugas();
        int select;
        
        do{
            System.out.println("1. Login");
            System.out.println("2. Keluar");
            System.out.print("Pilih : ");
            select = input.nextInt();
            
            if(select == 1){
                System.out.println("Silahkan Login menggunakan username dan password !!");
                System.out.print("NIP/Username : ");
                String username = input.next();
                System.out.print("Password : ");
                String pass = input.next();
                login(username, pass);   
            }
        }while (select != 2);
    }  
    
    // Method
    static void login(String id_petugas, String password){
        boolean isLogin = false;
        int i;
        // Cek Login
        for (i = 0; i < dataPetugas.size(); i++) {
            if(id_petugas.equals(dataPetugas.get(i).getIdPetugas()) && password.equals(dataPetugas.get(i).getPassword())){
                isLogin = true;
                break;
            }else{
                isLogin = false;
            }
        }
        
        // Get Index Login        
        if(isLogin){
            System.out.println("");
            System.out.println("Selamat Datang " + dataPetugas.get(i).getNama()+ " Di Sistem Informasi Perpustakaan !!");
            viewMenu();
        }else{
            System.out.println("Username Atau Password Salah\n");
        }
    }
    
    static void viewMenu(){
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
        }while (pil!=0);
    }
    
    static void addBuku(){
        System.out.print("Input Kode Buku : ");
        String kode_buku = input.next();
        
        System.out.print("Input Judul : ");
        String judul = input.next();
        
        System.out.print("Input Pengarang : ");
        String pengarang = input.next();
        
        System.out.print("Input Tahun Terbit = ");
        String tahun_terbit = input.next();
        
        // Add Object To Class Buku     
        dataBuku.add(new Buku(kode_buku, judul, pengarang, tahun_terbit));
        System.out.print("Data Buku Berhasil Disimpan !!\n");
    }
    
    static void viewListBuku(){
        if(dataBuku.size()>0){
            int no = 0;
            for (int i = 0; i < dataBuku.size(); i++) {
                no++;
                System.out.println("[Buku " + no + "]");
                System.out.println(dataBuku.get(i).getKodeBuku());
                System.out.println(dataBuku.get(i).getJudul());
                System.out.println(dataBuku.get(i).getPengarang());
                System.out.println(dataBuku.get(i).getTahunTerbit());
            }
        }else{
            System.out.println("Data Buku Kosong");
        }
    }
    
    static void editBuku(){
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

            dataBuku.set(selectIndex, new Buku(kode_Buku, judul, pengarang, tahun_terbit));
            System.out.print("Data Buku Berhasil Diubah !!\n");
        }else{
            System.out.println("Data Buku Kosong\n");
        }
    }
    
    static void deleteBuku(){
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
    
    static void DataPetugas(){
        String idPetugas [] = {"001", "002", "003", "004", "005"};
        String namaPetugas [] = {"Risky", "Dian", "Bagus", "Aldo", "Sabrina"};
        String passwordPetugas [] = {"001", "002", "003", "004", "005"};
        String alamatPetugas [] = {"Rungkut Kidul", "Brebek", "Semolowaru", "Gunung Sari", "Wiyung"};    
        
        for (int i = 0; i < idPetugas.length; i++) {
            dataPetugas.add(new Petugas(idPetugas[i], namaPetugas[i], alamatPetugas[i], passwordPetugas[i]));
        }
    }
}
