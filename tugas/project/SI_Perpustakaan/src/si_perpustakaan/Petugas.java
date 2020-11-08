package si_perpustakaan;

public class Petugas {
   // Attribut    
    String id_petugas, nama, alamat, password;
    
    // Constructor
    public Petugas(String id_petugas, String nama, String alamat, String password){
        this.id_petugas = id_petugas;
        this.nama = nama;
        this.alamat = alamat;
        this.password = password;
    }
    
    // Accessor
    String getIdPetugas(){
        return this.id_petugas;
    }
    
    String getNama(){
        return this.nama;
    }
    
    String getAlamat(){
        return this.alamat;
    }
    
    String getPassword(){
        return this.password;
    }
}
