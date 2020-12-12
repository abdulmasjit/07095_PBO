package Entity;
public class Buku {
    // Attribut    
    private String kode_buku, judul_buku, pengarang, tahun_terbit;
    private int stok;
    
    // Constructor
    public Buku(String kode_buku, String judul_buku, String pengarang, String tahun_terbit, int stok){
        this.kode_buku = kode_buku;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tahun_terbit = tahun_terbit;
        this.stok = stok;
    }
    
    // Setter / Mutator
    public void setKodeBuku(String kode_buku){
        this.kode_buku = kode_buku;
    }
    
    public void setJudul(String judul){
        this.judul_buku = judul;
    }
    
    public void setPengarang(String pengarang){
        this.pengarang = pengarang;
    }
    
    public void setTahunTerbit(String tahun_terbit){
        this.tahun_terbit = tahun_terbit;
    }
    
    public void setStok(int stok){
        this.stok = stok;
    }
    
    // Selector / Getter
    public String getKodeBuku(){
        return this.kode_buku;
    }
    
    public String getJudul(){
        return this.judul_buku;
    }
    
    public String getPengarang(){
        return this.pengarang;
    }
    
    public String getTahunTerbit(){
        return this.tahun_terbit;
    }
    
    public int getStok(){
        return this.stok;
    }
}
