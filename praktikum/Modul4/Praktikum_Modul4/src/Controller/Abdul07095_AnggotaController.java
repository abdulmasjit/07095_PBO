package Controller;
import Model.Abdul07095_AnggotaModel;
import Entity.Abdul07095_AnggotaEntity;
import Entity.Abdul07095_JenisAnggotaEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class Abdul07095_AnggotaController {
    Abdul07095_AnggotaModel anggota_m;

    public Abdul07095_AnggotaController() {
        anggota_m = new Abdul07095_AnggotaModel();
    }
    
    public ArrayList<Abdul07095_AnggotaEntity> listAnggota(){
        return anggota_m.getListAnggota();
    }
    
    public void dataAnggotaDefault(){  
        String noId [] = {"AG001", "AG002", "AG003"};
        String nama [] = {"Risky Ade", "Dian Indah", "Muhammad Alkautsar"};
        String noTelp [] = {"085334545054", "085334545051", "085334545055"};    
        int jenisAnggota [] = {1, 1, 0};    
        for (int i = 0; i < noId.length; i++) {
            anggota_m.insert(new Abdul07095_AnggotaEntity(noId[i], nama[i], noTelp[i], jenisAnggota[i]));
        }
    }
    
    public DefaultTableModel loadDataAnggota(){
        DefaultTableModel dtmAnggota = new DefaultTableModel();
        Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
        
        Object[] kolom = {"No ID","Nama","No Telp","Jenis Anggota"};
        dtmAnggota.setColumnIdentifiers(kolom);
        int size = anggota_m.getListAnggota().size();
        for (int i=0; i<size; i++){
             Object[] data = {
                anggota_m.getListAnggota().get(i).getNoId(),
                anggota_m.getListAnggota().get(i).getNama(),
                anggota_m.getListAnggota().get(i).getNoTelp(),
                ja.jenisAnggota[anggota_m.getListAnggota().get(i).getJenisAnggota()],
            };
            dtmAnggota.addRow(data);
        }
        return dtmAnggota;
    }
    
    public void insertAnggota(String noId, String nama, String noTelp, int jenisAnggota){
        Abdul07095_AnggotaEntity data = new Abdul07095_AnggotaEntity();
        data.setNoId(noId);
        data.setNama(nama);
        data.setNoTelp(noTelp);
        data.setJenisAnggota(jenisAnggota);
        // Insert Objection
        anggota_m.insert(data);
    }
    
    public void updateAnggota(int index, String noId, String nama, String noTelp, int jenisAnggota){
        Abdul07095_AnggotaEntity data = new Abdul07095_AnggotaEntity();
        data.setNoId(noId);
        data.setNama(nama);
        data.setNoTelp(noTelp);
        data.setJenisAnggota(jenisAnggota);
        // Update Objection
        anggota_m.update(index, data);
    }
    
    
    public void deleteAnggota(int index){
        // Delete Objection
        anggota_m.delete(index);
    }
    
    public Abdul07095_AnggotaEntity getDetail(int index){
        return anggota_m.getListAnggota().get(index);
    }
    
    public int cari(String id){
        int result = -1;
        if(anggota_m.getListAnggota().size()>0){
            for(int i = 0; i < anggota_m.getListAnggota().size(); i++){
                if(anggota_m.getListAnggota().get(i).getNoId().equals(id)){
                    result = i;
                    break;
                }else{
                    result = -1;
                }     
            }
        }
        return result;
    }
}
