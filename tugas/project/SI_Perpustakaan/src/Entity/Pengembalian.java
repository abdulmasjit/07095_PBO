package Entity;
import java.util.Date;
public class Pengembalian {
    
    private String no_Pengembalian;
    private int index_Peminjaman;
    private Date tgl_Pengembalian;
    
    public Pengembalian(String no_Pengembalian, int index_Peminjaman, Date tgl_Pengembalian){
        this.no_Pengembalian = no_Pengembalian;
        this.index_Peminjaman = index_Peminjaman;
        this.tgl_Pengembalian = tgl_Pengembalian;
    }

    //method getter
    public String getNo_Pengembalian() {
        return no_Pengembalian;
    }

    public int getIndex_Peminjaman() {
        return index_Peminjaman;
    }

    public Date getTgl_Pengembalian() {
        return tgl_Pengembalian;
    }

    //method setter
    public void setNo_Pengembalian(String no_Pengembalian) {
        this.no_Pengembalian = no_Pengembalian;
    }

    public void setIndex_Peminjaman(int index_Peminjaman) {
        this.index_Peminjaman = index_Peminjaman;
    }

    public void setTgl_Pengembalian(Date tgl_Pengembalian) {
        this.tgl_Pengembalian = tgl_Pengembalian;
    }
    
    
}
