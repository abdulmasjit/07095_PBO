package Model;
import Entity.Abdul07095_BukuEntity;
import Entity.Abdul07095_PeminjamanEntity;
import java.util.ArrayList;

public class Abdul07095_PeminjamanModel{
    private ArrayList<Abdul07095_PeminjamanEntity> listPeminjaman;
    
    public Abdul07095_PeminjamanModel(){
        listPeminjaman = new ArrayList<>();
    }
    
    public ArrayList<Abdul07095_PeminjamanEntity> getListPeminjaman(){
       return listPeminjaman;
    }
    
    public void insert(Object x) {
        listPeminjaman.add((Abdul07095_PeminjamanEntity) x);
    }
    
    public void update(int index, Object x) {
        listPeminjaman.set(index ,(Abdul07095_PeminjamanEntity) x);
    }
}
