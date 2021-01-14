package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.Abdul07095_AnggotaController;
import Controller.Abdul07095_BukuController;
import Controller.Abdul07095_PeminjamanController;
import Entity.Abdul07095_JenisAnggotaEntity;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;  
import java.util.Calendar;
import java.util.Date;  

/**
 *
 * @author Masjit Subekti
 */
public class Abdul07095_GUIPeminjaman {
    private static Abdul07095_JenisAnggotaEntity ja = new Abdul07095_JenisAnggotaEntity();
    private static String [] statusPeminjaman = {"Belum Dikembalikan", "Dikembalikan"};
    
    JFrame peminjamanFrame = new JFrame();
    JTable tabelPinjam = new JTable();
    JScrollPane scrollable = new JScrollPane(tabelPinjam);
    JButton btnKembali, btnBaru, btnSimpan, btnCariAnggota, btnCariBuku;
    JLabel admin, noidLabel, kodeBukuLabel, noAnggotaLabel, namaAnggotaLabel, jenisAnggotaLabel;
    JTextField txtNoid, txtKodeBuku;
    JPanel panelAnggota;
    DefaultTableModel dtmPeminjaman;
    int indexAnggota = -1;
    int indexBuku = -1;
    
    public Abdul07095_GUIPeminjaman(){
        initComponents();
        setKolom();
        txtKodeBuku.setEditable(false);
        btnCariBuku.setEnabled(false);
        System.out.println("No Peminjaman" + generateNoPinjam());
    }
    
    private void initComponents(){
        peminjamanFrame.setSize(800, 570);
        peminjamanFrame.setLayout(null);
        peminjamanFrame.setTitle("Form Peminjaman");
         
        // Cari Anggota
        noidLabel = new JLabel("No Anggota");
        noidLabel.setBounds(30, 30, 100, 30);
        peminjamanFrame.add(noidLabel);

        txtNoid = new JTextField();
        txtNoid.setBounds(130, 35, 200, 25);
        peminjamanFrame.add(txtNoid);
    
        btnCariAnggota = new JButton("Cari");
        btnCariAnggota.setBounds(350, 35, 70, 25);
        peminjamanFrame.add(btnCariAnggota);
        
        // Detail Anggota
        JLabel labelKetNoid = new JLabel("No Anggota        : ");
        labelKetNoid.setBounds(40, 70, 100, 50);
        peminjamanFrame.add(labelKetNoid);
        
        noAnggotaLabel = new JLabel("");
        noAnggotaLabel.setBounds(145, 70, 500, 50);
        peminjamanFrame.add(noAnggotaLabel);
        
        JLabel labelKetNama = new JLabel("Nama Anggota  : ");
        labelKetNama.setBounds(40, 95, 100, 50);
        peminjamanFrame.add(labelKetNama);
        
        namaAnggotaLabel = new JLabel("");
        namaAnggotaLabel.setBounds(145, 95, 500, 50);
        peminjamanFrame.add(namaAnggotaLabel);
        
        JLabel labelKetJenis = new JLabel("Jenis Anggota   : ");
        labelKetJenis.setBounds(40, 120, 100, 50);
        peminjamanFrame.add(labelKetJenis);
        
        jenisAnggotaLabel = new JLabel("");
        jenisAnggotaLabel.setBounds(145, 120, 500, 50);
        peminjamanFrame.add(jenisAnggotaLabel);
        
        panelAnggota = new JPanel();
        panelAnggota.setBackground(Color.WHITE);
        panelAnggota.setBounds(30, 78, 725, 90);
        peminjamanFrame.add(panelAnggota);
       
        // Cari Buku
        kodeBukuLabel = new JLabel("Kode Buku");
        kodeBukuLabel.setBounds(30, 190, 100, 30);
        peminjamanFrame.add(kodeBukuLabel);
        
        txtKodeBuku = new JTextField();
        txtKodeBuku.setBounds(130, 195, 200, 25);
        peminjamanFrame.add(txtKodeBuku);

        btnCariBuku = new JButton("Cari");
        btnCariBuku.setBounds(350, 195, 70, 25);
        peminjamanFrame.add(btnCariBuku);
        
        // Table Peminjaman
        scrollable.setBounds(30, 240, 725, 200);
        // tabelPinjam.setModel(buku_c.loadDataBuku());
        peminjamanFrame.add(scrollable);
          
        // Action
        btnBaru = new JButton("Baru");
        btnBaru.setBounds(30, 460, 100, 30);
        peminjamanFrame.add(btnBaru);

        btnSimpan = new JButton("Simpan");
        btnSimpan.setBounds(140, 460, 100, 30);
        peminjamanFrame.add(btnSimpan);
        
        btnKembali = new JButton("Keluar");
        btnKembali.setBounds(250, 460, 100, 30);
        peminjamanFrame.add(btnKembali);
        
        peminjamanFrame.setLocationRelativeTo(null);
        peminjamanFrame.setVisible(true);
        peminjamanFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        btnCariAnggota.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cariAnggota();
            }
        });
        
        btnCariBuku.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                cariBuku();
            }
        });
        
        btnSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                simpanPeminjaman();
            }
        });
        
        btnBaru.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                reset();
            }
        });
        
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                peminjamanFrame.dispose();
                Abdul07095_GUIMenu menu = new Abdul07095_GUIMenu();
            }
        });
        
        
        tabelPinjam.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked (MouseEvent e){
                int i = tabelPinjam.getSelectedRow();
                Object[] options = { "Batalkan", "Kembali" };
                int jawab = JOptionPane.showOptionDialog(null, 
                "Buku : "+tabelPinjam.getValueAt(i, 1).toString(),
                "Batalkan Buku", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if(jawab == JOptionPane.YES_OPTION){
                    dtmPeminjaman.removeRow(i);
                }
            }
        });
    }
    
    private void setKolom() {
        Object[] kolom = {"Kode Buku","Judul","Jumlah","Tanggal Pinjam","Tanggal Kembali"};
        dtmPeminjaman = new DefaultTableModel(null, kolom);
        tabelPinjam.setModel(dtmPeminjaman);
    }
    
    public Date generateTanggalKembali(){
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, 7); // set 7 days
        dt = c.getTime();
        return dt;
    }
    
    public String generateNoPinjam(){
        String no;
        Date dt = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        int jml = Objctrl.pinjam_c.viewPeminjaman().size();
        if(jml>0){
            no = "PJ"+formatter.format(dt)+""+jml;
        }else{
            no = "PJ"+formatter.format(dt)+"1";
        }
        return no;
    }
    
    public void reset(){
        txtNoid.setText(null);
        txtKodeBuku.setText(null);
        noAnggotaLabel.setText(null);
        namaAnggotaLabel.setText(null);
        jenisAnggotaLabel.setText(null);
        txtKodeBuku.setEditable(false);
        btnCariBuku.setEnabled(false);
//        dtmPeminjaman.getDataVector().removeAllElements();
        setKolom();
    }
    
    public void cariAnggota(){
        try{
//            anggota_c.dataAnggotaDefault();
            String noId = txtNoid.getText();
            indexAnggota = Objctrl.anggota_c.cari(noId);
            if(indexAnggota==-1){
                JOptionPane.showMessageDialog(null,"Ooops, Anggota tidak ditemukan ! ", "information", JOptionPane.INFORMATION_MESSAGE);
                noAnggotaLabel.setText("");
                namaAnggotaLabel.setText("");
                jenisAnggotaLabel.setText("");
                
                txtKodeBuku.setEditable(false);
                btnCariBuku.setEnabled(false);
            }else{
                noAnggotaLabel.setText(Objctrl.anggota_c.getDetail(indexAnggota).getNoId());
                namaAnggotaLabel.setText(Objctrl.anggota_c.getDetail(indexAnggota).getNama());
                jenisAnggotaLabel.setText(ja.jenisAnggota[Objctrl.anggota_c.getDetail(indexAnggota).getJenisAnggota()]);
                
                txtKodeBuku.setEditable(true);
                btnCariBuku.setEnabled(true);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Internal server error", "information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void cariBuku(){
        try{
            String kodeBuku = txtKodeBuku.getText();
            indexBuku = Objctrl.buku_c.cari(kodeBuku);;
            int jmlBuku = tabelPinjam.getRowCount();
            if(indexBuku==-1){
                JOptionPane.showMessageDialog(null,"Ooops, Buku tidak ditemukan ! ", "information", JOptionPane.INFORMATION_MESSAGE);
                txtKodeBuku.setText(null);
            }else if(jmlBuku==1){
                JOptionPane.showMessageDialog(null,"Ooops, Hanya boleh meminjam 1 buku ! ", "information", JOptionPane.INFORMATION_MESSAGE);
                txtKodeBuku.setText(null);
            }else{
                Object[] options = { "Tambahkan", "Batal" };
                int jawab = JOptionPane.showOptionDialog(null, 
                "Kode Buku : "+Objctrl.buku_c.getDetail(indexBuku).getKodeBuku()+
                "\nJudul : "+Objctrl.buku_c.getDetail(indexBuku).getJudulBuku()+ 
                "\nStok : "+Objctrl.buku_c.getDetail(indexBuku).getStok()+
                "\n",
                "Tambah Buku", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                
                if(jawab == JOptionPane.YES_OPTION){ 
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
                    Date date = new Date();    
                    // Add object book
                    Object[] data = {             
                        Objctrl.buku_c.getDetail(indexBuku).getKodeBuku(), 
                        Objctrl.buku_c.getDetail(indexBuku).getJudulBuku(), 
                        1,
                        formatter.format(date), 
                        formatter.format(generateTanggalKembali())
                    };
                    dtmPeminjaman.addRow(data);
                    JOptionPane.showMessageDialog(null, "Buku berhasil ditambahkan");
                }
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,e, "information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void simpanPeminjaman(){
        int jmlBuku = tabelPinjam.getRowCount();
        if(indexAnggota==-1){
            JOptionPane.showMessageDialog(null,"Harap pilih anggota", "information", JOptionPane.INFORMATION_MESSAGE);
        }else if(jmlBuku<1){
            JOptionPane.showMessageDialog(null,"Harap pilih buku", "information", JOptionPane.INFORMATION_MESSAGE);
        }else{
            int jumlah = Integer.valueOf(tabelPinjam.getValueAt(0, 2).toString());
            String tglPinjam = tabelPinjam.getValueAt(0, 3).toString();
            String tglKembali = tabelPinjam.getValueAt(0, 4).toString();
            Date datePinjam = new Date(tglPinjam);  
            Date dateKembali = new Date(tglKembali);  
            Objctrl.pinjam_c.insertPeminjaman(Objctrl.buku_c.getDetail(indexBuku), Objctrl.anggota_c.getDetail(indexAnggota), jumlah, datePinjam, dateKembali);
            JOptionPane.showMessageDialog(null,"Peminjaman berhasil disimpan ! ", "information", JOptionPane.INFORMATION_MESSAGE);    
            reset();
            viewListPeminjaman();
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
        
        if(Objctrl.pinjam_c.viewPeminjaman().size()>0){
            for (int i=0;i<Objctrl.pinjam_c.viewPeminjaman().size();i++) {
                String namaAnggota = Objctrl.pinjam_c.viewPeminjaman().get(i).getAnggota().getNoId()+ " - " +Objctrl.pinjam_c.viewPeminjaman().get(i).getAnggota().getNama(); 
                String buku = Objctrl.pinjam_c.viewPeminjaman().get(i).getBuku().getKodeBuku()+ " - " +Objctrl.pinjam_c.viewPeminjaman().get(i).getBuku().getJudulBuku(); 
                
                System.out.println(
                        (i+1)+".  |  "
                        + namaAnggota +"  |  "
                        + buku +"  |  "
                        + formatter.format(Objctrl.pinjam_c.viewPeminjaman().get(i).getTglPinjam())+"  |  "
                        + formatter.format(Objctrl.pinjam_c.viewPeminjaman().get(i).getTglKembali())+"  |  "
                        + statusPeminjaman[Integer.parseInt(Objctrl.pinjam_c.viewPeminjaman().get(i).getStatus())]);
                System.out.println("------------------------------------------------------------------------------");
            }
        }else{
            System.out.println("Daftar Peminjaman Kosong !\n");
        }
    }
}
