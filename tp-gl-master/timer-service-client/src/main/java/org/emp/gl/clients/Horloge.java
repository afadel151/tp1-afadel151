package org.emp.gl.clients;

import java.beans.PropertyChangeEvent;

import org.emp.gl.timer.service.TimerChangeListener;
import org.emp.gl.timer.service.TimerService;
import org.emp.Lookup;

public class Horloge implements TimerChangeListener {

    String name;
    private final TimerService timerService;
    int seconds;
    int minutes;
    int hours;

    public Horloge(String name) {
        Lookup lookup = Lookup.getInstance();
        this.name = name;
        this.timerService = (TimerService) lookup.getService(TimerService.class);
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
            seconds = timerService.getSecondes();
            minutes = timerService.getMinutes();
            hours = timerService.getHeures();
            System.out.println(name + "affiche"
                    + timerService.getHeures() + ":"
                    + timerService.getMinutes() + ":"
                    + timerService.getSecondes());
        }
    }

    void secondElapsed() {
        seconds = (seconds + 1) % 60;
        if (seconds == 0) {
            minutes = (minutes + 1) % 60;
            if (minutes == 0)
                hours = (hours + 1) % 24;
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent event) {
        switch (event.getPropertyName()) {
            case SECONDE_PROP:
                this.afficherHeure();
                secondElapsed();
                break;

            default:
                break;
        }
    }

    public void incrementSecond() {
        seconds = (seconds + 1) % 60;
    }

    public void incrementMinutes() {
        seconds = (minutes + 1) % 60;
    }

    public void incrementHours() {
        seconds = (hours + 1) % 24;
    }

    public int getHours() {
        return hours;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

}
