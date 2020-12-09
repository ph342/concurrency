package martin;

import java.util.EventListener;

public interface IMartinEventListener extends EventListener {
    void onChange(MartinState state);
}