package Entity;
import java.util.Date;

public class Peminjaman {
    // Status = "0" -> Belum dikembalikan, 
    //          "1" -> Sudah Dikembalikan
    
    private String noPeminjaman, status;
    private Buku buku;
    private Anggota anggota;
    private int jumlah;      
    private Date tglPinjam, tglKembali;
    
    public Peminjaman(String noPeminjaman, Buku buku, Anggota anggota,int jumlah, Date tglPinjam, Date tglKembali, String status){
        this.noPeminjaman=noPeminjaman;
        this.buku=buku;
        this.anggota=anggota;
        this.jumlah=jumlah;
        this.tglPinjam=tglPinjam;
        this.tglKembali=tglKembali;
        this.status=status;
    }
    
    public Peminjaman(){
        
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

    public Buku getBuku() {
        return buku;
    }

    public void setBuku(Buku buku) {
        this.buku = buku;
    }

    public Anggota getAnggota() {
        return anggota;
    }

    public void setAnggota(Anggota anggota) {
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
