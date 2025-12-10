package org.emp.gl;

import org.emp.gl.clients.Horloge;

public class SettingsState implements WatchState {

    private enum Field { HOURS, MINUTES, SECONDS }

    private Field field = Field.HOURS;
    private WatchViewer watchViewer;
    private Horloge horloge;

    public SettingsState(WatchViewer v) {
        this.watchViewer = v;
        this.horloge = v.getHorloge();
        this.horloge.lock();
        updateDisplay();
    }

    @Override
    public void updateDisplay() {
        watchViewer.setTextPosition1(String.format("%02d", horloge.getHours()));
        watchViewer.setTextSeparator(":");
        watchViewer.setTextPosition2(String.format("%02d", horloge.getMinutes()));
        watchViewer.setTextPosition3("S"); // mode settings
    }

    @Override
    public void onMode() {
        switch (field) {
            case HOURS:
                field = Field.MINUTES;
                break;
            case MINUTES:
                field = Field.SECONDS;
                break;
            case SECONDS:
                horloge.unlock();
                watchViewer.setState(new HHmmState(watchViewer));
                watchViewer.updateDisplay();
                return;
        }
        updateDisplay();
    }

    @Override
    public void onSet() {
        switch (field) {
            case HOURS:
                horloge.setHours((horloge.getHours() + 1) % 24);
                break;

            case MINUTES:
                horloge.setMinutes((horloge.getMinutes() + 1) % 60);
                break;

            case SECONDS:
                horloge.setSeconds((horloge.getSeconds() + 1) % 60);
                break;
        }

        updateDisplay();
    }
}
