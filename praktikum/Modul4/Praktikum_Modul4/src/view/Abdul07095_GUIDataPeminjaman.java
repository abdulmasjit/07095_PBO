package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIDataPeminjaman {
    JFrame dtpFrame = new JFrame();
    JButton btnKembali;
    JTable tabelPinjam = new JTable();
    JScrollPane scrollable = new JScrollPane(tabelPinjam);
    
    public Abdul07095_GUIDataPeminjaman(){
        dtpFrame.setSize(800, 350);
        dtpFrame.setLayout(null);
        dtpFrame.setTitle("Data Peminjaman");
        
        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(30, 30, 100, 30);
        dtpFrame.add(btnKembali);
        
        // Table Peminjaman
        scrollable.setBounds(30, 80, 725, 200);
        tabelPinjam.setModel(Objctrl.pinjam_c.loadDataPeminjaman());
        dtpFrame.add(scrollable);
        
        dtpFrame.setLocationRelativeTo(null);
        dtpFrame.setVisible(true);
        dtpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dtpFrame.dispose();
                Abdul07095_GUIMenu men = new Abdul07095_GUIMenu();
            }
        });
    }
}
