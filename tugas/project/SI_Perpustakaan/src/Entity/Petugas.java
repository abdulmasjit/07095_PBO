package Entity;
public class Petugas extends WargaPerpus{
    private String password;
    
    public Petugas(String no_id, String nama, String alamat, String no_telp, String password){
        super(no_id, nama, alamat, no_telp);
        this.password = password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    @Override
    public String getNoId(){
        return this.no_id;
    }
    
    public String getPassword(){
        return this.password;
    }
}
