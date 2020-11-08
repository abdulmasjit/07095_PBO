package si_perpustakaan;

public class Buku {
    // Attribut    
    String kode_buku, judul_buku, pengarang, tahun_terbit;
    
    // Constructor
    public Buku(String kode_buku, String judul_buku, String pengarang, String tahun_terbit){
        this.kode_buku = kode_buku;
        this.judul_buku = judul_buku;
        this.pengarang = pengarang;
        this.tahun_terbit = tahun_terbit;
    }
    
    // Accessor
    String getKodeBuku(){
        return this.kode_buku;
    }
    
    String getJudul(){
        return this.judul_buku;
    }
    
    String getPengarang(){
        return this.pengarang;
    }
    
    String getTahunTerbit(){
        return this.tahun_terbit;
    }
}
