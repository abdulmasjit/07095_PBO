package Model;
import Controller.Abdul07095_AnggotaController;
import Entity.Abdul07095_AnggotaEntity;
import java.util.ArrayList;

public class Abdul07095_AnggotaModel implements Abdul07095_ModelInterfaces{
    private ArrayList<Abdul07095_AnggotaEntity> listAnggota;
    public Abdul07095_AnggotaModel(){
        listAnggota = new ArrayList<>();
    }
    
    public ArrayList<Abdul07095_AnggotaEntity> getListAnggota(){
       return listAnggota;
    }
    
    @Override
    public void insert(Object x) {
        listAnggota.add((Abdul07095_AnggotaEntity) x);
    }

    @Override
    public void update(int index, Object x) {
        listAnggota.set(index ,(Abdul07095_AnggotaEntity) x);
    }

    @Override
    public void delete(int index) {
        listAnggota.remove(index);
    }
}
