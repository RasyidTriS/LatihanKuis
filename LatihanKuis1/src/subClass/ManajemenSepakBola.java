package subClass;

import abstracts.AbstractMenu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ManajemenSepakBola extends AbstractMenu {
    private JFrame parent;
    
    public ManajemenSepakBola(JFrame parent) {
        super("Sepak Bola");
        this.parent = parent;
        initComponents();
    }
    
    private void initComponents() {
        // Mengatur layout utama dengan BorderLayout
        setLayout(new BorderLayout(10, 10));
        
        // Bagian atas: Label judul
        JLabel titleLabel = new JLabel("Sepak Bola", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(titleLabel, BorderLayout.NORTH);
        
        // Bagian tengah: Panel berisi 2 panel (Merah & Kuning)
        JPanel centerPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        
        // Panel merah
        JPanel redPanel = new JPanel(new BorderLayout());
        redPanel.setBackground(Color.RED);
        JLabel lblMerah = new JLabel("Kartu Merah", SwingConstants.CENTER);
        lblMerah.setForeground(Color.WHITE); // Supaya teks terlihat jelas di background merah
        redPanel.add(lblMerah, BorderLayout.CENTER);
        
        // Panel kuning
        JPanel yellowPanel = new JPanel(new BorderLayout());
        yellowPanel.setBackground(Color.YELLOW);
        JLabel lblKuning = new JLabel("Kartu Kuning", SwingConstants.CENTER);
        lblKuning.setForeground(Color.BLACK);
        yellowPanel.add(lblKuning, BorderLayout.CENTER);
        
        // Event ketika panel merah diklik
        redPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(ManajemenSepakBola.this,
                        "Pemain dikeluarkan!",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        
        // Event ketika panel kuning diklik
        yellowPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane.showMessageDialog(ManajemenSepakBola.this,
                        "Pemain mendapat peringatan!",
                        "Informasi",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        });
        
        // Masukkan panel merah dan kuning ke dalam centerPanel
        centerPanel.add(redPanel);
        centerPanel.add(yellowPanel);
        
        // Tambahkan centerPanel ke layout utama (tengah)
        add(centerPanel, BorderLayout.CENTER);
        
        // Bagian bawah: Tombol "Kembali"
        JPanel bottomPanel = new JPanel();
        bottomPanel.add(backButton);
        add(bottomPanel, BorderLayout.SOUTH);
        
        // Aksi tombol kembali
        backButton.addActionListener(e -> goBack());
    }
    
    @Override
    public void goBack() {
        this.dispose();
        parent.setVisible(true);
    }
}
