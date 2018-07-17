package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public abstract class Airliner extends Airplane {
    private int seating;

    @Override
    public String toString() {
        return super.toString() +
                "seating=" + seating +
                '}';
    }

    public Airliner(String model, int kgFuelPerHour, int range, int seating) {
        super(model, kgFuelPerHour, range);
        this.seating = seating;
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }
}
