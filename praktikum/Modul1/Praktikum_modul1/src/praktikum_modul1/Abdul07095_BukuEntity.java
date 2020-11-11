package praktikum_modul1;
public class Abdul07095_BukuEntity {
    // Attribut    
    String Abdul07095_kodeBuku, Abdul07095_judulBuku, Abdul07095_pengarang, Abdul07095_tahunTerbit;
    // Constructor
    public Abdul07095_BukuEntity(String Abdul07095_kode_buku, String Abdul07095_judul_buku, String Abdul07095_pengarang, String Abdul07095_tahun_terbit){
        this.Abdul07095_kodeBuku = Abdul07095_kode_buku;
        this.Abdul07095_judulBuku = Abdul07095_judul_buku;
        this.Abdul07095_pengarang = Abdul07095_pengarang;
        this.Abdul07095_tahunTerbit = Abdul07095_tahun_terbit;
    }
    // Accessor
    String getKodeBuku(){
        return this.Abdul07095_kodeBuku;
    }
    
    String getJudul(){
        return this.Abdul07095_judulBuku;
    }
    
    String getPengarang(){
        return this.Abdul07095_pengarang;
    }
    
    String getTahunTerbit(){
        return this.Abdul07095_tahunTerbit;
    }
}
