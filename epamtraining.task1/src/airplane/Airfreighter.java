package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public class Airfreighter extends Airplane {
    private int cargo;

    public Airfreighter(String model, int kgFuelPerHour, int range, int cargo) {
        super(model, kgFuelPerHour, range);
        this.cargo = cargo;
    }

    public Airfreighter() {
    }

    @Override
    public String toString() {
        return "Airfreighter " + super.toString() +
                "cargo=" + cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }
}
