package org.emp.gl.core.launcher;

import java.util.Random;

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
        Random random = new Random();
        int min = 10;
        int max = 20;

        for (int index = 0; index < 10; index++) {
            CompteARebours compteur = new CompteARebours(random.nextInt(max - min + 1) + min, Service);
            Service.addTimeChangeListener(compteur);
        }
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
