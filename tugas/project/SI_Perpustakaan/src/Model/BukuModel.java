package Model;
import Entity.Buku;
import java.util.ArrayList;

public class BukuModel implements ModelInterfaces{
    private ArrayList<Buku> listBuku;
    
    public BukuModel(){
        listBuku = new ArrayList<>();
    }
    
    public ArrayList<Buku> getListBuku(){
       return listBuku;
    }
    
    @Override
    public void insert(Object x) {
        listBuku.add((Buku) x);
    }

    @Override
    public void update(int index, Object x) {
        listBuku.set(index ,(Buku) x);
    }

    @Override
    public void delete(int index) {
        listBuku.remove(index);
    }
}
