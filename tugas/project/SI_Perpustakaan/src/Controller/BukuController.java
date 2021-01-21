package Controller;
import Entity.Buku;
import Model.BukuModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class BukuController {
    BukuModel buku_m;

    public BukuController() {
        buku_m = new BukuModel();
    }
    
    public ArrayList<Buku> listBuku(){
        return buku_m.getListBuku();
    }
    
    public void dataBukuDefault(){  
        String kodeBuku [] = {"BK001", "BK002", "BK003"};
        String judul [] = {"Buku Affilate Marketing", "Buku Javascript Async With Ajax", "Buku Postgre SQL Untuk Pemula"};
        String pengarang [] = {"Risky Ade", "Dian Indah", "Ahmad Maulana"};    
        String tahunTerbit [] = {"2019", "2018", "2020"};    
        int stok [] = {50, 30, 30};
        for (int i = 0; i < kodeBuku.length; i++) {
            buku_m.insert(new Buku(kodeBuku[i], judul[i], pengarang[i], tahunTerbit[i], stok[i]));
        }
    }
    
    public DefaultTableModel loadDataBuku(){
        DefaultTableModel dtmdaftarprak = new DefaultTableModel();
        Object[] kolom = {"Kode Buku","Judul","Pengarang","Tahun Terbit","Stok"};
        dtmdaftarprak.setColumnIdentifiers(kolom);
        int size = buku_m.getListBuku().size();
        for (int i=0; i<size; i++){
             Object[] data = {
                buku_m.getListBuku().get(i).getKodeBuku(),
                buku_m.getListBuku().get(i).getJudulBuku(),
                buku_m.getListBuku().get(i).getPengarang(),
                buku_m.getListBuku().get(i).getTahunTerbit(),
                buku_m.getListBuku().get(i).getStok(),
            };
            dtmdaftarprak.addRow(data);
        }
        return dtmdaftarprak;
    }
    
    public void insertBuku(String kodeBuku, String judul, String pengarang, String tahunTerbit, int stok){
        Buku data = new Buku();
        data.setKodeBuku(kodeBuku);
        data.setJudulBuku(judul);
        data.setPengarang(pengarang);
        data.setTahunTerbit(tahunTerbit);
        data.setStok(stok);
        // Insert Objection
        buku_m.insert(data);
    }
    
    public void updateBuku(int index, String kodeBuku, String judul, String pengarang, String tahunTerbit, int stok){
        Buku data = new Buku();
        data.setKodeBuku(kodeBuku);
        data.setJudulBuku(judul);
        data.setPengarang(pengarang);
        data.setTahunTerbit(tahunTerbit);
        data.setStok(stok);
        // Update Objection
        buku_m.update(index, data);
    }
    
    public void deleteBuku(int index){
        // Delete Objection
        buku_m.delete(index);
    }
    
    public Buku getDetail(int index){
        return buku_m.getListBuku().get(index);
    }
    
    public int cari(String kode){
        int result = -1;
        if(buku_m.getListBuku().size()>0){
            for(int i = 0; i < buku_m.getListBuku().size(); i++){
                if(buku_m.getListBuku().get(i).getKodeBuku().equals(kode)){
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
