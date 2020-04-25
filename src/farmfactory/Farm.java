package farmfactory;

/**
 * Interface for the farm factories.
 */
public interface Farm {
    int upgrade = 1200;
    int capacity = 10;
    int tickFarm();

    void printFarm();
}
