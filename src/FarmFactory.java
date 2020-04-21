import java.util.Random;

public class FarmFactory {

    public Farm getFarm() {
        Random rand = new Random();
        int i = rand.nextInt(2);
        Farm farm = null;
        if (i == 0) {
            farm = new CropFarm();
        } else if (i == 1) {
            farm = new AnimalFarm();
        } else {
            farm = new HybridFarm();
        }
        return farm;
    }

    public Farm getFarm(int f) {
        Random rand = new Random();
        int i = rand.nextInt(3);
        Farm farm = null;
        if (i == 0) {
            farm = new CropFarm(f);
        } else if (i == 1) {
            farm = new AnimalFarm(f);
        } else {
            farm = new HybridFarm(f);
        }
        return farm;
    }
}
