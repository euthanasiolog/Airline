package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public class RegionalAirliner extends Airliner {

    public RegionalAirliner(String model, int kgFuelPerHour, int range, int seating) {
        super(model, kgFuelPerHour, range, seating);
    }

    @Override
    public String toString() {
        return "RegionalAirliner " + super.toString();
    }
}
