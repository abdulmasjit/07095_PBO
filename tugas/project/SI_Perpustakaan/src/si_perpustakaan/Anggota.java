package si_perpustakaan;

public class Anggota {
    String id_anggota,nama,alamat,notelp;
    
//    public Anggota(String id_anggota, String nama, String alamat, String notelp){
//        this.id_anggota = id_anggota;
//        this.nama = nama;
//        this.alamat = alamat;
//        this.notelp = notelp;
//    }
    
    String getIdAnggota(){
        return this.id_anggota;
    }
    String getNama(){
        return this.nama;
    }
    String getAlamat(){
        return this.alamat;
    }
    String getNoTelp(){
        return this.notelp;
    }
}
