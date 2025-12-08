package org.emp.gl;

import java.awt.*;
import javax.swing.*;

public class ButtonViewer extends JPanel {
    private WatchViewer watchViewer;
    private JButton setButton;
    private JButton modeButton;

    public ButtonViewer(WatchViewer w) {
        this.watchViewer = w;
        initComponents();
    }

    private void initComponents() {
        setLayout(new GridBagLayout()); 
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(21, 2, 21, 2);

        setButton = new JButton("Set");
        setButton.setFont(new Font("Consolas", Font.BOLD, 32));
        add(setButton, gbc);

        modeButton = new JButton("Mode");
        modeButton.setFont(new Font("Consolas", Font.BOLD, 32));
        gbc.gridx = 1;
        add(modeButton, gbc);

        setButton.addActionListener(e -> watchViewer.doSet());
        modeButton.addActionListener(e -> watchViewer.doMode());
    }
}
