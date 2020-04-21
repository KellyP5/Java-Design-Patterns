import FarmFactory.Farm;
import FarmFactory.FarmFactory;

import java.util.ArrayList;
import java.util.Scanner;

public class Universum {
    public static void main(String[] args) {
        System.out.println("Test Successful");
        FarmFactory farmFactory = new FarmFactory();
        ArrayList<Farm> farms = new ArrayList<Farm>();
        farms.add(farmFactory.getFarm());
        System.out.println("The universe currently has " + farms.size() + "farms\n\n");
        farms.get(0).printFarm();

        String tick = "Y";
        while (tick.equalsIgnoreCase("y")) {
            Scanner in = new Scanner(System.in);
            System.out.println("Would you like to tick another day/night? If yes, enter 'Y', else enter 'N'");
            tick = in.next();
            if (tick.equalsIgnoreCase("y")) {
                for (int i = 0; i < farms.size(); i++) {
                    int farmers = farms.get(i).tickFarm();
                    if (farmers != 0) {
                        farms.add(farmFactory.getFarm(farmers));
                        System.out.println("Farm " + i + " Became full. Creating new farm");
                    }
                    farms.get(i).printFarm();
                }
            }
        }
    }
}
