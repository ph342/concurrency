package martin;

public class Martin implements Runnable {

    private IBaseMartin control;

    public Martin(IBaseMartin c) {
        control = c;
    }

    public void run() {
        try {
            while(true) {
                control.martinLeave();
                control.martinEnter();
                control.martinExit();
            }
        } catch (InterruptedException e) {}
    }
}