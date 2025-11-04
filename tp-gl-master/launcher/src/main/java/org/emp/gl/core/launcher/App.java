package org.emp.gl.core.launcher;

import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge ;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;
/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        TimerService Service = new DummyTimeServiceImpl();
        testDuTimeServiceCompteur(Service); // remplace par testDuTimeServiceHorloge
    }

    private static void testDuTimeServiceCompteur(TimerService Service)
    {
        CompteARebours compteur = new CompteARebours(5,Service);
        CompteARebours compteur2 = new CompteARebours(5,Service);
        CompteARebours compteur3 = new CompteARebours(5,Service);
        CompteARebours compteur4 = new CompteARebours(5,Service);
        CompteARebours compteur5 = new CompteARebours(5,Service);
        Service.addTimeChangeListener(compteur);
        Service.addTimeChangeListener(compteur2);
        Service.addTimeChangeListener(compteur3);
        Service.addTimeChangeListener(compteur4);
        Service.addTimeChangeListener(compteur5);
        ((DummyTimeServiceImpl) Service).setMinutes(4);
    }

    private static void testDuTimeServiceHorloge(TimerService Service)
    {
        Horloge horloge1 = new Horloge("horloge 1",Service);
        Horloge horloge2 = new Horloge("horloge 2",Service);
        Horloge horloge3 = new Horloge("horloge 3",Service);
        Horloge horloge4 = new Horloge("horloge 4",Service);
        Horloge horloge5 = new Horloge("horloge 5",Service);
        Service.addTimeChangeListener(horloge1);
        Service.addTimeChangeListener(horloge2);
        Service.addTimeChangeListener(horloge3);
        Service.addTimeChangeListener(horloge4);
        Service.addTimeChangeListener(horloge5);
        ((DummyTimeServiceImpl) Service).setMinutes(4);
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
