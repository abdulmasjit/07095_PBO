package Entity;
public abstract class WargaPerpus {
    protected String no_id, nama, no_telp;
    public WargaPerpus(String no_id, String nama, String no_telp){
        this.no_id = no_id;
        this.nama = nama;
        this.no_telp = no_telp;
    }
    public WargaPerpus(){}
    
    public void setNoId(String no_id){
        this.no_id = no_id;
    }
    public void setNama(String nama){
        this.nama = nama;
    }
    public void setNoTelp(String no_telp){
        this.no_telp = no_telp;
    }
    
    public String getNoId(){
        return this.no_id;
    }
    public String getNama(){
        return this.nama;
    } 
    public String getNoTelp(){
        return this.no_telp;
    } 
}
