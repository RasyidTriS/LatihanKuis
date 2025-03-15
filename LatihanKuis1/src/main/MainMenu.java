package main;

import javax.swing.*;
import java.awt.*;
import subClass.CerdasCermat;
import subClass.ManajemenSepakBola;

public class MainMenu extends JFrame {
    public MainMenu() {
        super("Menu Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1, 10, 10));
        
        JLabel label = new JLabel("Pilih Aplikasi", SwingConstants.CENTER);
        JButton btnCerdas = new JButton("Aplikasi Cerdas Cermat");
        JButton btnSepakbola = new JButton("Aplikasi Manajemen Sepak Bola");
        
        btnCerdas.addActionListener(e -> {
            new CerdasCermat(MainMenu.this).setVisible(true);
            MainMenu.this.setVisible(false);
        });
        
        btnSepakbola.addActionListener(e -> {
            new ManajemenSepakBola(MainMenu.this).setVisible(true);
            MainMenu.this.setVisible(false);
        });
        
        add(label);
        add(btnCerdas);
        add(btnSepakbola);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
