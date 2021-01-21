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
public class GUIDataPeminjaman {
    JFrame dtpFrame = new JFrame();
    
    public GUIDataPeminjaman(){
        initComponens();
    }
    
    private void initComponens(){
        dtpFrame.setSize(800, 350);
        dtpFrame.setLayout(null);
        dtpFrame.setTitle("Data Peminjaman");
        
        JTable tabelPinjam = new JTable();
        JScrollPane scrollable = new JScrollPane(tabelPinjam);
        JButton btnKembali;
        
        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(30, 30, 100, 30);
        dtpFrame.add(btnKembali);
        
        // Table Peminjaman
        scrollable.setBounds(30, 80, 725, 200);
        tabelPinjam.setModel(Objection.pinjam_c.loadDataPeminjaman());
        dtpFrame.add(scrollable);
        
        dtpFrame.setLocationRelativeTo(null);
        dtpFrame.setVisible(true);
        dtpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dtpFrame.dispose();
                GUIMenu men = new GUIMenu();
            }
        });
    }
}
