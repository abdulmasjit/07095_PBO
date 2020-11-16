package si_perpustakaan;

public class Guru extends Anggota {
    private int denda_guru;
    
    public Guru(String no_id, String nama, String alamat, String no_telp, int denda_guru){
        super(no_id, nama, alamat,no_telp);
        this.denda_guru = denda_guru;
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
    @Override
    String getNo_Telp(){
        return this.no_telp;
    }
    int getDendaSiswa(){
        return this.denda_guru;
    }
}
