package org.emp.gl.core.launcher;


import org.emp.Lookup;
import org.emp.gl.WatchViewer;

import org.emp.gl.time.service.impl.DummyTimeServiceImpl;
import org.emp.gl.timer.service.TimerService;


public class App {
    static Lookup lookup = Lookup.getInstance();

    public static void main(String[] args) {
        TimerService Service = new DummyTimeServiceImpl();
        lookup.subscribeService(TimerService.class, Service);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                WatchViewer w = new WatchViewer();
                Service.addTimeChangeListener(w);
            }
        });
    }


}
