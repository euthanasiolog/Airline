package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public class NarrowBodyAirliner extends Airliner {

    public NarrowBodyAirliner(String model, int kgFuelPerHour, int range, int seating) {
        super(model, kgFuelPerHour, range, seating);
    }

    @Override
    public String toString() {
        return "NarrowBodyAirliner " + super.toString();
    }
}
