package FarmFactory;

import java.util.Random;

public class CropFarm implements Farm {
    int currency;
    int level;
    final static int upgrade = 1200;
    int farmers;
    final static int capacity = 10;
    int cropSkill;
    int moneySkill;

    public CropFarm() {
        Random rand = new Random();
        this.level = 1;
        this.currency = rand.nextInt(400);
        this.farmers = rand.nextInt(6);
        this.cropSkill = rand.nextInt(3);
        if (cropSkill == 0) cropSkill++;
        this.moneySkill = rand.nextInt(2);
        if (moneySkill == 0) moneySkill++;
    }

    public CropFarm(int farmers) {
        Random rand = new Random();
        this.level = 1;
        this.currency = rand.nextInt(400);
        this.farmers = farmers;
        this.cropSkill = rand.nextInt(2);
        if (cropSkill == 0) cropSkill++;
        this.moneySkill = rand.nextInt(2);
        if (moneySkill == 0) moneySkill++;
    }

    @Override
    public int tickFarm() {
        int newFarm = 0;
        Random rand = new Random();
        this.currency = this.currency + rand.nextInt(this.moneySkill*100);
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
        this.cropSkill = this.cropSkill + rand.nextInt(2);
        this.moneySkill = this.moneySkill + rand.nextInt(2);
        return newFarm;
    }

    @Override
    public void printFarm() {
        System.out.println("This is an Crop Farm\n" +
                "Currency is currently $" + this.currency +
                "\nThis farms current level is " + this.level +
                "\nAn upgrade currently cost $" + this.upgrade +
                "\nThere are currently " + this.farmers + " farmers" +
                "\nThe maximum farmer capacity is " + this.capacity +
                "\nThe crop skill level of this farm is " + this.cropSkill +
                "\nThe money skill level of this farm is " + this.moneySkill +
                "\n");
    }
}
