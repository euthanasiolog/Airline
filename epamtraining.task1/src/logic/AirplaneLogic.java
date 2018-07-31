package logic;

import entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by piatr on 17.07.18.
 */
public class AirplaneLogic {

    private static List<Airplane> allAirplanes = new ArrayList<>();

    static {
        Airfreighter airfreighter1 = new Airfreighter();
        Airfreighter airfreighter2 = new Airfreighter();
        Airliner airliner1 = new Airliner();
        Airliner airliner2 = new Airliner();
        Airliner airliner3 = new Airliner();
        Airliner airliner4 = new Airliner();
        Airliner airliner5 = new Airliner();
        Airliner airliner6 = new Airliner();
        airfreighter1.setModel("af1");
        airfreighter1.setRange(5000);
        airfreighter1.setKgFuelPerHour(850);
        airfreighter1.setCargo(8000);
        airfreighter2.setModel("af2");
        airfreighter2.setRange(3000);
        airfreighter2.setKgFuelPerHour(350);
        airfreighter2.setCargo(5000);
        airliner1.setModel("al1");
        airliner1.setRange(9000);
        airliner1.setKgFuelPerHour(5000);
        airliner1.setSeating(500);
        airliner2.setModel("al2");
        airliner2.setRange(6000);
        airliner2.setKgFuelPerHour(4200);
        airliner2.setSeating(300);
        airliner3.setModel("al3");
        airliner3.setRange(9500);
        airliner3.setKgFuelPerHour(7000);
        airliner3.setSeating(800);
        airliner4.setModel("al4");
        airliner4.setRange(900);
        airliner4.setKgFuelPerHour(590);
        airliner4.setSeating(50);
        airliner5.setModel("al5");
        airliner5.setRange(2500);
        airliner5.setKgFuelPerHour(800);
        airliner5.setSeating(90);
        airliner6.setModel("al6");
        airliner6.setRange(2000);
        airliner6.setKgFuelPerHour(1900);
        airliner6.setSeating(110);
        addAirplane(airfreighter1);
        addAirplane(airfreighter2);
        addAirplane(airliner1);
        addAirplane(airliner2);
        addAirplane(airliner3);
        addAirplane(airliner4);
        addAirplane(airliner5);
        addAirplane(airliner6);
     }

    public static void addAirplane (Airplane airplane){
        allAirplanes.add(airplane);
    }

    public static void removeAirplane (int index){
        allAirplanes.remove(index);
    }

    public static void printAirplanes (){
        for (Airplane airplane: allAirplanes){
            System.out.println(allAirplanes.indexOf(airplane)+". "+airplane.toString());
        }
    }

    public static void printRangeSortedAirplanes (){
        allAirplanes.stream().sorted(Comparator.comparingInt(Airplane::getRange)).
                forEach(System.out::println);
    }

    public static void printAirplanesWithRequiredFuelConsumption (int min, int max){
        allAirplanes.stream().filter(airplane -> airplane.getKgFuelPerHour()>=min&airplane.getKgFuelPerHour()<=max).
                forEach(System.out::println);
    }

    public static int getOverallCargo(){
        int overAllCargo = 0;
        for (Airplane airplane:allAirplanes){
            if (airplane instanceof Airfreighter){
                overAllCargo+=((Airfreighter) airplane).getCargo();
            }
        }
        return overAllCargo;
    }

    public static int getOverallSeating() {
        int overallSeating = 0;
        for (Airplane airplane:allAirplanes){
            if (airplane instanceof Airliner){
                overallSeating+=((Airliner)airplane).getSeating();
            }
        }
        return overallSeating;
    }

}
