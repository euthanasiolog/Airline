package entity;

/**
 * Created by piatr on 17.07.18.
 */
public class Airfreighter extends Airplane {
    private int cargo;

    public Airfreighter() {
    }

    @Override
    public String toString() {
        return super.toString() +
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
      Airfreighter other = (Airfreighter) obj;
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
