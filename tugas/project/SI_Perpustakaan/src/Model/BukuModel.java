package Model;
import Entity.Buku;
import java.util.ArrayList;

public class BukuModel implements ModelInterfaces{
    private ArrayList<Buku> ListBuku;
    
    public BukuModel(){
        ListBuku = new ArrayList<>();
    }
    
    public ArrayList<Buku> getListBuku(){
       return ListBuku;
    }
    
    @Override
    public void view() {
//        for(Buku list : ListBuku){
//            System.out.println("Kode Buku : "+list.getKodeBuku()
//                               +"\nJudul : "+list.getJudul()
//                               +"\nPengarang : "+list.getPengarang()
//                               +"\nTahun Terbit : "+list.getTahunTerbit()
//                               +"\nTahun Terbit : "+list.getStok()
//            );
//            System.out.println("======================================================");
//        }
    }

    @Override
    public void insert(Object x) {
        ListBuku.add((Buku) x);
    }

    @Override
    public void update(int index, Object x) {
        ListBuku.set(index ,(Buku) x);
    }

    @Override
    public void delete(int index) {
        ListBuku.remove(index);
    }
    
    @Override
    public void get_where(int index) {
        ListBuku.get(index);
    }
}
