package Entity;
public class Anggota extends WargaPerpus{
    private int jenisAnggota;
    
    // Constructor    
    public Anggota(String no_id, String nama, String no_telp, int jenisAnggota){
        super(no_id, nama, no_telp);
        this.jenisAnggota = jenisAnggota;
    }
    
    public Anggota(){
    
    }
    
    // Setter / Mutator   
    public void setJenisAnggota(int jenisAnggota){
        this.jenisAnggota = jenisAnggota;
    }
    
    
    public int getJenisAnggota(){
        return this.jenisAnggota;
    }
}
