package view;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUIMenu {
    JFrame menuFrame = new JFrame();
    
    public GUIMenu(){
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
                GUIBuku buku = new GUIBuku();
            }
        });
        
        menuAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                GUIAnggota anggota = new GUIAnggota();
            }
        });
        
        menuDataPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                GUIDataPeminjaman dp = new GUIDataPeminjaman();
            }
        });
        
        menuPeminjaman.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                GUIPeminjaman pinjam = new GUIPeminjaman();
            }
        });
        
        menuPengembalian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                GUIPengembalian kembali = new GUIPengembalian();
            }
        });
        
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                menuFrame.dispose();
                GUILogin login = new GUILogin();
            }
        });
        
  
    }
}
