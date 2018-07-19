package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public class WideBodyAirliner extends Airliner {

    private static int MAX_RANGE = 15000;

    public static int getMaxRange() {
        return MAX_RANGE;
    }

    public WideBodyAirliner(String model, int kgFuelPerHour, int range, int seating) {
        super(model, kgFuelPerHour, seating);
        if (range<=MAX_RANGE) super.setRange(range);
    }

    public WideBodyAirliner() {
    }

    @Override
    public String toString() {
        return "WideBodyAirliner " + super.toString();
    }
}
