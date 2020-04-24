package BarnStrategy;

public interface Strategy {
    public void initDecorator(int cropLvl, int herdLvl);
    public void ageNight(int cropLvl, int herdLvl, int money);
    public int ageDay(int cropLvl, int herdLvl, int money);
    public void print();
}
