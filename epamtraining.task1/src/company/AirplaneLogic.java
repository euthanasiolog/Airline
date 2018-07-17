package company;

import airplane.Airfreighter;
import airplane.Airliner;
import airplane.Airplane;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by piatr on 17.07.18.
 */
public class AirplaneLogic {

    private ArrayList<Airplane> allAirplanes;

    public void addAirplane (Airplane airplane){
        allAirplanes.add(airplane);
    }

    public void removeAirplane (Airplane airplane){
        allAirplanes.remove(airplane);
    }

    public void printAirplanes (){
        for (Airplane airplane: allAirplanes){
            System.out.println(airplane.toString());
        }
    }

    public void printRangeSortedAirplanes (){
        allAirplanes.stream().sorted(Comparator.comparingInt(Airplane::getRange)).
                forEach(System.out::println);
    }

    public void printAirplanesWithfRequiredFuelConsumption (int min, int max){
        allAirplanes.stream().filter(airplane -> airplane.getKgFuelPerHour()>=min&airplane.getKgFuelPerHour()<=max).
                forEach(System.out::println);
    }

    public int getOverallCargo(){
        int overAllCargo = 0;
        for (Airplane airplane:allAirplanes){
            if (airplane instanceof Airfreighter){
                overAllCargo+=((Airfreighter) airplane).getCargo();
            }
        }return overAllCargo;
    }

    public int getOverallSeating() {
        int overallSeating = 0;
        for (Airplane airplane:allAirplanes){
            if (airplane instanceof Airliner){
                overallSeating+=((Airliner)airplane).getSeating();
            }
        }return overallSeating;
    }

}
