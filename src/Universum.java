import java.util.Scanner;
import tickobserver.FarmData;

/**
 * Main class to call on farms and take user input.
 */
public class Universum {
    /**
     * Main class.
     * @param args arguments for main
     */
    public static void main(String[] args) {
        FarmData farms = new FarmData();
        String tick = "Y";
        String day = "Day";
        Scanner in = new Scanner(System.in, "UTF-8");
        while (tick.equalsIgnoreCase("y")) {
            System.out.println("Would you like to tick another day/night? "
                    + "If yes, enter 'Y', else enter 'N'");
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
