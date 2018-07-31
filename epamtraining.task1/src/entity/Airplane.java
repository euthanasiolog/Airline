package entity;

/**
 * Created by piatr on 17.07.18.
 */
public abstract class Airplane {
    private String model;
    private int kgFuelPerHour;
    private int range;

    public Airplane() {
    }

    @Override
    public String toString() {
        return
                this.getClass().getName()+
                " model = " + model  +
                ", kgFuelPerHour = " + kgFuelPerHour +
                ", range = " + range;
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

    @Override
    public int hashCode() {
        int result = 23;
        result = result*model.hashCode();
        result = result*11 + range;
        result = result + kgFuelPerHour%11;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj)
            return true;
        if (obj==null)
            return false;
        if (this.getClass()!=obj.getClass())
            return false;
        Airliner other = (Airliner) obj;
        if (!model.equals(other.getModel()))
            return false;
        if (kgFuelPerHour!=other.getKgFuelPerHour())
            return false;
        if (range!=other.getRange())
            return false;
        return true;
    }
}
