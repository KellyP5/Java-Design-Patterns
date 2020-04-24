package FarmFactory;

import BarnStrategy.HybridBarn;

import java.util.Random;

public class HybridFarm implements Farm {
    private int currency;
    private int level;
    private int farmers;
    private int herdSkill;
    private int cropSkill;
    private int moneySkill;
    private int cycles;
    private HybridBarn hb;

    public HybridFarm() {
        Random rand = new Random();
        level = 1;
        cycles = 0;
        currency = rand.nextInt(400);
        farmers = rand.nextInt(6);
        herdSkill = rand.nextInt(2);
        if (herdSkill == 0) herdSkill++;
        cropSkill = rand.nextInt(2);
        if (cropSkill == 0) cropSkill++;
        moneySkill = rand.nextInt(2);
        if (moneySkill == 0) moneySkill++;
        hb = new HybridBarn();
        hb.init(cropSkill, herdSkill);
    }

    public HybridFarm(int farmers) {
        Random rand = new Random();
        level = 1;
        cycles = 0;
        currency = rand.nextInt(400);
        this.farmers = farmers;
        herdSkill = rand.nextInt(2);
        if (herdSkill == 0) herdSkill++;
        cropSkill = rand.nextInt(2);
        if (cropSkill == 0) cropSkill++;
        moneySkill = rand.nextInt(2);
        if (moneySkill == 0) moneySkill++;
    }

    @Override
    public int tickFarm() {
        int newFarm = 0;
        Random rand = new Random();
        if ((cycles%2)==0) currency = currency + rand.nextInt(moneySkill*100);
        if (this.currency > this.upgrade) {
            level++;
            currency = currency - upgrade;
        }
        this.farmers = farmers + rand.nextInt(3);
        if (this.farmers > capacity) {
            int extra = this.farmers % 10;
            newFarm = extra;
            this.farmers = this.farmers - extra;
        }
        this.herdSkill = this.herdSkill + rand.nextInt(2);
        this.moneySkill = this.moneySkill + rand.nextInt(2);
        if ((cycles%2) == 0) {
            int cash = (int)((double)currency * .10);
            currency = currency - cash;
            hb.ageDay(cropSkill, herdSkill, cash);
        } else {
            hb.ageNight(cropSkill, herdSkill, 0);
        }
        cycles++;
        return newFarm;
    }

    @Override
    public void printFarm() {
        System.out.println("This is a Hybrid Farm\n" +
                "Currency is currently $" + this.currency +
                "\nThis farms current level is " + this.level +
                "\nAn upgrade currently cost $" + this.upgrade +
                "\nThere are currently " + this.farmers + " farmers" +
                "\nThe maximum farmer capacity is " + this.capacity +
                "\nThe herd skill level of this farm is " + this.herdSkill +
                "\nThe money skill level of this farm is " + this.moneySkill +
                "\nThe crop skill level of this farm is " + this.cropSkill +
                "\nThis farm has existed for " + cycles/2 + " days\n");
    }
}
