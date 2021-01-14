package Entity;
import java.util.Date;

public class Abdul07095_PeminjamanEntity {
    // Status = "0" -> Belum dikembalikan, 
    //          "1" -> Sudah Dikembalikan
    
    private String noPeminjaman, status;
    private Abdul07095_BukuEntity buku;
    private Abdul07095_AnggotaEntity anggota;
    private int jumlah;      
    private Date tglPinjam, tglKembali;
    
    public Abdul07095_PeminjamanEntity(String noPeminjaman, Abdul07095_BukuEntity buku, Abdul07095_AnggotaEntity anggota,int jumlah, Date tglPinjam, Date tglKembali, String status){
        this.noPeminjaman=noPeminjaman;
        this.buku=buku;
        this.anggota=anggota;
        this.jumlah=jumlah;
        this.tglPinjam=tglPinjam;
        this.tglKembali=tglKembali;
        this.status=status;
    }
    
    public Abdul07095_PeminjamanEntity(){
        
    }

    public String getNoPeminjaman() {
        return noPeminjaman;
    }

    public void setNoPeminjaman(String noPeminjaman) {
        this.noPeminjaman = noPeminjaman;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Abdul07095_BukuEntity getBuku() {
        return buku;
    }

    public void setBuku(Abdul07095_BukuEntity buku) {
        this.buku = buku;
    }

    public Abdul07095_AnggotaEntity getAnggota() {
        return anggota;
    }

    public void setAnggota(Abdul07095_AnggotaEntity anggota) {
        this.anggota = anggota;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Date getTglPinjam() {
        return tglPinjam;
    }

    public void setTglPinjam(Date tglPinjam) {
        this.tglPinjam = tglPinjam;
    }

    public Date getTglKembali() {
        return tglKembali;
    }

    public void setTglKembali(Date tglKembali) {
        this.tglKembali = tglKembali;
    }
}
