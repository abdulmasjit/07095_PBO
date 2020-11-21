package Entity;

import java.util.Date;
public class Peminjaman {
    private String no_peminjaman;
    private int index_Buku,index_Anggota,jumlah;      
    private Date tgl_peminjaman;
    
    public Peminjaman(String no_peminjaman,int index_Buku,int index_Anggota,int jumlah,Date tgl_peminjaman){
        this.no_peminjaman=no_peminjaman;
        this.index_Buku=index_Buku;
        this.index_Anggota=index_Anggota;
        this.jumlah=jumlah;
        this.tgl_peminjaman=tgl_peminjaman;
        
    }

    public void setNo_peminjaman(String no_peminjaman) {
        this.no_peminjaman = no_peminjaman;
    }

    public void setIndex_Buku(int index_Buku) {
        this.index_Buku = index_Buku;
    }

    public void setIndex_Anggota(int index_Anggota) {
        this.index_Anggota = index_Anggota;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public void setTgl_peminjaman(Date tgl_peminjaman) {
        this.tgl_peminjaman = tgl_peminjaman;
    }

    public String getNo_peminjaman() {
        return no_peminjaman;
    }

    public int getIndex_Buku() {
        return index_Buku;
    }

    public int getIndex_Anggota() {
        return index_Anggota;
    }

    public int getJumlah() {
        return jumlah;
    }

    public Date getTgl_peminjaman() {
        return tgl_peminjaman;
    }       
            
}
