package FarmFactory;

import BarnStrategy.Barn;

import java.util.Random;

public class AnimalFarm implements Farm {
    int currency;
    int level;
    int farmers;
    int herdSkill;
    int moneySkill;
    int cycles;
    Barn barn;

    public AnimalFarm() {
        Random rand = new Random();
        level = 1;
        cycles = 0;
        currency = rand.nextInt(400);
        farmers = rand.nextInt(6);
        herdSkill = rand.nextInt(3);
        if (herdSkill == 0) herdSkill++;
        moneySkill = rand.nextInt(2);
        if (moneySkill == 0) moneySkill++;
        barn = new Barn();
        barn.init(0, herdSkill);
    }

    public AnimalFarm(int farmers) {
        Random rand = new Random();
        level = 1;
        cycles = 0;
        currency = rand.nextInt(400);
        this.farmers = farmers;
        herdSkill = rand.nextInt(2);
        if (herdSkill == 0) herdSkill++;
        moneySkill = rand.nextInt(2);
        if (moneySkill == 0) moneySkill++;
        barn = new Barn();
        barn.init(0, herdSkill);
    }

    @Override
    public int tickFarm() {
        int newFarm = 0;
        Random rand = new Random();
        if ((cycles%2)==0) currency = currency + rand.nextInt(moneySkill*100);
        if (currency > upgrade) {
            level++;
            currency = currency - upgrade;
        }
        farmers = farmers + rand.nextInt(3);
        if (farmers > capacity) {
            int extra = farmers % 10;
            newFarm = extra;
            farmers = farmers - extra;
        }
        herdSkill = herdSkill + rand.nextInt(2);
        moneySkill = moneySkill + rand.nextInt(2);
        if ((cycles%2) == 0) {
            int cash = (int)((double)currency * .5);
            barn.ageDay(0, herdSkill, currency - cash);
            currency = currency - cash;
        } else {
            barn.ageNight(0, herdSkill, 0);
        }
        cycles++;
        return newFarm;
    }

    @Override
    public void printFarm() {
        System.out.println("This is an Animal Farm\n" +
                "Currency is currently $" + currency +
                "\nThis farms current level is " + level +
                "\nAn upgrade currently cost $" + upgrade +
                "\nThere are currently " + farmers + " farmers" +
                "\nThe maximum farmer capacity is " + capacity +
                "\nThe herd skill level of this farm is " + herdSkill +
                "\nThe money skill level of this farm is " + moneySkill +
                "\nThis farm has existed for " + cycles/2 + " days\n");
        barn.print();
    }
}
