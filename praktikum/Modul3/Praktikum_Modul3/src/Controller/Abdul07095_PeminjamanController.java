package Controller;

import Entity.Abdul07095_PeminjamanEntity;
import Model.Abdul07095_PeminjamanModel;
import java.util.ArrayList;

public class Abdul07095_PeminjamanController {
    Abdul07095_PeminjamanModel pinjam_m;

    public Abdul07095_PeminjamanController() {
        pinjam_m = new Abdul07095_PeminjamanModel();
    }
    
    public ArrayList<Abdul07095_PeminjamanEntity> viewPeminjaman(){
        return pinjam_m.getListPeminjaman();
    }
    
    public int cekPeminjamanAnggota(String id, String status){
        int result = -1;
        if(pinjam_m.getListPeminjaman().size()>0){
            for(int i = 0; i < pinjam_m.getListPeminjaman().size(); i++){
                String noId = pinjam_m.getListPeminjaman().get(i).getAnggota().getNoId();
                String statusPinjam = pinjam_m.getListPeminjaman().get(i).getStatus();
                if(noId.equals(id) && statusPinjam.equals(status)){
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
