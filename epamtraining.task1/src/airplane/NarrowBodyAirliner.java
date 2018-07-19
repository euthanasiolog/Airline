package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public class NarrowBodyAirliner extends Airliner {

    private static int MAX_RANGE = 1500;

    public static int getMaxRange() {
        return MAX_RANGE;
    }

    public NarrowBodyAirliner(String model, int kgFuelPerHour, int range, int seating) {
        super(model, kgFuelPerHour, seating);
        if (range<=MAX_RANGE)super.setRange(range);
    }

    public NarrowBodyAirliner() {
    }

    @Override
    public String toString() {
        return "NarrowBodyAirliner " + super.toString();
    }
}
