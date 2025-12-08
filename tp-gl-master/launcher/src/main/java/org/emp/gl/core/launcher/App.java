package org.emp.gl.core.launcher;

import java.util.Random;

import org.emp.Lookup;
import org.emp.gl.HorlogeGUI;
import org.emp.gl.WatchViewer;
import org.emp.gl.clients.CompteARebours;
import org.emp.gl.clients.Horloge;
import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;

/**
 * Hello world!
 *
 */
public class App {
    static Lookup lookup = Lookup.getInstance();

    public static void main(String[] args) {
        TimerService Service = new DummyTimeServiceImpl();
        lookup.subscribeService(TimerService.class, Service);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WatchViewer w = new WatchViewer();
            }
        });
    }

    private static void testDuTimeServiceCompteur(TimerService Service) {
        Random random = new Random();
        int min = 10;
        int max = 20;

        for (int index = 0; index < 10; index++) {
            CompteARebours compteur = new CompteARebours(random.nextInt(max - min + 1) + min);
            Service.addTimeChangeListener(compteur);
        }
        ((DummyTimeServiceImpl) Service).setMinutes(4);
    }

    private static void testDuTimeServiceHorlogeGUI() {
        HorlogeGUI gui = new HorlogeGUI("horloge 1");
    }

    private static void testDuTimeServiceHorloge() {

        Horloge horloge1 = new Horloge("horloge 1");
        Horloge horloge2 = new Horloge("horloge 2");
        Horloge horloge3 = new Horloge("horloge 3");
        Horloge horloge4 = new Horloge("horloge 4");
        Horloge horloge5 = new Horloge("horloge 5");
        TimerService Service = (TimerService) lookup.getService(TimerService.class);
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
