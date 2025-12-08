package org.emp.gl;

import org.emp.gl.clients.Horloge;

import java.awt.*;

import javax.swing.*;
public class WatchViewer extends JFrame{
    static int COUNT = 0;
    private Horloge horloge = new Horloge("TimerService");

    private ButtonViewer buttonViewer;

    private JLabel hh = new JLabel();
    private JLabel mm = new JLabel();
    private JLabel sep = new JLabel();
    private JLabel mod = new JLabel();

    public WatchViewer() {
        initComponents();
    }

    private void initComponents() {
        buttonViewer = new ButtonViewer(this);
        setTitle("Watch Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(200 + COUNT++ * 300, 400);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        JPanel displayPanel = new JPanel();
        // gbc.insets = new Insets(14, 14, 14, 14);
        // gbc.gridy = 0;
        // gbc.anchor = GridBagConstraints.CENTER;


        hh.setFont(new Font("Consolas", Font.BOLD, 48));
        hh.setText("HH");
        displayPanel.add(hh);

        sep.setFont(new Font("Consolas", Font.BOLD, 48));
        sep.setText(":");
        displayPanel.add(sep);


        mm.setFont(new Font("Consolas", Font.BOLD, 48));
        mm.setText("MM");
        displayPanel.add(mm);
        

        mod.setFont(new Font("Consolas", Font.BOLD, 24));
        mod.setText("M");
        displayPanel.add(mod);

        add(displayPanel, BorderLayout.CENTER);
        add(buttonViewer, BorderLayout.SOUTH);

        pack();
        setVisible(true);
    }

    public Horloge getHorloge() {
        return this.horloge;
    }

    public void doSet() {
        System.out.println(" SET ");
        // TODO
    }

    public void doMode() {
        System.out.println(" MODE ");
        // TODO
    }

    public void ticHappened() {
        System.out.println("TIC - HAPPENED ");
        // TODO
    }

    public void setTextPosition1(String txt) {
        hh.setText(txt);
    }

    public void setTextPosition2(String txt) {
        mm.setText(txt);
    }

    public void setTextSeparator(String txt) {
        sep.setText(txt);
    }

    public void setTextPosition3(String txt) {
        mod.setText(txt);
    }
}
