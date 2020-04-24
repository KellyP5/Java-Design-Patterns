package BarnStrategy;

import java.util.Random;

public class Crop implements Strategy {
    int corn, tobacco, potato;
    int cash, cycles;
    boolean cropPredator;

    @Override
    public void init(int cropLvl, int herdLvl) {
        corn = cropLvl;
        tobacco = cropLvl;
        potato = cropLvl;
        cash = 0;
        cropPredator = false;
        cycles = 0;
    }

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

    @Override
    public void ageDay(int cropLvl, int herdLvl, int money) {
        cycles++;
        cash = money + cash;

        if (cropPredator == true) {
            if (cash > 50) {
                cropPredator = false;
            }
        }

        if ((cycles % 3) == 0) {
            for (int i=0; i<cropLvl; i++) {
                corn ++;
                tobacco++;
                potato++;
            }
        }
        Random rand = new Random();
        int ran = rand.nextInt(2);
        if (ran==0) {
            if (cash > 100) {
                ran = rand.nextInt(3);
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
    }

    @Override
    public void print() {
        System.out.println("This is a Crop Farm, it has crops and animals" +
                "\nacres of corn:"+corn+" tobacco:"+tobacco+" potato:"+
                potato+"\nAre there crop predators? " + cropPredator+"\n");
    }
}
