package barnstrategy;

import java.util.Random;

/**
 * Barn class for generating a barn with animals.
 */
public class Crop implements Strategy {
    int corn;
    int tobacco;
    int potato;
    int cash;
    int cycles;
    boolean cropPredator;

    /**
     * Initializer for hybridbarn class, sets defaults for barn.
     * @param cropLvl current crop level
     * @param herdLvl current herd level
     */
    @Override
    public void init(int cropLvl, int herdLvl) {
        corn = cropLvl;
        tobacco = cropLvl;
        potato = cropLvl;
        cash = 0;
        cropPredator = false;
        cycles = 0;
    }

    /**
     * Ages the barn by night, 10% chance of generating
     * a predator. Saves cash amount. If predator,
     * takes out plants.
     * @param cropLvl current crop level
     * @param herdLvl current herd level
     * @param money current money to store
     */
    @Override
    public void ageNight(int cropLvl, int herdLvl, int money) {
        cycles++;
        cash = money + cash;
        Random rand = new Random();
        if (rand.nextInt(10) == 5) {
            cropPredator = true;
            int ran = rand.nextInt(3);
            if (ran == 0) {
                corn--;
            } else if (ran == 1) {
                tobacco--;
            } else if (ran == 2) {
                potato--;
            }
        }
    }

    /**
     * Ages by daytime, tries to pay to remove predatory
     * if there is enough money. Also, tries to buy more
     * plants with money saved.
     * @param cropLvl current crop level
     * @param herdLvl current herd level
     * @param money current money to store
     */
    @Override
    public void ageDay(int cropLvl, int herdLvl, int money) {
        cycles++;
        cash = money + cash;

        if (cropPredator == true) {
            if (cash > 50) {
                cropPredator = false;
            }
        }

        if ((cycles % 2) == 0) {
            for (int i = 0; i < cropLvl; i++) {
                corn++;
                tobacco++;
                potato++;
            }
        }
        Random rand = new Random();
        if (cash > 100) {
            int ran = rand.nextInt(3);
            if (ran == 0) {
                corn++;
            } else if (ran == 1) {
                tobacco++;
            } else if (ran == 2) {
                potato++;
            }
            cash = cash - 100;
        }
    }

    /**
     * Prints the current barn status.
     */
    @Override
    public void print() {
        System.out.println("This is a Crop Barn, it has crops"
                + "\nacres of corn:" + corn + " tobacco:" + tobacco + " potato:"
                + potato + "\nAre there crop predators? " + cropPredator);
    }
}
