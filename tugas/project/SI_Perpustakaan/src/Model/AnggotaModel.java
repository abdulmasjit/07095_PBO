package Model;
import Entity.Anggota;
import java.util.ArrayList;

public class AnggotaModel implements ModelInterfaces{
    private ArrayList<Anggota> listAnggota;
    
    public AnggotaModel(){
        listAnggota = new ArrayList<>();
    }
    
    public ArrayList<Anggota> getListAnggota(){
       return listAnggota;
    }
    
    @Override
    public void insert(Object x) {
        listAnggota.add((Anggota) x);
    }

    @Override
    public void update(int index, Object x) {
        listAnggota.set(index ,(Anggota) x);
    }

    @Override
    public void delete(int index) {
        listAnggota.remove(index);
    }
}
