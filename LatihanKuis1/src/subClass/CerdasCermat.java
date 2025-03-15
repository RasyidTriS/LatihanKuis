package subClass;

import abstracts.AbstractMenu;
import javax.swing.*;
import java.awt.*;

public class CerdasCermat extends AbstractMenu {
    private JFrame parent;
    
    // Field untuk input
    private JTextField txtAngka1, txtAngka2;
    
    // Field untuk hasil
    private JTextField txtPenjumlahan, txtPengurangan, txtPerkalian, txtPembagian;
    
    public CerdasCermat(JFrame parent) {
        super("Cerdas Cermat");
        this.parent = parent;
        initComponents();
    }
    
    private void initComponents() {
        // Gunakan BorderLayout pada frame utama
        setLayout(new BorderLayout(10, 10));
        
        // 1. Bagian atas (NORTH) → Label judul
        JLabel lblTitle = new JLabel("Cerdas Cermat", SwingConstants.CENTER);
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        add(lblTitle, BorderLayout.NORTH);
        
        // 2. Bagian tengah (CENTER) → Panel utama
        //    Di dalamnya kita buat sub-panel dengan GridLayout untuk menampung form input & hasil
        JPanel mainPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        
        // Baris 1: Label "Angka 1" dan textfield
        JLabel lblAngka1 = new JLabel("Angka 1", SwingConstants.CENTER);
        txtAngka1 = new JTextField();
        mainPanel.add(lblAngka1);
        mainPanel.add(txtAngka1);
        
        // Baris 2: Label "Angka 2" dan textfield
        JLabel lblAngka2 = new JLabel("Angka 2", SwingConstants.CENTER);
        txtAngka2 = new JTextField();
        mainPanel.add(lblAngka2);
        mainPanel.add(txtAngka2);
        
        // Baris 3: Tombol "Hasil" (tengah) → kita pakai 2 kolom, jadi satu kolom kosong atau di-spacer
        // Anda bisa gunakan panel khusus untuk memusatkan tombol
        JButton btnHasil = new JButton("Hasil");
        mainPanel.add(new JLabel());  // Kosongkan satu sel
        mainPanel.add(btnHasil);
        
        // Baris 4: Label "Hasil Penjumlahan" & textfield
        JLabel lblPenjumlahan = new JLabel("Hasil Penjumlahan", SwingConstants.CENTER);
        txtPenjumlahan = new JTextField();
        txtPenjumlahan.setEditable(false);
        mainPanel.add(lblPenjumlahan);
        mainPanel.add(txtPenjumlahan);
        
        // Baris 5: Label "Hasil Pengurangan" & textfield
        JLabel lblPengurangan = new JLabel("Hasil Pengurangan", SwingConstants.CENTER);
        txtPengurangan = new JTextField();
        txtPengurangan.setEditable(false);
        mainPanel.add(lblPengurangan);
        mainPanel.add(txtPengurangan);
        
        // Baris 6: Label "Hasil Perkalian" & textfield
        JLabel lblPerkalian = new JLabel("Hasil Perkalian", SwingConstants.CENTER);
        txtPerkalian = new JTextField();
        txtPerkalian.setEditable(false);
        mainPanel.add(lblPerkalian);
        mainPanel.add(txtPerkalian);
        
        // Baris 7: Label "Hasil Pembagian" & textfield
        JLabel lblPembagian = new JLabel("Hasil Pembagian", SwingConstants.CENTER);
        txtPembagian = new JTextField();
        txtPembagian.setEditable(false);
        mainPanel.add(lblPembagian);
        mainPanel.add(txtPembagian);
        
        // GridLayout di atas butuh 7 baris total, sementara kita definisikan 5.  
        // Solusinya: ubah `new GridLayout(5, 2, 10, 10)` → `new GridLayout(7, 2, 10, 10)`  
        // ATAU kombinasikan baris 4 & 5, baris 6 & 7 dalam satu baris.  
        // Di contoh ini, kita tambahkan baris-baris.  
        // Revisi: ubah ke 7 baris:
        mainPanel.setLayout(new GridLayout(7, 2, 10, 10));
        
        // Tambahkan panel ke bagian tengah
        add(mainPanel, BorderLayout.CENTER);
        
        // 3. Bagian bawah (SOUTH) → Tombol Kembali
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Action Listener Tombol "Hasil"
        btnHasil.addActionListener(e -> hitungOperasi());
        
        // Action Listener Tombol "Kembali"
        backButton.addActionListener(e -> goBack());
    }
    
    private void hitungOperasi() {
        try {
            double angka1 = Double.parseDouble(txtAngka1.getText());
            double angka2 = Double.parseDouble(txtAngka2.getText());
            
            double penjumlahan = angka1 + angka2;
            double pengurangan = angka1 - angka2;
            double perkalian   = angka1 * angka2;
            String pembagian;
            
            if (angka2 == 0) {
                pembagian = "Tidak bisa dibagi 0";
            } else {
                double bagi = angka1 / angka2;
                pembagian = String.valueOf(bagi);
            }
            
            // Tampilkan hasil ke masing-masing text field
            txtPenjumlahan.setText(String.valueOf(penjumlahan));
            txtPengurangan.setText(String.valueOf(pengurangan));
            txtPerkalian.setText(String.valueOf(perkalian));
            txtPembagian.setText(pembagian);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this, 
                "Input harus berupa angka!", 
                "Error", 
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    @Override
    public void goBack() {
        this.dispose();
        parent.setVisible(true);
    }
}
