package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public class RegionalAirliner extends Airliner {
    private static int MAX_RANGE = 5000;

    public static int getMaxRange() {
        return MAX_RANGE;
    }

    public RegionalAirliner(String model, int kgFuelPerHour, int range, int seating) {
        super(model, kgFuelPerHour, seating);
        if (range<=MAX_RANGE)super.setRange(range);
    }

    public RegionalAirliner() {
    }

    @Override
    public String toString() {
        return "RegionalAirliner " + super.toString();
    }
}
