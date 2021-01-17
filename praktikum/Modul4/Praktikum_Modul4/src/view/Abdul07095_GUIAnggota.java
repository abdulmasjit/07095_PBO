package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Entity.Abdul07095_JenisAnggotaEntity;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIAnggota {
    Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    JFrame anggotaFrame = new JFrame();
    JTable tabelAnggota = new JTable();
    JButton btnKembali, btnReset, btnSimpan, btnEdit, btnHapus;
    JTextField txtNoid, txtNama, txtNotelp;
    JComboBox cmbJenis;
    private int selectedIndex = -1;
    
    public Abdul07095_GUIAnggota(){
        initComponents();
    }
    
    private void initComponents(){
        anggotaFrame.setSize(645, 540);
        anggotaFrame.setLayout(null);
        anggotaFrame.setTitle("Form Anggota");
        
        JScrollPane scrollable = new JScrollPane(tabelAnggota);
        JLabel noidLabel; 
        JLabel namaLabel;
        JLabel notelpLabel;
        JLabel jenisLabel;    
        
        noidLabel = new JLabel("No ID");
        noidLabel.setBounds(30, 30, 100, 30);
        anggotaFrame.add(noidLabel);

        txtNoid = new JTextField();
        txtNoid.setBounds(150, 30, 200, 25);
        anggotaFrame.add(txtNoid);

        namaLabel = new JLabel("Nama");
        namaLabel.setBounds(30, 65, 100, 30);
        anggotaFrame.add(namaLabel);

        txtNama = new JTextField();
        txtNama.setBounds(150, 65, 200, 25);
        anggotaFrame.add(txtNama);

        notelpLabel = new JLabel("No Telp");
        notelpLabel.setBounds(30, 100, 100, 30);
        anggotaFrame.add(notelpLabel);

        txtNotelp = new JTextField();
        txtNotelp.setBounds(150, 100, 200, 25);
        anggotaFrame.add(txtNotelp);

        jenisLabel = new JLabel("Jenis Anggota");
        jenisLabel.setBounds(30, 135, 100, 30);
        anggotaFrame.add(jenisLabel);
        
        cmbJenis = new JComboBox(ja.jenisAnggota);
        cmbJenis.setBounds(150, 135, 200, 25);
        anggotaFrame.add(cmbJenis);

        btnReset = new JButton("Reset");
        btnReset.setBounds(50, 190, 100, 30);
        anggotaFrame.add(btnReset);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(160, 190, 100, 30);
        anggotaFrame.add(btnSimpan);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(270, 190, 100, 30);
        anggotaFrame.add(btnEdit);

        btnHapus = new JButton("hapus");
        btnHapus.setBounds(380, 190, 100, 30);
        anggotaFrame.add(btnHapus);
        
        scrollable.setBounds(30, 240, 570, 200);
        tabelAnggota.setModel(Objctrl.anggota_c.loadDataAnggota());
        anggotaFrame.add(scrollable);
            
        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(30, 450, 100, 30);
        anggotaFrame.add(btnKembali);
        
        anggotaFrame.setLocationRelativeTo(null);
        anggotaFrame.setVisible(true);
        anggotaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                anggotaFrame.dispose();
                Abdul07095_GUIMenu men = new Abdul07095_GUIMenu();
            }
        });
            
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // reset
                reset();
            }
        });
        
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Simpan
                try{
                    String noId = txtNoid.getText();
                    String nama = txtNama.getText();
                    String noTelp = txtNotelp.getText();
                    int jenisAnggota = cmbJenis.getSelectedIndex();
                    Objctrl.anggota_c.insertAnggota(noId, nama, noTelp, jenisAnggota);
                    reset();
                    tabelAnggota.setModel(Objctrl.anggota_c.loadDataAnggota());
                    JOptionPane.showMessageDialog(null,"Anggota Berhasil Disimpan", "information", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Format Penulisan Salah", "Simpan Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // edit
                try{
                    String noId = txtNoid.getText();
                    String nama = txtNama.getText();
                    String noTelp = txtNotelp.getText();
                    int jenisAnggota = cmbJenis.getSelectedIndex();
                    Objctrl.anggota_c.updateAnggota(selectedIndex, noId, nama, noTelp, jenisAnggota);
                    reset();
                    tabelAnggota.setModel(Objctrl.anggota_c.loadDataAnggota());
                    JOptionPane.showMessageDialog(null,"Anggota Berhasil Diperbarui", "information", JOptionPane.INFORMATION_MESSAGE);
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Format Penulisan Salah", "Update Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Hapus
                Objctrl.anggota_c.deleteAnggota(selectedIndex);
                reset();
                tabelAnggota.setModel(Objctrl.anggota_c.loadDataAnggota());
                JOptionPane.showMessageDialog(null,"Anggota Berhasil Dihapus", "information", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        tabelAnggota.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e){
                int i = tabelAnggota.getSelectedRow();
                selectedIndex = i;
                txtNoid.setText(Objctrl.anggota_c.loadDataAnggota().getValueAt(i, 0).toString());
                txtNama.setText(Objctrl.anggota_c.loadDataAnggota().getValueAt(i, 1).toString());
                txtNotelp.setText(Objctrl.anggota_c.loadDataAnggota().getValueAt(i, 2).toString());
                cmbJenis.setSelectedItem(Objctrl.anggota_c.loadDataAnggota().getValueAt(i, 3).toString());
                
                txtNoid.setEditable(false);
                btnSimpan.setEnabled(false);
                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
            }
        });
    }
    
    public void reset(){
        txtNoid.setText(null);
        txtNama.setText(null);
        txtNotelp.setText(null);
        cmbJenis.setSelectedItem(null);
        selectedIndex = -1;
        
        txtNoid.setEditable(true);
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
    }
}
