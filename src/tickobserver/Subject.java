package tickobserver;

import farmfactory.Farm;

public interface Subject {
    public void registerObserver(Farm f);
    public void notifyObserversDay();
    public void notifyObserversNight();
}
