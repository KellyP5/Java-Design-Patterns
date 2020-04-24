package BarnStrategy;

import java.util.Random;

public class HybridBarn implements Strategy {
    int horse, cow, pig, chicken, dog;
    int corn, tobacco, potato;
    int cash;
    boolean day;
    boolean animalPredator, cropPredator, soilPredator;

    @Override
    public void init(int cropLvl, int herdLvl) {
        horse = herdLvl;
        cow = herdLvl;
        pig = herdLvl;
        chicken = herdLvl;
        dog = herdLvl;
        corn = cropLvl;
        tobacco = cropLvl;
        potato = cropLvl;
        cash = 0;
        day = true;
        animalPredator = false;
        cropPredator = false;
        soilPredator = false;
    }

    @Override
    public void ageNight(int cropLvl, int herdLvl, int money) {
        Random rand = new Random();
        if (rand.nextInt(10) == 5) {
            int predator = rand.nextInt(3);
            if (predator == 0) {
                animalPredator = true;
            } else if (predator == 1) {
                cropPredator = true;
            } else {
                soilPredator = true;
            }
        }
    }

    @Override
    public int ageDay(int cropLvl, int herdLvl, int money) {
        return 0;
    }

    @Override
    public void print() {

    }
}
