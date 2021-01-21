package Main;
import view.*;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIMain {
    public static void main(String[] args) {
        Abdul07095_GUILogin gui = new Abdul07095_GUILogin();
        Objctrl.petugas_c.dataPetugas();
        Objctrl.buku_c.dataBukuDefault();
        
//        int a = 30; int b = 4;
//        int c= a/b;
//        System.out.println(c);
        
       String cetak = "";
       int x;
       for ( x = 1; x <= 10; x++ ) {
            if ( x == 5 )
                break;
            cetak = cetak + x + "";
       }
        System.out.println(cetak);
       
        
        int hasil;
        int a = 2, b = 3, c = 6, d = 5;
        hasil = b * d - c / a + b;
        System.out.print("Hasil  = "+hasil);
    }
}
