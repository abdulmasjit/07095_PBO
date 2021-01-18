package view;
import java.awt.BorderLayout;
import java.awt.Container;
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
        menuFrame.setSize(710, 400);
        menuFrame.setLayout(null);
        menuFrame.setTitle("Menu");
        menuFrame.getContentPane().setBackground(new java.awt.Color(103,25,220));
        JButton menuBuku, menuAnggota, menuDataPeminjaman, menuPeminjaman, menuPengembalian, logout;
        
        menuBuku = new JButton("Buku");
        menuBuku.setBounds(30, 50, 200, 80);
        menuBuku.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/books.png")));
        menuBuku.setBackground(new java.awt.Color(255, 255, 255));
        menuFrame.add(menuBuku);
        
        menuAnggota = new JButton("Anggota");
        menuAnggota.setBounds(245, 50, 200, 80);
        menuAnggota.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/add-user.png")));
        menuAnggota.setBackground(new java.awt.Color(255, 255, 255));
        menuFrame.add(menuAnggota);
        
        menuDataPeminjaman = new JButton("Data Peminjaman");
        menuDataPeminjaman.setBounds(460, 50, 200, 80);
        menuDataPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/data-pinjam.png")));
        menuDataPeminjaman.setBackground(new java.awt.Color(255, 255, 255));
        menuFrame.add(menuDataPeminjaman);
        
        menuPeminjaman = new JButton("Peminjaman");
        menuPeminjaman.setBounds(30, 145, 200, 80);
        menuPeminjaman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/transaksi.png")));
        menuPeminjaman.setBackground(new java.awt.Color(255, 255, 255));
        menuFrame.add(menuPeminjaman);
        
        menuPengembalian = new JButton("Pengembalian");
        menuPengembalian.setBounds(245, 145, 200, 80);
        menuPengembalian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sinkron.png")));
        menuPengembalian.setBackground(new java.awt.Color(255, 255, 255));
        menuFrame.add(menuPengembalian);
        
        logout = new JButton("Logout");
        logout.setBounds(460, 145, 200, 80);
        logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/sign-out.png")));
        logout.setBackground(new java.awt.Color(255, 255, 255));
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
