package org.emp.gl;

public class SecondsState  implements WatchState{
 
    private WatchViewer watchViewer;

    public SecondsState(WatchViewer v)
    {
        this.watchViewer = v;
    }

    public void onSet() {
        watchViewer.setState(new HHmmState(watchViewer));
    }

    public void onMode() {
        watchViewer.setState(new ChronometerState(watchViewer));
    }

    public void updateDisplay() {
        watchViewer.setTextPosition1(" ");
        watchViewer.setTextSeparator(":");
        watchViewer.setTextPosition2(String.format("%02d", watchViewer.getHorloge().getSeconds()));

        watchViewer.setTextPosition3("T");
    }
}
