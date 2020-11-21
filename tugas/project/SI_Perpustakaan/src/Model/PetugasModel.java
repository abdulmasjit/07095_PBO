package Model;
import Entity.Petugas;
import java.util.ArrayList;

public class PetugasModel implements ModelInterfaces{
    private ArrayList<Petugas> ListPetugas;
    
    public PetugasModel(){
        ListPetugas = new ArrayList<>();
    }
    
    public ArrayList<Petugas> getListPetugas(){
       return ListPetugas;
    }
    
    @Override
    public void view() {
        // View
    }

    @Override
    public void insert(Object x) {
        ListPetugas.add((Petugas) x);
    }

    @Override
    public void update(int index, Object x) {
        ListPetugas.set(index ,(Petugas) x);
    }

    @Override
    public void delete(int index) {
        ListPetugas.remove(index);
    }
    
    @Override
    public void get_where(int index) {
        ListPetugas.get(index);
    }
}
