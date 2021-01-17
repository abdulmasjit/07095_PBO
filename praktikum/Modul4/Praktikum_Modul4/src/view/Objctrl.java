package view;
import Controller.*;
import Entity.Abdul07095_JenisAnggotaEntity;
/**
 *
 * @author Masjit Subekti
 */
public class Objctrl {
    public static Abdul07095_AnggotaController anggota_c = new Abdul07095_AnggotaController();
    public static Abdul07095_BukuController buku_c = new Abdul07095_BukuController();
    public static Abdul07095_PeminjamanController pinjam_c = new Abdul07095_PeminjamanController();
    public static Abdul07095_PetugasController petugas_c = new Abdul07095_PetugasController();
    
    public static Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    public static String [] statusPeminjaman = {"Belum Dikembalikan", "Dikembalikan"};
}
