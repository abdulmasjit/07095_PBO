package Model;
import Entity.Peminjaman;
import java.util.ArrayList;

public class PeminjamanModel{
    private ArrayList<Peminjaman> listPeminjaman;
    
    public PeminjamanModel(){
        listPeminjaman = new ArrayList<>();
    }
    
    public ArrayList<Peminjaman> getListPeminjaman(){
       return listPeminjaman;
    }
    
    public void insert(Object x) {
        listPeminjaman.add((Peminjaman) x);
    }
    
    public void update(int index, Object x) {
        listPeminjaman.set(index ,(Peminjaman) x);
    }
}
