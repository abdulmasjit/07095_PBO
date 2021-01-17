package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIMenu {
    JFrame menuFrame = new JFrame();
    
    public Abdul07095_GUIMenu(){
        initComponents();
    }
    
    private void initComponents(){
        menuFrame.setSize(700, 500);
        menuFrame.setLayout(null);
        menuFrame.setTitle("Menu");
        
        JButton menuBuku, menuAnggota, menuDataPeminjaman, menuPeminjaman, menuPengembalian, logout;
        
        menuBuku = new JButton("Buku");
        menuBuku.setBounds(100, 50, 150, 70);
        menuFrame.add(menuBuku);
        
        menuAnggota = new JButton("Anggota");
        menuAnggota.setBounds(270, 50, 150, 70);
        menuFrame.add(menuAnggota);
        
        menuDataPeminjaman = new JButton("Data Peminjaman");
        menuDataPeminjaman.setBounds(440, 50, 150, 70);
        menuFrame.add(menuDataPeminjaman);
        
        menuPeminjaman = new JButton("Peminjaman");
        menuPeminjaman.setBounds(100, 140, 150, 70);
        menuFrame.add(menuPeminjaman);
        
        menuPengembalian = new JButton("Pengembalian");
        menuPengembalian.setBounds(270, 140, 150, 70);
        menuFrame.add(menuPengembalian);
        
        logout = new JButton("Logout");
        logout.setBounds(440, 140, 150, 70);
        menuFrame.add(logout);
        
        menuFrame.setLocationRelativeTo(null);
        menuFrame.setVisible(true);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                Abdul07095_GUIBuku buku = new Abdul07095_GUIBuku();
            }
        });
        
        menuAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                Abdul07095_GUIAnggota anggota = new Abdul07095_GUIAnggota();
            }
        });
        
        menuDataPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                Abdul07095_GUIDataPeminjaman dp = new Abdul07095_GUIDataPeminjaman();
            }
        });
        
        menuPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                Abdul07095_GUIPeminjaman pinjam = new Abdul07095_GUIPeminjaman();
            }
        });
        
        menuPengembalian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                Abdul07095_GUIPengembalian kembali = new Abdul07095_GUIPengembalian();
            }
        });
        
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                Abdul07095_GUILogin login = new Abdul07095_GUILogin();
            }
        });
        
//        
//      
//        JFrame myframe = new JFrame("JToolBar Example");  
//        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
//        JToolBar toolbar = new JToolBar();  
//        toolbar.setRollover(true);  
//        JButton button = new JButton("File");  
//        toolbar.add(button);  
//        toolbar.addSeparator();  
//        toolbar.add(new JButton("Edit"));  
//        toolbar.add(new JComboBox(new String[] { "Opt-1", "Opt-2", "Opt-3", "Opt-4" }));  
//        Container contentPane = myframe.getContentPane();  
//        contentPane.add(toolbar, BorderLayout.NORTH);  
//        JTextArea textArea = new JTextArea();  
//        JScrollPane mypane = new JScrollPane(textArea);  
//        contentPane.add(mypane, BorderLayout.EAST);  
//        myframe.setSize(450, 250);  
//        myframe.setVisible(true);  
    }
}
