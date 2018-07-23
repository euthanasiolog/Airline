package company;

import entity.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by piatr on 17.07.18.
 */
public class AirplaneLogic {

    private static List<AirplaneEntity> allAirplanes = new ArrayList<>();

    static {
        AirfreighterEntity airfreighterEntity1 = new AirfreighterEntity();
        AirfreighterEntity airfreighterEntity2 = new AirfreighterEntity();
        AirlinerEntity airlinerEntity1 = new AirlinerEntity();
        AirlinerEntity airlinerEntity2 = new AirlinerEntity();
        AirlinerEntity airlinerEntity3 = new AirlinerEntity();
        AirlinerEntity airlinerEntity4 = new AirlinerEntity();
        AirlinerEntity airlinerEntity5 = new AirlinerEntity();
        AirlinerEntity airlinerEntity6 = new AirlinerEntity();
        airfreighterEntity1.setModel("af1");
        airfreighterEntity1.setRange(5000);
        airfreighterEntity1.setKgFuelPerHour(850);
        airfreighterEntity1.setCargo(8000);
        airfreighterEntity2.setModel("af2");
        airfreighterEntity2.setRange(3000);
        airfreighterEntity2.setKgFuelPerHour(350);
        airfreighterEntity2.setCargo(5000);
        airlinerEntity1.setModel("al1");
        airlinerEntity1.setRange(9000);
        airlinerEntity1.setKgFuelPerHour(5000);
        airlinerEntity1.setSeating(500);
        airlinerEntity2.setModel("al2");
        airlinerEntity2.setRange(6000);
        airlinerEntity2.setKgFuelPerHour(4200);
        airlinerEntity2.setSeating(300);
        airlinerEntity3.setModel("al3");
        airlinerEntity3.setRange(9500);
        airlinerEntity3.setKgFuelPerHour(7000);
        airlinerEntity3.setSeating(800);
        airlinerEntity4.setModel("al4");
        airlinerEntity4.setRange(900);
        airlinerEntity4.setKgFuelPerHour(590);
        airlinerEntity4.setSeating(50);
        airlinerEntity5.setModel("al5");
        airlinerEntity5.setRange(2500);
        airlinerEntity5.setKgFuelPerHour(800);
        airlinerEntity5.setSeating(90);
        airlinerEntity6.setModel("al6");
        airlinerEntity6.setRange(2000);
        airlinerEntity6.setKgFuelPerHour(1900);
        airlinerEntity6.setSeating(110);
        addAirplane(airfreighterEntity1);
        addAirplane(airfreighterEntity2);
        addAirplane(airlinerEntity1);
        addAirplane(airlinerEntity2);
        addAirplane(airlinerEntity3);
        addAirplane(airlinerEntity4);
        addAirplane(airlinerEntity5);
        addAirplane(airlinerEntity6);
     }

    public static void addAirplane (AirplaneEntity airplane){
        allAirplanes.add(airplane);
    }

    public static void removeAirplane (int index){allAirplanes.remove(index);}

    public static void printAirplanes (){
        int i = 1;
        for (AirplaneEntity airplane: allAirplanes){
            System.out.println(i+". "+airplane.toString());
            i++;
        }
    }

    public static void printRangeSortedAirplanes (){
        allAirplanes.stream().sorted(Comparator.comparingInt(AirplaneEntity::getRange)).
                forEach(System.out::println);
    }

    public static void printAirplanesWithRequiredFuelConsumption (int min, int max){
        allAirplanes.stream().filter(airplane -> airplane.getKgFuelPerHour()>=min&airplane.getKgFuelPerHour()<=max).
                forEach(System.out::println);
    }

    public static int getOverallCargo(){
        int overAllCargo = 0;
        for (AirplaneEntity airplane:allAirplanes){
            if (airplane instanceof AirfreighterEntity){
                overAllCargo+=((AirfreighterEntity) airplane).getCargo();
            }
        }return overAllCargo;
    }

    public static int getOverallSeating() {
        int overallSeating = 0;
        for (AirplaneEntity airplane:allAirplanes){
            if (airplane instanceof AirlinerEntity){
                overallSeating+=((AirlinerEntity)airplane).getSeating();
            }
        }return overallSeating;
    }

}
