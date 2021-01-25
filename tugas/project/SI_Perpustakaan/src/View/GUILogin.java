package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class GUILogin {
    JFrame loginFrame = new JFrame();
    JButton btnLogin;
    JTextField txtUsername;
    JPasswordField txtPassword;
    
    public GUILogin(){
        initComponents();
    }
    
    private void initComponents(){
        loginFrame.setSize(830, 450);
        loginFrame.setLayout(null);
        loginFrame.setTitle("Login");
        loginFrame.getContentPane().setBackground(new java.awt.Color(103,25,191));
        
        JLabel labelWelcome = new JLabel();
        JLabel labelKetNarasi = new JLabel();
        JLabel labelImage = new JLabel();
        JLabel labelNarasi = new JLabel();
        JLabel labelLogin = new JLabel();
        JLabel labelUsername = new JLabel();
        JLabel labelPassword = new JLabel();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        
        labelWelcome.setBounds(20, 5, 300, 100);
        labelWelcome.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        labelWelcome.setForeground(new java.awt.Color(255, 255, 255));
        labelWelcome.setText("SELAMAT DATANG");
        loginFrame.add(labelWelcome);
        
        labelKetNarasi.setBounds(20, 30, 350, 100);
        labelKetNarasi.setFont(new java.awt.Font("Calibri", 1, 19)); // NOI18N
        labelKetNarasi.setForeground(new java.awt.Color(255, 255, 255));
        labelKetNarasi.setText("DI APLIKASI PERPUSTAKAAN SEKOLAH");
        loginFrame.add(labelKetNarasi);
        
        labelImage.setBounds(20, 70, 350, 300);
        labelImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/logo.png"))); // NOI18N
        labelImage.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginFrame.add(labelImage);
        
        labelLogin.setBounds(430, 30, 130, 50);
        labelLogin.setText("Login");
        labelLogin.setFont(new java.awt.Font("Segoe UI", 1, 24));
        loginFrame.add(labelLogin);
        
        labelNarasi.setBounds(430, 65, 400, 50);
        labelNarasi.setText("Silahkan login dengan username & password anda");
        labelNarasi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginFrame.add(labelNarasi);
        
        labelUsername.setBounds(430, 113, 100, 50);
        labelUsername.setText("Username");
        labelUsername.setFont(new java.awt.Font("Segoe UI", 0, 14));
        loginFrame.add(labelUsername);
        
        txtUsername.setBounds(430, 150, 335, 30);
        txtUsername.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsername.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        loginFrame.add(txtUsername);
        
        labelPassword.setBounds(430, 183, 100, 50);
        labelPassword.setText("Password");
        labelPassword.setFont(new java.awt.Font("Segoe UI", 0, 14));
        loginFrame.add(labelPassword);
        
        txtPassword.setBounds(430, 220, 335, 30);
        txtPassword.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        loginFrame.add(txtPassword);
        
        btnLogin = new JButton();        
        btnLogin.setBounds(665, 275, 100, 35);
        btnLogin.setBackground(new java.awt.Color(103, 25, 191));
        btnLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLogin.setForeground(java.awt.Color.white);
        btnLogin.setText("Login");
        btnLogin.setBorder(null);
        btnLogin.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        loginFrame.add(btnLogin);
        
        JPanel panelLogin = new JPanel();
        panelLogin.setBackground(Color.WHITE);
        panelLogin.setBounds(400, 20, 395, 365);
        loginFrame.add(panelLogin);
        
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login();
            }
        });
        
        txtPassword.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                   login();
                }
            } 
        });
    }
    
    private void login(){
         try {
            if(txtUsername.getText().equals("") || txtPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Username atau password tidak boleh kosong !");
            }else{
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                int cekLogin = Objection.petugas_c.getUser(username, password);
                if(cekLogin!=-1){
                    JOptionPane.showMessageDialog(null, "Login Berhasil !");
                    loginFrame.dispose();
                    GUIMenu menu = new GUIMenu();
                }else{
                  
                    JOptionPane.showMessageDialog(null, "Oopss, Login Gagal !");
                }
            }
        } catch (Exception e) {
            System.out.println("Login gagal");
        }
    }
}
