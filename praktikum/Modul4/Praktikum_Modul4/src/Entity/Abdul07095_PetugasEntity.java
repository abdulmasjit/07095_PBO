package Entity;
public class Abdul07095_PetugasEntity extends Abdul07095_WargaPerpus{
    private String username, password;
    
    // Constructor    
    public Abdul07095_PetugasEntity(String no_id, String nama, String no_telp, String username, String password){
        super(no_id, nama, no_telp);
        this.username = username;
        this.password = password;
    }
    
    public Abdul07095_PetugasEntity(){
    
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
