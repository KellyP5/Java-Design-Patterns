package tickobserver;

import farmfactory.Farm;
import farmfactory.FarmFactory;

import java.util.ArrayList;

/**
 * Farm data for observer strategy.
 */
public class FarmData implements Subject {
    private ArrayList<Farm> observerList;
    private FarmFactory farmFactory;
    private int days;

    /**
     * Instantiates the farm data list.
     */
    public FarmData() {
        observerList = new ArrayList<Farm>();
        farmFactory = new FarmFactory();
        observerList.add(farmFactory.getFarm());
        observerList.get(0).printFarm();
        days = 0;
    }

    /**
     * Returns the farms as an arraylist.
     * @return ArrayList
     */
    public ArrayList<Farm> getFarms() {
        return observerList;
    }

    /**
     * Adds an observer to the list.
     * @param f farm to add
     */
    @Override
    public void registerObserver(Farm f) {
        observerList.add(f);
    }

    /**
     * Notifies the observers of a day passing.
     */
    @Override
    public void notifyObserversDay() {
        for (int i = 0; i < observerList.size(); i++) {
            int farmers = observerList.get(i).tickFarm();
            if (farmers != 0) {
                registerObserver(farmFactory.getFarm(farmers));
                System.out.println("Farm " + i + " Became full. Creating new farm");
            }
            System.out.println("\n Farm " + i);
            observerList.get(i).printFarm();
        }
        System.out.println("\nDaytime has passed on day " + days + "\n");
    }

    /**
     * Notifies the observers of a night passing.
     */
    @Override
    public void notifyObserversNight() {
        for (int i = 0; i < observerList.size(); i++) {
            int farmers = observerList.get(i).tickFarm();
            if (farmers != 0) {
                registerObserver(farmFactory.getFarm(farmers));
                System.out.println("Farm " + i + " Became full. Creating new farm");
            }
            System.out.println("\n Farm " + i);
            observerList.get(i).printFarm();
        }
        System.out.println("\nNight time has passed on day " + days + "\n");
        days++;
    }

}
