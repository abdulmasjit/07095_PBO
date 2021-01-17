package Controller;
import Entity.Abdul07095_PetugasEntity;
import Model.Abdul07095_PetugasModel;
import java.util.ArrayList;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_PetugasController {
    Abdul07095_PetugasModel petugas_m;

    public Abdul07095_PetugasController() {
        petugas_m = new Abdul07095_PetugasModel();
    }
    
    public ArrayList<Abdul07095_PetugasEntity> listPetugas(){
        return petugas_m.getListPetugas();
    }
    
    public void dataPetugas(){  
        String noId [] = {"US001"};
        String nama [] = {"Superadmin"};
        String noTelp [] = {"085334545054"};
        String username [] = {"superadmin"};
        String password [] = {"123456"};    
        for (int i = 0; i < noId.length; i++) {
            petugas_m.insert(new Abdul07095_PetugasEntity(noId[i], nama[i], noTelp[i], username[i], password[i]));
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
