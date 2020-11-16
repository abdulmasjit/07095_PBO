package si_perpustakaan;

public class WargaPerpus {
    String no_id, nama, alamat;
    
    public WargaPerpus(String no_id, String nama, String alamat){
        this.no_id = no_id;
        this.nama = nama;
        this.alamat = alamat;
    }
    
    String getNo_id(){
        return this.no_id;
    }
    String getNama(){
        return this.nama;
    }
    String getAlamat(){
        return this.alamat;
    }
}


