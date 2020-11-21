package Controller;
import Model.PetugasModel;
import Entity.Petugas;

public class PetugasController {
    public PetugasModel petugas_m;
    
    public PetugasController() {
       petugas_m = new PetugasModel();
    }
     
    public void DataPetugas(){
        String idPetugas [] = {"001", "002", "003", "004", "005"};
        String namaPetugas [] = {"Risky", "Dian", "Bagus", "Aldo", "Sabrina"};
        String alamatPetugas [] = {"Rungkut Kidul", "Brebek", "Semolowaru", "Gunung Sari", "Wiyung"};    
        String telpPetugas [] = {"085334345051", "085334345052", "085334345053", "085334345054", "085334345055"};    
        String passwordPetugas [] = {"001", "002", "003", "004", "005"};
        
        for (int i = 0; i < idPetugas.length; i++) {
            petugas_m.insert(new Petugas(idPetugas[i], namaPetugas[i], alamatPetugas[i], telpPetugas[i], passwordPetugas[i]));
        }
    }
}
