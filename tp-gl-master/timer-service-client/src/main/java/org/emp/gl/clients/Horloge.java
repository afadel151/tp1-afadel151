package org.emp.gl.clients ; 

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService ; 


public class Horloge implements TimerChangeListener {

    String name; 
    private final TimerService timerService ; 


    public Horloge (String name,TimerService timerService) {
        this.name = name ; 
        this.timerService = timerService;
        System.out.println ("Horloge "+name+" initialized! with timer service") ;
        init();
    }

    private void init() {
        this.timerService.addTimeChangeListener(this);
    }

    public void afficherHeure () {
        if (timerService != null)
            System.out.println (name + " affiche " + 
                                timerService.getHeures() +":"+
                                timerService.getMinutes()+":"+
                                timerService.getSecondes()) ;
    }

    @Override
    public void propertyChange(String prop, Object oldValue, Object newValue){
        switch (prop) {
            case DIXEME_DE_SECONDE_PROP:
                System.out.println("Dixième de seconde changed from " + oldValue + " to " + newValue);
                break;
            case SECONDE_PROP:
                System.out.println("Seconde changed from " + oldValue + " to " + newValue);
                break;
            case MINUTE_PROP:
                System.out.println("Minute changed from " + oldValue + " to " + newValue);
                break;
            case HEURE_PROP:
                System.out.println("Heure changed from " + oldValue + " to " + newValue);
                break;
            default:
                break;
        }
    }   
}
