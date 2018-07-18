package company;

import airplane.*;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by piatr on 17.07.18.
 */
public class AirplaneLogic {

    private static ArrayList<Airplane> allAirplanes = new ArrayList<>();

    static {
        Airfreighter airfreighter1 = new Airfreighter("cargo1", 2000, 1000, 3000);
        Airfreighter airfreighter2 = new Airfreighter("cargo2", 1500, 1200, 2500);
        NarrowBodyAirliner narrowBodyAirliner1 = new NarrowBodyAirliner("nliner1", 2500, 3000, 63);
        NarrowBodyAirliner narrowBodyAirliner2 = new NarrowBodyAirliner("nliner2", 2000, 4000, 80);
        RegionalAirliner regionalAirliner1 = new RegionalAirliner("regional1", 800, 900, 20);
        RegionalAirliner regionalAirliner2 = new RegionalAirliner("regional2", 600, 1000, 30);
        WideBodyAirliner wideBodyAirliner1 = new WideBodyAirliner("liner1", 6300, 5000, 400);
        WideBodyAirliner wideBodyAirliner2 = new WideBodyAirliner("liner2", 7000, 6000, 600);
        allAirplanes.add(airfreighter1);
        allAirplanes.add(airfreighter2);
        allAirplanes.add(regionalAirliner1);
        allAirplanes.add(regionalAirliner2);
        allAirplanes.add(narrowBodyAirliner1);
        allAirplanes.add(narrowBodyAirliner2);
        allAirplanes.add(wideBodyAirliner1);
        allAirplanes.add(wideBodyAirliner2);
     }

    public static void addAirplane (Airplane airplane){
        allAirplanes.add(airplane);
    }

    public static void removeAirplane (int index){allAirplanes.remove(index);}

    public static void printAirplanes (){
        int i = 1;
        for (Airplane airplane: allAirplanes){
            System.out.println(i+". "+airplane.toString());
            i++;
        }
    }

    public static void printRangeSortedAirplanes (){
        allAirplanes.stream().sorted(Comparator.comparingInt(Airplane::getRange)).
                forEach(System.out::println);
    }

    public static void printAirplanesWithfRequiredFuelConsumption (int min, int max){
        allAirplanes.stream().filter(airplane -> airplane.getKgFuelPerHour()>=min&airplane.getKgFuelPerHour()<=max).
                forEach(System.out::println);
    }

    public static int getOverallCargo(){
        int overAllCargo = 0;
        for (Airplane airplane:allAirplanes){
            if (airplane instanceof Airfreighter){
                overAllCargo+=((Airfreighter) airplane).getCargo();
            }
        }return overAllCargo;
    }

    public static int getOverallSeating() {
        int overallSeating = 0;
        for (Airplane airplane:allAirplanes){
            if (airplane instanceof Airliner){
                overallSeating+=((Airliner)airplane).getSeating();
            }
        }return overallSeating;
    }

}
