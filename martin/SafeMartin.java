package martin;

import javax.swing.event.EventListenerList;

public class SafeMartin extends UnsafeMartin {

    private EventListenerList listenerList;
    protected Gate gate;
    protected MartinState state;

    public SafeMartin(IMartinEventListener l) {
        super();
        gate = new Gate();
        listenerList = new EventListenerList();
        listenerList.add(IMartinEventListener.class, l);
        state = new MartinState();
    }

    public synchronized void enemyEnter(Enemy e) throws InterruptedException {
        while(!gate.isRaised()) wait();
        ++enemyCount;
        light.turnOn();
        state.onRoad.add(e);
        onChange();
    }

    public synchronized void enemyExit(Enemy e) {
        --enemyCount;
        if (enemyCount == 0) {
            light.turnOff();
            notifyAll(); // if Martin is waiting, wake him up
        }
        state.onRoad.remove(e);
        onChange();
    }

    public synchronized void martinLeave() {
        gate.lower();
        state.martinAtRoad = true;
        onChange();
    }

    public synchronized void martinEnter() throws InterruptedException {
        while (light.isOn()) wait();
        state.martinOnRoad = true;
        state.martinAtRoad = false;
        onChange();
    }

    public synchronized void martinExit()  {
        gate.raise();
        state.martinOnRoad = false;
        notifyAll(); // if enemies are waiting, wake them up
        onChange();
    }

    protected synchronized void onChange() {
        IMartinEventListener[] ls = listenerList.getListeners(IMartinEventListener.class);
        state.indicatorIsOn = light.isOn();
        state.gateIsUp = gate.isRaised();
        for (IMartinEventListener l : ls) {
            l.onChange(state);
        }
    }
}