package Model;
import Entity.Petugas;
import java.util.ArrayList;

public class PetugasModel{
    private ArrayList<Petugas> listPetugas;
    
    public PetugasModel(){
        listPetugas = new ArrayList<>();
    }
    
    public ArrayList<Petugas> getListPetugas(){
       return listPetugas;
    }
    
    public void insert(Object x) {
        listPetugas.add((Petugas) x);
    }
}
