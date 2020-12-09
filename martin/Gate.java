package martin;

public class Gate {

    private boolean up = true;

    public boolean isRaised() {
        return up;
    }

    public void lower() {
        up = false;
    }

    public void raise() {
        up = true;
    }
}