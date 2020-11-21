package Entity;
public abstract class WargaPerpus {
    protected String no_id, nama, alamat, no_telp;
    
    public WargaPerpus(String no_id, String nama, String alamat, String no_telp){
        this.no_id = no_id;
        this.nama = nama;
        this.alamat = alamat;
        this.no_telp = no_telp;
    }
    
    public WargaPerpus(){
       
    }
    
    public abstract String getNoId();
    
    // Setter / Mutator      
    public void setNoId(String no_id){
        this.no_id = no_id;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public void setAlamat(String alamat){
        this.alamat = alamat;
    }
    
    public void setNoTelp(String no_telp){
        this.no_telp = no_telp;
    }
    
    // Selector / Getter
    public String getNama(){
        return this.nama;
    }
    
    public String getAlamat(){
        return this.alamat;
    }
    
    public String getNoTelp(){
        return this.no_telp;
    }
}


