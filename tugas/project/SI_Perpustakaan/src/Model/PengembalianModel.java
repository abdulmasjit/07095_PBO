package Model;
import Entity.Pengembalian;
import java.util.ArrayList;

public class PengembalianModel implements ModelInterfaces {
    private ArrayList<Pengembalian> ListPengembalian;
    
    public PengembalianModel(){
        ListPengembalian = new ArrayList<>();
    }
    
    public ArrayList<Pengembalian> getListPengembalian(){
        return ListPengembalian;
    }
    
    @Override
    public void view() {
        // View
    }

    @Override
    public void insert(Object x) {
        ListPengembalian.add((Pengembalian) x);
    }

    @Override
    public void update(int index, Object x) {
        ListPengembalian.set(index ,(Pengembalian) x);
    }

    @Override
    public void delete(int index) {
        ListPengembalian.remove(index);
    }
    
    @Override
    public void get_where(int index) {
        ListPengembalian.get(index);
    } 
}
