package org.emp.gl;

public class SecondsState implements WatchState {
    private WatchViewer watchViewer;

    public SecondsState(WatchViewer viewer) {
        this.watchViewer = viewer;
    }

    @Override
    public void onSet() {
        // Retour à l'affichage HH:mm
        watchViewer.setState(new HHmmState(watchViewer));
        watchViewer.updateDisplay();
    }

    @Override
    public void onMode() {
        watchViewer.setState(new ChronometerState(watchViewer));
    }

    @Override
    public void updateDisplay() {
        int m = watchViewer.getHorloge().getMinutes();
        int s = watchViewer.getHorloge().getSeconds();

        watchViewer.setTextPosition1(String.format("%02d", m)); 
        watchViewer.setTextPosition2(String.format("%02d", s)); 

        if (":".equals(watchViewer.getSep().getText()))
            watchViewer.setTextSeparator(" ");
        else
            watchViewer.setTextSeparator(":");

        watchViewer.setTextPosition3("S"); 
    }
}
