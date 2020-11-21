package Model;

import Entity.Peminjaman;

import java.util.ArrayList;

public class PeminjamanModel implements ModelInterfaces {
    private ArrayList<Peminjaman>pinjam;
    
    public PeminjamanModel(){
        pinjam= new ArrayList<>();
    }
    
    public ArrayList<Peminjaman> getpinjam(){
       return pinjam;
    }
    
    @Override
    public void view() {
        // View
    }

    @Override
    public void insert(Object x) {
        pinjam.add((Peminjaman) x);
    }

    @Override
    public void update(int index, Object x) {
        pinjam.set(index ,(Peminjaman) x);
    }

    @Override
    public void delete(int index) {
        pinjam.remove(index);
    }
    
    @Override
    public void get_where(int index) {
        pinjam.get(index);
    }
            
    
}
