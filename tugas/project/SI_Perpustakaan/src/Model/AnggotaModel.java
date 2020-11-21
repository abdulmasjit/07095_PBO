package Model;
import Entity.Anggota;
import java.util.ArrayList;

public class AnggotaModel implements ModelInterfaces{
    private ArrayList<Anggota> ListAnggota;
    
    public AnggotaModel(){
        ListAnggota = new ArrayList<>();
    }
    
    @Override
    public void view() {
        // View
    }

    @Override
    public void insert(Object x) {
        ListAnggota.add((Anggota) x);
    }

    @Override
    public void update(int index, Object x) {
        ListAnggota.set(index ,(Anggota) x);
    }

    @Override
    public void delete(int index) {
        ListAnggota.remove(index);
    }
    
    @Override
    public void get_where(int index) {
        ListAnggota.get(index);
    }
}
