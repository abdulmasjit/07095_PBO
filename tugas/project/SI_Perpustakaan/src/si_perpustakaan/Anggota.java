package si_perpustakaan;

public class Anggota extends WargaPerpus {
    public String no_telp;
    
    public Anggota(String no_id, String nama, String alamat, String no_telp){
        super(no_id, nama, alamat);
        this.no_telp = no_telp;
    }
    
    @Override 
    String getNo_id(){
        return no_id;
    }
    @Override 
    String getNama(){
        return nama;
    }
    @Override 
    String getAlamat(){
        return alamat;
    }
    String getNo_Telp(){
        return this.no_telp;
    }
}
