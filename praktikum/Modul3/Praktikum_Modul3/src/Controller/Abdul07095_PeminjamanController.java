package Controller;
import Entity.Abdul07095_AnggotaEntity;
import Entity.Abdul07095_BukuEntity;
import Entity.Abdul07095_PeminjamanEntity;
import Model.Abdul07095_PeminjamanModel;
import java.util.ArrayList;
import java.util.Date;

public class Abdul07095_PeminjamanController {
    Abdul07095_PeminjamanModel pinjam_m;
    public Abdul07095_PeminjamanController() {
        pinjam_m = new Abdul07095_PeminjamanModel();
    }
    
    public ArrayList<Abdul07095_PeminjamanEntity> viewPeminjaman(){
        return pinjam_m.getListPeminjaman();
    }
    
    public void insertPeminjaman(Abdul07095_BukuEntity buku, Abdul07095_AnggotaEntity anggota,int jumlah, Date tglPinjam, Date tglKembali){
        Abdul07095_PeminjamanEntity data = new Abdul07095_PeminjamanEntity();       
        data.setNoPeminjaman("");
        data.setBuku(buku);
        data.setAnggota(anggota);
        data.setJumlah(jumlah);
        data.setTglPinjam(tglPinjam);
        data.setTglKembali(tglKembali);
        data.setStatus("0"); // Belum dikembalikan / Masa Peminjaman
        // Insert Objection
        pinjam_m.insert(data);
    }
    
    public Abdul07095_PeminjamanEntity getDetail(int index){
        return pinjam_m.getListPeminjaman().get(index);
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
    
    public void updateStatus(int index, Abdul07095_PeminjamanEntity pinjam){
        Abdul07095_PeminjamanEntity data = new Abdul07095_PeminjamanEntity();       
        data.setNoPeminjaman("");
        data.setBuku(pinjam.getBuku());
        data.setAnggota(pinjam.getAnggota());
        data.setJumlah(pinjam.getJumlah());
        data.setTglPinjam(pinjam.getTglPinjam());
        data.setTglKembali(pinjam.getTglKembali());
        data.setStatus("1"); // Sudah dikembalikan
        // Update Objection
        pinjam_m.update(index, data);
    }
}
