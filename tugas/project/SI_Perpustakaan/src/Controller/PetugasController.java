package Controller;
import Entity.Petugas;
import Model.PetugasModel;
import java.util.ArrayList;

/**
 *
 * @author Masjit Subekti
 */
public class PetugasController {
    PetugasModel petugas_m;

    public PetugasController() {
        petugas_m = new PetugasModel();
    }
    
    public ArrayList<Petugas> listPetugas(){
        return petugas_m.getListPetugas();
    }
    
    public void dataPetugas(){  
        String noId [] = {"US001"};
        String nama [] = {"Superadmin"};
        String noTelp [] = {"085334545054"};
        String username [] = {"superadmin"};
        String password [] = {"123456"};    
        for (int i = 0; i < noId.length; i++) {
            petugas_m.insert(new Petugas(noId[i], nama[i], noTelp[i], username[i], password[i]));
        }
    }
    
    public int getUser(String username, String password){
        int result = -1;
        if(petugas_m.getListPetugas().size()>0){
            for(int i = 0; i < petugas_m.getListPetugas().size(); i++){
                if(petugas_m.getListPetugas().get(i).getUsername().equals(username) && petugas_m.getListPetugas().get(i).getPassword().equals(password)){
                    result = i;
                    break;
                }else{
                    result = -1;
                }     
            }
        }
        return result;
    }
}
