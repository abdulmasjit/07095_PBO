package Main;
import view.Abdul07095_GUILogin;
import view.Objctrl;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIMain {
    public static void main(String[] args) {
        Abdul07095_GUILogin gui = new Abdul07095_GUILogin();
        Objctrl.petugas_c.dataPetugas();
        Objctrl.buku_c.dataBukuDefault();
    }
}
