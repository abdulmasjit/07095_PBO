package Entity;
public class Anggota extends WargaPerpus {
    private String jenis_anggota;
    /*  Jenis Anggota
        JA01 -> Guru
        JA02 -> Siswa
    */
    public Anggota(String no_id, String nama, String alamat, String no_telp, String jenis_anggota){
        super(no_id, nama, alamat, no_telp);
        this.jenis_anggota = jenis_anggota;
    }

    // Setter / Mutator      
    public void setJenisAnggota(String jenis_anggota){
        this.jenis_anggota = jenis_anggota;
    }    
    
    @Override
    public String getNoId(){
        return this.no_id;
    }
    
    // Selector / Getter    
    public String getJenisAnggota(){
        return this.jenis_anggota;
    }
}
