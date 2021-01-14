package Entity;
public class Abdul07095_AnggotaEntity extends Abdul07095_WargaPerpus{
    private int jenisAnggota;
    
    // Constructor    
    public Abdul07095_AnggotaEntity(String no_id, String nama, String no_telp, int jenisAnggota){
        super(no_id, nama, no_telp);
        this.jenisAnggota = jenisAnggota;
    }
    
    public Abdul07095_AnggotaEntity(){
    
    }
    
    // Setter / Mutator   
    public void setJenisAnggota(int jenisAnggota){
        this.jenisAnggota = jenisAnggota;
    }
    
    
    public int getJenisAnggota(){
        return this.jenisAnggota;
    }
}
