package FarmFactory;

import java.util.Random;

public class AnimalFarm implements Farm {
    int currency;
    int level;
    int farmers;
    int herdSkill;
    int moneySkill;
    int cycles;

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
    }

    @Override
    public int tickFarm() {
        int newFarm = 0;
        Random rand = new Random();
        currency = currency + rand.nextInt(moneySkill*100);
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
    }
}
