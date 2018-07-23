package entity;

/**
 * Created by piatr on 17.07.18.
 */
public class AirfreighterEntity extends AirplaneEntity {
    private int cargo;

    public AirfreighterEntity(String model, int kgFuelPerHour, int range, int cargo) {
        super(model, kgFuelPerHour, range);
        this.cargo = cargo;
    }

    public AirfreighterEntity() {
    }

    @Override
    public String toString() {
        return "AirfreighterEntity " + super.toString() +
                ", cargo = " + cargo;
    }

    public int getCargo() {
        return cargo;
    }

    public void setCargo(int cargo) {
        this.cargo = cargo;
    }

    @Override
    public boolean equals(Object obj) {
      if (!super.equals(obj))
          return false;
      AirfreighterEntity other = (AirfreighterEntity) obj;
      if (cargo!=other.getCargo())
          return false;
      return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 23 * result + cargo;
        return result;
    }
}
