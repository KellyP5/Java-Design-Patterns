import TickObserver.FarmData;

import java.util.Scanner;

public class Universum {
    public static void main(String[] args) {
        FarmData farms = new FarmData();
        String tick = "Y";
        String day = "Day";
        Scanner in = new Scanner(System.in, "UTF-8");
        while (tick.equalsIgnoreCase("y")) {
            System.out.println("Would you like to tick another day/night? If yes, enter 'Y', else enter 'N'");
            tick = in.next();
            if (tick.equalsIgnoreCase("y")) {
                if (day.equalsIgnoreCase("day")) {
                    farms.notifyObserversDay();
                    day = "night";
                } else {
                    farms.notifyObserversNight();
                    day = "day";
                }
            }
        }
        in.close();
    }
}
