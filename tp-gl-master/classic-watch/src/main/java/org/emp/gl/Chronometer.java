package org.emp.gl;

import java.beans.PropertyChangeEvent;

import org.emp.Lookup;
import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;

public class Chronometer implements TimerChangeListener{
 
    private int dizieme = 0;
    private int secondes = 0;

    private boolean running = false;

    public Chronometer()
    {
        TimerService ts = Lookup.getInstance().getService(TimerService.class);
        ts.addTimeChangeListener(this);
    }
    public void start() { running = true; }
    public void stop() { running = false; }
    public void reset() {
        dizieme = 0;
        secondes = 0;
    }
    public boolean isRunning() { return running; }
    @Override
    public void propertyChange(PropertyChangeEvent e) {
        if (!running) return;

        switch (e.getPropertyName()) {
            case DIXEME_DE_SECONDE_PROP:
                dizieme = (dizieme + 1) % 10;
                if (dizieme == 0){
                    secondes = (secondes + 1) % 60;
                }
                break;

            default:
                break;
        }
    }    
    public int getSecondes() { return secondes; }
    public int getDizieme() { return dizieme; }
}
