package BarnStrategy;

public interface Strategy {
    public void init(int cropLvl, int herdLvl);
    public void ageNight(int cropLvl, int herdLvl, int money);
    public void ageDay(int cropLvl, int herdLvl, int money);
    public void print();
}
