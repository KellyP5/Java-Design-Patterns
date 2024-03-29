package farmfactory;

import barnstrategy.HybridBarn;
import java.util.Random;

/**
 * Hybrid farm.
 */
public class HybridFarm implements Farm {
    private int currency;
    private int level;
    private int farmers;
    private int herdSkill;
    private int cropSkill;
    private int moneySkill;
    private int cycles;
    private HybridBarn hb;

    /**
     * instantiates an initial hybrid farm.
     */
    public HybridFarm() {
        Random rand = new Random();
        level = 1;
        cycles = 0;
        currency = rand.nextInt(400);
        farmers = rand.nextInt(6);
        herdSkill = rand.nextInt(2);
        if (herdSkill == 0) {
            herdSkill++;
        }
        cropSkill = rand.nextInt(2);
        if (cropSkill == 0) {
            cropSkill++;
        }
        moneySkill = rand.nextInt(2);
        if (moneySkill == 0) {
            moneySkill++;
        }
        hb = new HybridBarn();
        hb.init(cropSkill, herdSkill);
    }

    /**
     * instantiates a hybrid farm with a set number of farmers.
     * @param farmers number of farmers to start
     */
    public HybridFarm(int farmers) {
        Random rand = new Random();
        level = 1;
        cycles = 0;
        currency = rand.nextInt(400);
        this.farmers = farmers;
        herdSkill = rand.nextInt(2);
        if (herdSkill == 0) {
            herdSkill++;
        }
        cropSkill = rand.nextInt(2);
        if (cropSkill == 0) {
            cropSkill++;
        }
        moneySkill = rand.nextInt(2);
        if (moneySkill == 0) {
            moneySkill++;
        }
        hb = new HybridBarn();
        hb.init(cropSkill, herdSkill);
    }

    /**
     * Ticks a farm either day or night. If farm is full, creates a new
     * farm with farmers. Also generates currency, levels up, upgrades etc.
     * @return integer of the number of new farms made
     */
    @Override
    public int tickFarm() {
        int newFarm = 0;
        Random rand = new Random();
        if ((cycles % 2) == 0) {
            currency = currency + rand.nextInt(moneySkill * 100);
        }
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
        if ((cycles % 2) == 0) {
            int cash = (int)((double)currency * .5);
            hb.ageDay(cropSkill, herdSkill, currency - cash);
            currency = currency - cash;
        } else {
            hb.ageNight(cropSkill, herdSkill, 0);
        }
        cycles++;
        return newFarm;
    }

    /**
     * Prints the current farm state.
     */
    @Override
    public void printFarm() {
        System.out.println("This is a Hybrid Farm\n"
                + "Currency is currently $" + this.currency
                +
                "\nThis farms current level is " + this.level
                +
                "\nAn upgrade currently cost $" + this.upgrade
                +
                "\nThere are currently " + this.farmers + " farmers"
                +
                "\nThe maximum farmer capacity is " + this.capacity
                +
                "\nThe herd skill level of this farm is " + this.herdSkill
                +
                "\nThe money skill level of this farm is " + this.moneySkill
                +
                "\nThe crop skill level of this farm is " + this.cropSkill
                +
                "\nThis farm has existed for " + cycles / 2 + " days\n");
        hb.print();
    }
}
