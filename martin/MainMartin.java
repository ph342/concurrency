package martin;

import java.util.ArrayList;

public class MainMartin implements IMartinEventListener {

    private static final int numberOfEnemies = 10;
    private SafeMartin controller;
    private Thread martin;
    private Thread[] enemies;

    public void main() {
        controller = new SafeMartin(this);
        martin  = new Thread(new Martin(controller));
        enemies = new Thread[numberOfEnemies];

        //initialise enemies
        for(int i = 0; i < numberOfEnemies; ++i)
            enemies[i] = new Thread(new Enemy(controller, i + 1));

        //start the threads
        for(Thread e : enemies)
            e.start();
        martin.start();
    }

    public void onChange(MartinState state) {
        System.out.println("The gate is" + (state.gateIsUp ? " raised." : " lowered."));
        if (state.onRoad.isEmpty())
            System.out.println("No enemies are on the road.");
        else {
            for(Enemy e : state.onRoad)
                System.out.println("Enemy " + e.getId() + " is on the road.");
        }
        System.out.println("The warning indicator is" + (state.indicatorIsOn ? " on." : " off."));
        if (state.martinAtRoad) System.out.println("Martin left his house and is waiting.");
        System.out.println("Martin is" + (state.martinOnRoad ? " " : " not ") + "on the road.");
        System.out.println("\n===========================================\n");
        System.out.flush();
    }

    public static void main(String[] args) {
        (new MainMartin()).main();
    }
}