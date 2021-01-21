package view;
import Controller.*;
import Entity.JenisAnggota;
/**
 *
 * @author Masjit Subekti
 */
public class Objection {
    public static AnggotaController anggota_c = new AnggotaController();
    public static BukuController buku_c = new BukuController();
    public static PeminjamanController pinjam_c = new PeminjamanController();
    public static PetugasController petugas_c = new PetugasController();
    
    public static JenisAnggota ja = new JenisAnggota();
    public static String [] statusPeminjaman = {"Belum Dikembalikan", "Dikembalikan"};
}
