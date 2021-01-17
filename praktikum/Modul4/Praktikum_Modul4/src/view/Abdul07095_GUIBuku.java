package view;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIBuku {
    JFrame bukuFrame = new JFrame();
    JTable tabelbuku = new JTable();
    JScrollPane scrollaslab = new JScrollPane(tabelbuku);
    JButton btnKembali, btnReset, btnSimpan, btnEdit, btnHapus;
    JLabel admin, kodebukulabel, judullabel, pengaranglabel, tahunterbitlabel, stoklabel;
    JTextField kodebukutext, judultext, pengarangtext, tahunterbitext, stoktext;
    int selectedIndex = -1;
    public Abdul07095_GUIBuku(){
        bukuFrame.setSize(645, 580);
        bukuFrame.setLayout(null);
        bukuFrame.setTitle("Form Buku");
            
        kodebukulabel = new JLabel("Kode Buku");
        kodebukulabel.setBounds(30, 30, 100, 30);
        bukuFrame.add(kodebukulabel);

        kodebukutext = new JTextField();
        kodebukutext.setBounds(150, 30, 200, 25);
        bukuFrame.add(kodebukutext);

        judullabel = new JLabel("Judul");
        judullabel.setBounds(30, 65, 100, 30);
        bukuFrame.add(judullabel);

        judultext = new JTextField();
        judultext.setBounds(150, 65, 200, 25);
        bukuFrame.add(judultext);

        pengaranglabel = new JLabel("Pengarang");
        pengaranglabel.setBounds(30, 100, 100, 30);
        bukuFrame.add(pengaranglabel);

        pengarangtext = new JTextField();
        pengarangtext.setBounds(150, 100, 200, 25);
        bukuFrame.add(pengarangtext);

        tahunterbitlabel = new JLabel("Tahun Terbit");
        tahunterbitlabel.setBounds(30, 135, 100, 30);
        bukuFrame.add(tahunterbitlabel);

        tahunterbitext = new JTextField();
        tahunterbitext.setBounds(150, 135, 200, 25);
        bukuFrame.add(tahunterbitext);

        stoklabel = new JLabel("Stok");
        stoklabel.setBounds(30, 170, 100, 30);
        bukuFrame.add(stoklabel);

        stoktext = new JTextField();
        stoktext.setBounds(150, 170, 200, 25);
        bukuFrame.add(stoktext);

        btnReset = new JButton("Reset");
        btnReset.setBounds(50, 220, 100, 30);
        bukuFrame.add(btnReset);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(160, 220, 100, 30);
        bukuFrame.add(btnSimpan);

        btnEdit = new JButton("Edit");
        btnEdit.setBounds(270, 220, 100, 30);
        bukuFrame.add(btnEdit);

        btnHapus = new JButton("hapus");
        btnHapus.setBounds(380, 220, 100, 30);
        bukuFrame.add(btnHapus);
        
        scrollaslab.setBounds(30, 270, 570, 200);
        tabelbuku.setModel(Objctrl.buku_c.loadDataBuku());
        bukuFrame.add(scrollaslab);
         
        btnKembali = new JButton("Kembali");
        btnKembali.setBounds(30, 480, 100, 30);
        bukuFrame.add(btnKembali);
        
        bukuFrame.setLocationRelativeTo(null);
        bukuFrame.setVisible(true);
        bukuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                bukuFrame.dispose();
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
                    String kode = kodebukutext.getText();
                    String judul = judultext.getText();
                    String pengarang = pengarangtext.getText();
                    String tahunTerbit = tahunterbitext.getText();
                    int stok = Integer.valueOf(stoktext.getText());
                    Objctrl.buku_c.insertBuku(kode, judul, pengarang, tahunTerbit, stok);
                    JOptionPane.showMessageDialog(null,"Buku Berhasil Disimpan", "information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelbuku.setModel(Objctrl.buku_c.loadDataBuku());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Format Penulisan Salah", "Register Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // edit
                try{
                    String kode = kodebukutext.getText();
                    String judul = judultext.getText();
                    String pengarang = pengarangtext.getText();
                    String tahunTerbit = tahunterbitext.getText();
                    int stok = Integer.valueOf(stoktext.getText());
                    Objctrl.buku_c.updateBuku(selectedIndex, kode, judul, pengarang, tahunTerbit, stok);
                    JOptionPane.showMessageDialog(null,"Buku Berhasil Diperbarui", "information", JOptionPane.INFORMATION_MESSAGE);
                    reset();
                    tabelbuku.setModel(Objctrl.buku_c.loadDataBuku());
                }catch (Exception e){
                    JOptionPane.showMessageDialog(null,"Format Penulisan Salah", "Register Gagal", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        
        btnHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // Hapus
                Objctrl.buku_c.deleteBuku(selectedIndex);
                JOptionPane.showMessageDialog(null,"Buku Berhasil Dihapus", "information", JOptionPane.INFORMATION_MESSAGE);
                reset();
                tabelbuku.setModel(Objctrl.buku_c.loadDataBuku());
            }
        });
        
        tabelbuku.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e){
                int i = tabelbuku.getSelectedRow();
                selectedIndex = i;
                kodebukutext.setText(Objctrl.buku_c.loadDataBuku().getValueAt(i, 0).toString());
                judultext.setText(Objctrl.buku_c.loadDataBuku().getValueAt(i, 1).toString());
                pengarangtext.setText(Objctrl.buku_c.loadDataBuku().getValueAt(i, 2).toString());
                tahunterbitext.setText(Objctrl.buku_c.loadDataBuku().getValueAt(i, 3).toString());
                stoktext.setText(Objctrl.buku_c.loadDataBuku().getValueAt(i, 4).toString());
                
                kodebukutext.setEditable(false);
                btnSimpan.setEnabled(false);
                btnEdit.setEnabled(true);
                btnHapus.setEnabled(true);
            }
        });
        
    }
    
    public void reset(){
        kodebukutext.setText(null);
        judultext.setText(null);
        pengarangtext.setText(null);
        tahunterbitext.setText(null);
        stoktext.setText(null);
        selectedIndex = -1;
        
        kodebukutext.setEditable(true);
        btnSimpan.setEnabled(true);
        btnEdit.setEnabled(false);
        btnHapus.setEnabled(false);
    }
}
