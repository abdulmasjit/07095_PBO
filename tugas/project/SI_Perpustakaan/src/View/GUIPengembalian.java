package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Entity.JenisAnggota;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  

/**
 *
 * @author Masjit Subekti
 */
public class GUIPengembalian {
    JFrame pengembalianFrame = new JFrame();
    JTable tabelPinjam = new JTable();
    JButton btnKembali, btnReset, btnUpdate, btnCariAnggota;
    JLabel noAnggotaLabel, namaAnggotaLabel, jenisAnggotaLabel;
    JTextField txtNoid;
    DefaultTableModel dtmPeminjaman;
    private int indexAnggota = -1;
    private int indexPeminjaman = -1;
    
    public GUIPengembalian(){
        initComponents();
        setKolom();
    }
    
    private void initComponents(){
        pengembalianFrame.setSize(800, 570);
        pengembalianFrame.setLayout(null);
        pengembalianFrame.setTitle("Form Pengembalian");
    
        JScrollPane scrollable = new JScrollPane(tabelPinjam);
        JPanel panelAnggota;
        JLabel noidLabel, kodeBukuLabel;
        
        // Cari Anggota
        noidLabel = new JLabel("No Anggota");
        noidLabel.setBounds(30, 30, 100, 30);
        pengembalianFrame.add(noidLabel);

        txtNoid = new JTextField();
        txtNoid.setBounds(130, 35, 200, 25);
        pengembalianFrame.add(txtNoid);
    
        btnCariAnggota = new JButton("Cari");
        btnCariAnggota.setBounds(350, 35, 70, 25);
        pengembalianFrame.add(btnCariAnggota);
        
        // Detail Anggota
        JLabel labelKetNoid = new JLabel("No Anggota        : ");
        labelKetNoid.setBounds(40, 70, 100, 50);
        pengembalianFrame.add(labelKetNoid);
        
        noAnggotaLabel = new JLabel("");
        noAnggotaLabel.setBounds(145, 70, 500, 50);
        pengembalianFrame.add(noAnggotaLabel);
        
        JLabel labelKetNama = new JLabel("Nama Anggota  : ");
        labelKetNama.setBounds(40, 95, 100, 50);
        pengembalianFrame.add(labelKetNama);
        
        namaAnggotaLabel = new JLabel("");
        namaAnggotaLabel.setBounds(145, 95, 500, 50);
        pengembalianFrame.add(namaAnggotaLabel);
        
        JLabel labelKetJenis = new JLabel("Jenis Anggota   : ");
        labelKetJenis.setBounds(40, 120, 100, 50);
        pengembalianFrame.add(labelKetJenis);
        
        jenisAnggotaLabel = new JLabel("");
        jenisAnggotaLabel.setBounds(145, 120, 500, 50);
        pengembalianFrame.add(jenisAnggotaLabel);
        
        panelAnggota = new JPanel();
        panelAnggota.setBackground(Color.WHITE);
        panelAnggota.setBounds(30, 78, 725, 90);
        pengembalianFrame.add(panelAnggota);
       
        // Cari Buku
        kodeBukuLabel = new JLabel("Daftar Peminjaman");
        kodeBukuLabel.setBounds(30, 190, 200, 30);
        pengembalianFrame.add(kodeBukuLabel);
        
        // Table Peminjaman
        scrollable.setBounds(30, 240, 725, 200);
        // tabelPinjam.setModel(buku_c.loadDataBuku());
        pengembalianFrame.add(scrollable);
        
        // Action
        btnReset = new JButton("Reset");
        btnReset.setBounds(30, 460, 100, 30);
        pengembalianFrame.add(btnReset);

        btnUpdate = new JButton("Simpan");
        btnUpdate.setBounds(140, 460, 100, 30);
        pengembalianFrame.add(btnUpdate);
        
        btnKembali = new JButton("Keluar");
        btnKembali.setBounds(250, 460, 100, 30);
        pengembalianFrame.add(btnKembali);
        
        pengembalianFrame.setLocationRelativeTo(null);
        pengembalianFrame.setVisible(true);
        pengembalianFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnCariAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cariAnggota();
            }
        });
       
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                updateStatusPeminjaman();
            }
        });
        
        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                reset();
            }
        });
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                pengembalianFrame.dispose();
                GUIMenu menu = new GUIMenu();
            }
        });
    }
    
    private void setKolom() {
        Object[] kolom = {"Kode Buku","Judul","Jumlah","Tanggal Pinjam","Tanggal Kembali","Status"};
        dtmPeminjaman = new DefaultTableModel(null, kolom);
        tabelPinjam.setModel(dtmPeminjaman);
    }
    
    public void reset(){
        txtNoid.setText(null);
        noAnggotaLabel.setText(null);
        namaAnggotaLabel.setText(null);
        jenisAnggotaLabel.setText(null);
        indexPeminjaman = -1;
        indexAnggota = -1;
        setKolom();
    }
    
    public void cariAnggota(){
        try{
            String noId = txtNoid.getText();
            indexAnggota = Objection.anggota_c.cari(noId);
            // Cek Anggota
            if(indexAnggota==-1){
                JOptionPane.showMessageDialog(null,"Ooops, Anggota tidak ditemukan ! ", "information", JOptionPane.INFORMATION_MESSAGE);
                txtNoid.setText(null);
                noAnggotaLabel.setText("");
                namaAnggotaLabel.setText("");
                jenisAnggotaLabel.setText("");
            }else{
                // Cek Tanggungan Peminjaman            
                indexPeminjaman = Objection.pinjam_c.cekPeminjamanAnggota(noId, "0");
                if(indexPeminjaman == -1){
                    JOptionPane.showMessageDialog(null,"Ooops, Anggota tidak mempunyai tanggungan peminjaman ! ", "information", JOptionPane.INFORMATION_MESSAGE);
                    txtNoid.setText(null);
                    indexAnggota = -1;
                }else{
                    noAnggotaLabel.setText(Objection.anggota_c.getDetail(indexAnggota).getNoId());
                    namaAnggotaLabel.setText(Objection.anggota_c.getDetail(indexAnggota).getNama());
                    jenisAnggotaLabel.setText(Objection.ja.jenisAnggota[Objection.anggota_c.getDetail(indexAnggota).getJenisAnggota()]);
                    
                    setKolom();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");      
                    Object[] data = {             
                        Objection.pinjam_c.getDetail(indexPeminjaman).getBuku().getKodeBuku(), 
                        Objection.pinjam_c.getDetail(indexPeminjaman).getBuku().getJudulBuku(), 
                        1,
                        formatter.format(Objection.pinjam_c.getDetail(indexPeminjaman).getTglPinjam()), 
                        formatter.format(Objection.pinjam_c.getDetail(indexPeminjaman).getTglPinjam()),
                        Objection.statusPeminjaman[Integer.parseInt(Objection.pinjam_c.getDetail(indexPeminjaman).getStatus())]
                    };
                    dtmPeminjaman.addRow(data);
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Internal server error", "information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
    public void updateStatusPeminjaman(){
        try {
            if(indexAnggota==-1){
                JOptionPane.showMessageDialog(null,"Ooops, Harap pilih anggota ! ", "information", JOptionPane.INFORMATION_MESSAGE);
            }else{
                Object[] options = { "Simpan", "Batal" };
                int jawab = JOptionPane.showOptionDialog(null, 
                "Simpan pengembalian !",
                "Pengembalian", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

                if(jawab == JOptionPane.YES_OPTION){ 
                    Objection.pinjam_c.updateStatus(indexAnggota, Objection.pinjam_c.getDetail(indexPeminjaman));
                    JOptionPane.showMessageDialog(null, "Pengembalian buku sukses");
                    reset();
                    viewListPeminjaman();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void viewListPeminjaman(){
        // mencetak daftar peminjaman buku
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy"); 
        System.out.println ("\r");
        System.out.println("Daftar Peminjaman Buku");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("No. |  Nama Anggota  |  Buku  |  Tgl Pinjam  |  Tgl Kembali  |  Status");
        System.out.println("------------------------------------------------------------------------------");
        
        if(Objection.pinjam_c.listPeminjaman().size()>0){
            for (int i=0;i<Objection.pinjam_c.listPeminjaman().size();i++) {
                String namaAnggota = Objection.pinjam_c.listPeminjaman().get(i).getAnggota().getNoId()+ " - " +Objection.pinjam_c.listPeminjaman().get(i).getAnggota().getNama(); 
                String buku = Objection.pinjam_c.listPeminjaman().get(i).getBuku().getKodeBuku()+ " - " +Objection.pinjam_c.listPeminjaman().get(i).getBuku().getJudulBuku(); 
                
                System.out.println(
                        (i+1)+".  |  "
                        + namaAnggota +"  |  "
                        + buku +"  |  "
                        + formatter.format(Objection.pinjam_c.listPeminjaman().get(i).getTglPinjam())+"  |  "
                        + formatter.format(Objection.pinjam_c.listPeminjaman().get(i).getTglKembali())+"  |  "
                        + Objection.statusPeminjaman[Integer.parseInt(Objection.pinjam_c.listPeminjaman().get(i).getStatus())]);
                System.out.println("------------------------------------------------------------------------------");
            }
        }else{
            System.out.println("Daftar Peminjaman Kosong !\n");
        }
    }
}
