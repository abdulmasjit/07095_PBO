package Entity;
public class Petugas extends WargaPerpus{
    private String username, password;
    
    // Constructor    
    public Petugas(String no_id, String nama, String no_telp, String username, String password){
        super(no_id, nama, no_telp);
        this.username = username;
        this.password = password;
    }
    
    public Petugas(){
    
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
