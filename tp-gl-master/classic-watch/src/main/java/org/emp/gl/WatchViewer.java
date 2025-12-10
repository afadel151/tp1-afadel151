package org.emp.gl;

import org.emp.gl.clients.Horloge;
import org.emp.gl.timer.service.TimerChangeListener;

import java.awt.*;
import java.beans.PropertyChangeEvent;

import javax.swing.*;

public class WatchViewer extends JFrame implements TimerChangeListener{
    static int COUNT = 0;
    private WatchState state;
    private Horloge horloge = new Horloge("TimerService");
    private Chronometer chrono;
    private ButtonViewer buttonViewer;

    private JLabel hh = new JLabel();
    private JLabel mm = new JLabel();
    private JLabel sep = new JLabel();
    private JLabel mod = new JLabel();


    public WatchViewer() {
        chrono = new Chronometer();

        initComponents();
    }

    public Chronometer getChrono() {
        return chrono;
    }
    private void initComponents() {
        state = new HHmmState(this);
        state.updateDisplay();
        buttonViewer = new ButtonViewer(this);

        setTitle("Watch Viewer");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocation(200 + COUNT++ * 300, 400);

        Container content = getContentPane();
        content.setLayout(new BorderLayout());
        JPanel displayPanel = new JPanel();
   


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
        state.onSet();
    }

    public void doMode() {
        state.onMode();
    }

    public void ticHappened() 
    {
        state.updateDisplay();
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
    public void setState(WatchState newState)
    {
        this.state = newState;
    }
    public JLabel getSep()
    {
        return this.sep;
    }

    @Override 
    public void propertyChange(PropertyChangeEvent event)
    {
        if (! (this.state instanceof SettingsState)) {
            ticHappened();
        }
    }

    public void updateDisplay()
    {
        state.updateDisplay();
    }
}
