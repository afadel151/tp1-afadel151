package org.emp.gl;

public class ChronometerState implements WatchState {

    private WatchViewer watchViewer;
    private Chronometer c;

    public ChronometerState(WatchViewer v)
    {
        this.watchViewer = v;
        c = watchViewer.getChrono();
        updateDisplay();

    }


    public void updateDisplay()
    {
        watchViewer.setTextPosition1(String.format("%02d", c.getSecondes()));
        watchViewer.setTextSeparator(":");
        watchViewer.setTextPosition2(String.valueOf(c.getDizieme()));
        watchViewer.setTextPosition3("C");
    }

    public void onMode() {
        if (!c.isRunning() && (c.getSecondes() != 0 || c.getDizieme() != 0)) {
            c.reset();
            updateDisplay();
        } else {
            watchViewer.setState(new SettingsState(watchViewer));
            watchViewer.updateDisplay();
        }
    }
    

    public void onSet() {
        if (c.isRunning()) 
            c.stop();
        else 
            c.start();
    }
    

}
