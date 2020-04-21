package TickObserver;

import FarmFactory.Farm;
import FarmFactory.FarmFactory;
import TickObserver.Subject;

import java.util.ArrayList;

public class FarmData implements Subject {
    private ArrayList<Farm> observerList;
    private FarmFactory farmFactory;
    private int days;

    public FarmData() {
        observerList = new ArrayList<Farm>();
        farmFactory = new FarmFactory();
        observerList.add(farmFactory.getFarm());
        observerList.get(0).printFarm();
        days = 0;
    }

    public ArrayList<Farm> getFarms() {
        return observerList;
    }

    @Override
    public void registerObserver(Farm f) {
        observerList.add(f);
    }

    @Override
    public void notifyObserversDay() {
        for (int i = 0; i < observerList.size(); i++) {
            int farmers = observerList.get(i).tickFarm();
            if (farmers != 0) {
                registerObserver(farmFactory.getFarm(farmers));
                System.out.println("Farm " + i + " Became full. Creating new farm");
            }
            observerList.get(i).printFarm();
        }
        System.out.println("\nDaytime has passed on day " + days + "\n");
    }

    @Override
    public void notifyObserversNight() {
        for (int i = 0; i < observerList.size(); i++) {
            int farmers = observerList.get(i).tickFarm();
            if (farmers != 0) {
                registerObserver(farmFactory.getFarm(farmers));
                System.out.println("Farm " + i + " Became full. Creating new farm");
            }
            observerList.get(i).printFarm();
        }
        System.out.println("\nNight time has passed on day " + days + "\n");
        days++;
    }

}
