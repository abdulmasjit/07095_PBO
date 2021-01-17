package Model;
import Entity.Abdul07095_PetugasEntity;
import java.util.ArrayList;

public class Abdul07095_PetugasModel{
    private ArrayList<Abdul07095_PetugasEntity> listPetugas;
    
    public Abdul07095_PetugasModel(){
        listPetugas = new ArrayList<>();
    }
    
    public ArrayList<Abdul07095_PetugasEntity> getListPetugas(){
       return listPetugas;
    }
    
    public void insert(Object x) {
        listPetugas.add((Abdul07095_PetugasEntity) x);
    }
}
