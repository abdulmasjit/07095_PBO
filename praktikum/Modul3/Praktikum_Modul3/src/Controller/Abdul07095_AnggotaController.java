package Controller;
import Model.Abdul07095_AnggotaModel;
import Entity.Abdul07095_AnggotaEntity;
import java.util.ArrayList;

public class Abdul07095_AnggotaController {
    Abdul07095_AnggotaModel anggota_m;

    public Abdul07095_AnggotaController() {
        anggota_m = new Abdul07095_AnggotaModel();
    }
    
    public ArrayList<Abdul07095_AnggotaEntity> viewAnggota(){
        return anggota_m.getListAnggota();
    }
    
    public void dataAnggotaSementara(){  
        String noId [] = {"AG001", "AG002", "AG003"};
        String nama [] = {"Risky Ade", "Dian Indah", "Muhammad Alkautsar"};
        String noTelp [] = {"085334545054", "085334545051", "085334545055"};    
        int jenisAnggota [] = {1, 1, 0};    
        for (int i = 0; i < noId.length; i++) {
            anggota_m.insert(new Abdul07095_AnggotaEntity(noId[i], nama[i], noTelp[i], jenisAnggota[i]));
        }
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
