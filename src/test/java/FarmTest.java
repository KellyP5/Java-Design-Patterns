import org.junit.BeforeClass;
import org.junit.Test;
import barnstrategy.*;
import farmfactory.*;
import tickobserver.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class FarmTest {
    private static Barn barn;
    private static Crop crops;
    private static HybridBarn hybridBarn;
    private static AnimalFarm animalFarm;
    private static CropFarm cropFarm;
    private static FarmFactory farmFactory;
    private static HybridFarm hybridFarm;
    private static FarmData farmData;

    @BeforeClass
    public static void setUp() {
        barn = new Barn();
        barn.init(0, 1);
        crops = new Crop();
        crops.init(1, 0);
        hybridBarn = new HybridBarn();
        hybridBarn.init(1,1);

        animalFarm = new AnimalFarm();
        cropFarm = new CropFarm();
        farmFactory = new FarmFactory();
        hybridFarm = new HybridFarm();

        farmData = new FarmData();
    }

    @Test
    public void strategyTest() {
        for (int i=0; i<100; i++) {
            barn.ageDay(0, 5, 10000);
            barn.ageNight(0, 5, 10000);
            crops.ageDay(5, 0, 10000);
            crops.ageNight(5, 0, 10000);
            hybridBarn.ageNight(5, 5, 10000);
            hybridBarn.ageDay(5, 5, 10000);
        }
        barn.print();
        assertNotNull(barn);
        crops.print();
        assertNotNull(barn);
        hybridBarn.print();
        assertNotNull(barn);
    }

    @Test
    public void factoryTest() {
        Farm farm;
        for (int i = 0; i < 20; i++) {
            farmFactory.getFarm();
            farmFactory.getFarm(1);
        }
        farm = farmFactory.getFarm();
        assertNotNull(farm);
        farm = farmFactory.getFarm(5);
        assertNotNull(farm);
    }

    @Test
    public void observerTest() {
        farmData.registerObserver(hybridFarm);
        farmData.registerObserver(cropFarm);
        farmData.registerObserver(animalFarm);
        for (int i=0; i<5; i++) {
            farmData.notifyObserversDay();
            farmData.notifyObserversNight();
        }
        ArrayList<Farm> farms = farmData.getFarms();
        assertNotNull(farms);
        int size = farms.size();
        assertEquals(size, farms.size());
    }

    @Test public void testMain() throws IOException {
        System.out.println("main");
        String test = "test";
        String[] args = new String[]{test};
        final InputStream original = System.in;
        final FileInputStream fips = new FileInputStream(new File("src/Universum.java"));
        System.setIn(fips);
        Universum.main(args);
        System.setIn(original);
    }
}