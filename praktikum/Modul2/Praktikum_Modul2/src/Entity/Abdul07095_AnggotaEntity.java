package Entity;
public class Abdul07095_AnggotaEntity extends Abdul07095_WargaPerpus{
    private int jenisAnggota;
    
    // Constructor    
    public Abdul07095_AnggotaEntity(String no_id, String nama, String no_telp, int jenisAnggota){
        super(no_id, nama, no_telp);
        this.jenisAnggota = jenisAnggota;
    }
    
    // Setter / Mutator   
    public void setJenisAnggota(int jenisAnggota){
        this.jenisAnggota = jenisAnggota;
    }
    
    // Selector / Getter
    @Override
    public String getNoId(){
        return this.no_id;
    }
    
    public int getJenisAnggota(){
        return this.jenisAnggota;
    }
}
