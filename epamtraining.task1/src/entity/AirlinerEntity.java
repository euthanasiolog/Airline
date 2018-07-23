package entity;

import company.AirlinerType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by piatr on 17.07.18.
 */
public class AirlinerEntity extends AirplaneEntity {
    private int seating;

    private AirlinerType airlinerType = AirlinerType.Indefinite;

    public AirlinerEntity(String model, int kgFuelPerHour, int seating, int maxRange) {
        super(model, kgFuelPerHour, maxRange);
        this.seating = seating;
        setAirlinerType(maxRange);
    }

    public AirlinerEntity() {
    }

    public AirlinerType getAirlinerType() {
        return airlinerType;
    }

    @Override
    public void setRange(int range) {
        super.setRange(range);
        setAirlinerType(range);
    }

    public void setAirlinerType(int maxRange) {
        ArrayList<AirlinerType> airlinerTypes = new ArrayList<>(Arrays.asList(AirlinerType.values()));
        airlinerTypes.sort(Comparator.comparing(AirlinerType::getMaxRange));
        for (int i = airlinerTypes.size(); i > 0; i--){
            if (maxRange <= airlinerTypes.get(i-1).getMaxRange()){
                this.airlinerType = airlinerTypes.get(i-1);
            }
        }
    }

    public int getSeating() {
        return seating;
    }

    public void setSeating(int seating) {
        this.seating = seating;
    }

    @Override
    public String toString() {
        return super.toString() + ", airliner type = "+airlinerType+ ", max range = " +airlinerType.getMaxRange()+
                ", seating = " + seating +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        AirlinerEntity other = (AirlinerEntity) obj;
        if (seating!=other.seating)
            return false;
        if (!airlinerType.equals(other.airlinerType))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 23 * result + seating;
        result = 23 * result + airlinerType.hashCode();
        return result;
    }
}
