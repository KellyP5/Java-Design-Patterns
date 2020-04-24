package BarnStrategy;

import java.util.Random;

public class HybridBarn implements Strategy {
    int horse, cow, pig, chicken, dog;
    int corn, tobacco, potato;
    int cash, cycles;
    boolean animalPredator, cropPredator;

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
        animalPredator = false;
        cropPredator = false;
        cycles = 0;
    }

    @Override
    public void ageNight(int cropLvl, int herdLvl, int money) {
        cycles++;
        cash = money + cash;
        Random rand = new Random();
        if (rand.nextInt(10) == 5) {
            int predator = rand.nextInt(3);
            if (predator == 0) {
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
            } else if (predator == 1) {
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

    }

    @Override
    public void ageDay(int cropLvl, int herdLvl, int money) {
        cycles++;
        cash = money + cash;

        if (animalPredator == true || cropPredator == true) {
            if (cash > 50) {
                animalPredator = false;
                cropPredator = false;
            }
        }

        if ((cycles % 4) == 0) {
            for (int i=0; i <herdLvl; i++) {
                if (horse > 1) horse++;
                if (cow > 1) cow ++;
                if (pig > 1) pig ++;
                if (chicken > 1) chicken ++;
                if (dog > 1) dog++;
            }
        }
        if ((cycles % 2) == 0) {
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
        } else {
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
        System.out.println("This is a Hybrid Barn, it has crops and animals" +
                "\nHorse:"+horse+" cow:"+cow+" pig:"+pig+" chicken:"+chicken+
                " dog:"+dog+"\nacres of corn:"+corn+" tobacco:"+tobacco+" potato:"+
                potato+"\nAre there crop predators? " + cropPredator+
                "\nAre there animal predators? " + animalPredator);
    }
}
