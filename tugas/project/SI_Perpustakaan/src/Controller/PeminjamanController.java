package Controller;
import Entity.Anggota;
import Entity.Buku;
import Entity.Peminjaman;
import Model.PeminjamanModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

public class PeminjamanController {
    PeminjamanModel pinjam_m;
    private String [] statusPeminjaman = {"Belum Dikembalikan", "Dikembalikan"};

    public PeminjamanController() {
        pinjam_m = new PeminjamanModel();
    }
    
    public ArrayList<Peminjaman> listPeminjaman(){
        return pinjam_m.getListPeminjaman();
    }
    
    public DefaultTableModel loadDataPeminjaman(){
        DefaultTableModel dtmPeminjaman = new DefaultTableModel();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Object[] kolom = {"Nama Anggota","Buku","Tanggal Pinjam","Tanggal Kembali","Status"};
        dtmPeminjaman.setColumnIdentifiers(kolom);
        int size = pinjam_m.getListPeminjaman().size();
        for (int i=0; i<size; i++){
            String namaAnggota = pinjam_m.getListPeminjaman().get(i).getAnggota().getNoId()+ " - " +pinjam_m.getListPeminjaman().get(i).getAnggota().getNama(); 
            String buku = pinjam_m.getListPeminjaman().get(i).getBuku().getKodeBuku()+ " - " +pinjam_m.getListPeminjaman().get(i).getBuku().getJudulBuku(); 
             Object[] data = {
                namaAnggota,
                buku,
                formatter.format(pinjam_m.getListPeminjaman().get(i).getTglPinjam()),
                formatter.format(pinjam_m.getListPeminjaman().get(i).getTglKembali()),
                statusPeminjaman[Integer.parseInt(pinjam_m.getListPeminjaman().get(i).getStatus())]
            };
            dtmPeminjaman.addRow(data);
        }
        return dtmPeminjaman;
    }
    
    public void insertPeminjaman(Buku buku, Anggota anggota,int jumlah, Date tglPinjam, Date tglKembali){
        Peminjaman data = new Peminjaman();       
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
    
    public Peminjaman getDetail(int index){
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
    
    public void updateStatus(int index, Peminjaman pinjam){
        Peminjaman data = new Peminjaman();       
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
