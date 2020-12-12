package Model;
import Entity.Abdul07095_AnggotaEntity;
import Entity.Abdul07095_JenisAnggotaEntity;
import java.util.ArrayList;

public class Abdul07095_AnggotaModel implements Abdul07095_ModelInterfaces{
    private ArrayList<Abdul07095_AnggotaEntity> listAnggota;
    Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    
    public Abdul07095_AnggotaModel(){
        listAnggota = new ArrayList<>();
    }
    
    public ArrayList<Abdul07095_AnggotaEntity> getListAnggota(){
       return listAnggota;
    }
    
    @Override
    public void view() {
        if(listAnggota.size()>0){
            for(Abdul07095_AnggotaEntity list : listAnggota){
                System.out.println("No ID : "+list.getNoId()
                                   +"\nNama : "+list.getNama()
                                   +"\nNo.Telp : "+list.getNoTelp()
                                   +"\nJenis Anggota : "+ja.jenisAnggota[list.getJenisAnggota()]
                );
                System.out.println("======================================================");
            }
        }else{
            System.out.println("Data Anggota Kosong\n");
        }
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
