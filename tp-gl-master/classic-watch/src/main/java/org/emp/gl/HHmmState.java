package org.emp.gl;

public class HHmmState implements WatchState{
    private WatchViewer watchViewer;

    public HHmmState(WatchViewer v)
    {
        this.watchViewer = v;
    }
    public void onSet() {
        watchViewer.setState(new SecondsState(watchViewer));
        watchViewer.updateDisplay();
    }
    
    public void onMode() {
        watchViewer.setState(new ChronometerState(watchViewer));
    }

    public void updateDisplay() {
        int h = watchViewer.getHorloge().getHours();
        int m = watchViewer.getHorloge().getMinutes();

        watchViewer.setTextPosition1(String.format("%02d", h));
        watchViewer.setTextPosition2(String.format("%02d", m));

        if (":".equals(watchViewer.getSep().getText()))
            watchViewer.setTextSeparator(" ");
        else
            watchViewer.setTextSeparator(":");

        watchViewer.setTextPosition3("T"); 
    }
    
}
