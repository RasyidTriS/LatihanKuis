package abstracts;

import javax.swing.*;
import interfaces.Backable;
import java.awt.*;

public abstract class AbstractMenu extends JFrame implements Backable {
    protected JButton backButton;
    
    public AbstractMenu(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        initBackButton();
    }
    
    private void initBackButton() {
        backButton = new JButton("Kembali");
    }
    
    public JButton getBackButton() {
        return backButton;
    }
}
