package martin;

import java.util.ArrayList;

public class MartinState {
    public ArrayList<Enemy> onRoad;
    public boolean martinAtRoad;
    public boolean martinOnRoad;
    public boolean indicatorIsOn;
    public boolean gateIsUp;

    public MartinState() {
        onRoad = new ArrayList<Enemy>();
    }
}