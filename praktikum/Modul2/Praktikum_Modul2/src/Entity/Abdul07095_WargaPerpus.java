package Entity;
public abstract class Abdul07095_WargaPerpus {
    protected String no_id, nama, no_telp;
    public Abdul07095_WargaPerpus(String no_id, String nama, String no_telp){
        this.no_id = no_id;
        this.nama = nama;
        this.no_telp = no_telp;
    }
    public Abdul07095_WargaPerpus(){}
    
    public abstract String getNoId();
    
    public void setNoId(String no_id){
        this.no_id = no_id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNoTelp(String no_telp){
        this.no_telp = no_telp;
    }
    
    public String getNama(){
        return this.nama;
    } 
    public String getNoTelp(){
        return this.no_telp;
    } 
}
