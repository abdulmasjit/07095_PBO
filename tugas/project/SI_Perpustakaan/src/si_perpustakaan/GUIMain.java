package si_perpustakaan;
import view.*;

/**
 *
 * @author Masjit Subekti
 */
public class GUIMain {
    public static void main(String[] args) {
        GUILogin gui = new GUILogin();
        Objection.petugas_c.dataPetugas();
        Objection.buku_c.dataBukuDefault();
   }
}
