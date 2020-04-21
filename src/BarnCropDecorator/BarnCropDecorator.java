package BarnCropDecorator;

public interface BarnCropDecorator {
    void initDecorator(int cropLvl, int herdLvl);
    void ageNight(int cropLvl, int herdLvl, int money);
    int ageDay(int cropLvl, int herdLvl, int money);
    void printDecorator();
}
