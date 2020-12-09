package martin;

public class UnsafeMartin implements IBaseMartin {

    protected int enemyCount = 0;
    protected WarningIndicator light;

    public UnsafeMartin() {
        super();
        light = new WarningIndicator();
    }

    public synchronized void enemyEnter(Enemy e) throws InterruptedException {
        ++enemyCount;
        light.turnOn();
    }

    public synchronized void enemyExit(Enemy e) {
        --enemyCount;
        if (enemyCount == 0) {
            light.turnOff();
            notifyAll(); // if Martin is waiting, wake him up
        }
    }

    public synchronized void martinEnter() throws InterruptedException {
        while (light.isOn()) wait();
    }

    public synchronized void martinLeave() {}
    public synchronized void martinExit()  {}
}