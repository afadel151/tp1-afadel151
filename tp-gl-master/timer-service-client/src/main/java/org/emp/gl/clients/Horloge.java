package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.Lookup;
public class Horloge implements TimerChangeListener {

    String name;
    private final TimerService timerService;

    public Horloge(String name) {
        Lookup lookup = Lookup.getInstance();
        this.name = name;
        this.timerService = (TimerService)lookup.getService(TimerService.class);
        if (this.timerService != null) {
            System.out.println("Horloge " + name + " initialized! with timer service");
            init();
        }
    }

    private void init() {
        this.timerService.addTimeChangeListener(this);
    }

    public void afficherHeure() {
        if (timerService != null) {
            System.out.println(name + " affiche "
                    + timerService.getHeures() + ":"
                    + timerService.getMinutes() + ":"
                    + timerService.getSecondes());
        }
    }
    
   
    @Override
    public  void propertyChange(PropertyChangeEvent event)
    {
        switch (event.getPropertyName()) {
            case SECONDE_PROP:
                    this.afficherHeure();
                break;
        
            default:
                break;
        }
    }
        
}
