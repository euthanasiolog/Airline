package airplane;

/**
 * Created by piatr on 17.07.18.
 */
public abstract class Airplane
{
    private String model;
    private int kgFuelPerHour;
    private int range;

    public Airplane(String model, int kgFuelPerHour, int range) {
        this.model = model;
        this.kgFuelPerHour = kgFuelPerHour;
        this.range = range;
    }

    @Override
    public String toString() {
        return
                "model='" + model + '\'' +
                ", kgFuelPerHour=" + kgFuelPerHour +
                ", range=" + range;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getKgFuelPerHour() {
        return kgFuelPerHour;
    }

    public void setKgFuelPerHour(int kgFuelPerHour) {
        this.kgFuelPerHour = kgFuelPerHour;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
