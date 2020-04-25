package barnstrategy;

import java.util.Random;

/**
 * Barn class for generating a barn with animals.
 */
public class Barn implements Strategy {
    int horse;
    int cow;
    int pig;
    int chicken;
    int dog;
    int cash;
    int cycles;
    boolean animalPredator;

    /**
     * Initializer for barn class, sets defaults for barn.
     * @param cropLvl current crop level
     * @param herdLvl current herd level
     */
    @Override
    public void init(int cropLvl, int herdLvl) {
        horse = herdLvl;
        cow = herdLvl;
        pig = herdLvl;
        chicken = herdLvl;
        dog = herdLvl;
        cash = 0;
        animalPredator = false;
        cycles = 0;
    }

    /**
     * Ages the barn by night, 10% chance of generating
     * a predator. Saves cash amount. If predator,
     * takes out animal.
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
            animalPredator = true;
            int ran = rand.nextInt(5);
            if (ran == 0) {
                horse--;
            } else if (ran == 1) {
                cow--;
            } else if (ran == 2) {
                pig--;
            } else if (ran == 3) {
                chicken--;
            } else if (ran == 4) {
                dog--;
            }
        }
    }

    /**
     * Ages by daytime, tries to pay to remove predatory
     * if there is enough money. Also, tries to buy more
     * animals with money saved.
     * @param cropLvl current crop level
     * @param herdLvl current herd level
     * @param money current money to store
     */
    @Override
    public void ageDay(int cropLvl, int herdLvl, int money) {
        cycles++;
        cash = money + cash;

        if (animalPredator == true) {
            if (cash > 50) {
                animalPredator = false;
            }
        }

        if ((cycles % 3) == 0) {
            for (int i = 0; i < herdLvl; i++) {
                if (horse > 1) {
                    horse++;
                }
                if (cow > 1) {
                    cow++;
                }
                if (pig > 1) {
                    pig++;
                }
                if (chicken > 1) {
                    chicken++;
                }
                if (dog > 1) {
                    dog++;
                }
            }
        }

        Random rand = new Random();
        int ran = rand.nextInt(2);
        if (ran == 0) {
            if (cash > 100) {
                ran = rand.nextInt(5);
                if (ran == 0) {
                    horse++;
                } else if (ran == 1) {
                    cow++;
                } else if (ran == 2) {
                    pig++;
                } else if (ran == 3) {
                    chicken = chicken + 5;
                } else if (ran == 4) {
                    dog = dog + 2;
                }
                cash = cash - 100;
            }
        }
    }

    /**
     * Prints the current barn status.
     */
    @Override
    public void print() {
        System.out.println("This is a Hybrid Barn, it has crops and animals"
                + "\nHorse:" + horse + " cow:" + cow + " pig:" + pig + " chicken:" + chicken
                + " dog:" + dog + "\nAre there animal predators? " + animalPredator);
    }
}
