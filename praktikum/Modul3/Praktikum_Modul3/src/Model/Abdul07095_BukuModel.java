package Model;
import Entity.Abdul07095_BukuEntity;
import java.util.ArrayList;

public class Abdul07095_BukuModel implements Abdul07095_ModelInterfaces{
    private ArrayList<Abdul07095_BukuEntity> listBuku;
    public Abdul07095_BukuModel(){
        listBuku = new ArrayList<>();
    }
    
    public ArrayList<Abdul07095_BukuEntity> getListBuku(){
       return listBuku;
    }
    
    @Override
    public void insert(Object x) {
        listBuku.add((Abdul07095_BukuEntity) x);
    }

    @Override
    public void update(int index, Object x) {
        listBuku.set(index ,(Abdul07095_BukuEntity) x);
    }

    @Override
    public void delete(int index) {
        listBuku.remove(index);
    }
}
