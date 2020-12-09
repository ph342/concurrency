package martin;

public class Enemy implements Runnable {

    private IBaseMartin control;
    private int enemyId;

    public Enemy(IBaseMartin c, int id) {
        control = c;
        enemyId = id;
    }

    public int getId() {
        return enemyId;
    }

    public void run() {
        try {
            while(true) {
                control.enemyEnter(this);
                control.enemyExit(this);
            }
        } catch (InterruptedException e) {}
    }
}