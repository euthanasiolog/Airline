package company;

import entity.AirfreighterEntity;
import entity.AirlinerEntity;
import entity.AirplaneEntity;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;


/**
 * Created by piatr on 17.07.18.
 */
public class Controller {
    private static final Logger logger = Logger.getLogger(Controller.class);

    private static int min;
    private static int max;

    private static String getIn ()throws IOException{
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static void main(String[] args) throws IOException {
        logger.setLevel(Level.INFO);
        mainMenu();
    }

    private static void mainMenu (){
        logger.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. MANAGE AIRLINE \n 2. AIRLINE INFO \n 3. EXIT");
        try {
            switch (getIn()){
                case "1":
                    manageAirplanes();
                    break;
                case "2":
                    showAirlineInfo();
                    break;
                case "3":
                    logger.info("THANK YOU FOR CHOOSING OUR AIRLINES!");
                    break;
                default:
                    logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    mainMenu();
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            mainMenu();
        }
    }

    private static void manageAirplanes(){
        logger.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. SHOW ALL AIRPLANES/DELETE AIRPLANE \n 2. ADD AIRPLANE \n 3. BACK");
        try {
            switch (getIn()){
                case "1":
                    deleteAirplane();
                    break;
                case "2":
                    addAirplane();
                    break;
                case "3":
                    mainMenu();
                    break;
                default:
                    logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    manageAirplanes();
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            manageAirplanes();
        }
    }

    private static void addAirplane() {
        logger.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. ADD AIRFREIGHTER \n 2. ADD AIRLINER \n 3. BACK");
        try {
            switch (getIn()){
                case "1":
                    addAirfreighter();
                    break;
                case "2":
                    addAirliner();
                    break;
                case "3":
                    manageAirplanes();
                    break;
                default:
                    logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    addAirplane();
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            addAirplane();
        }
    }

    private static void addAirfreighter() {
        logger.info("FOR RETURN BACK ENTER 0 \n ENTER MODEL (STRING)");
        try {
            switch (getIn()){
                case "0":
                    addAirplane();
                    break;
                default:
                    AirfreighterEntity airfreighterEntity = new AirfreighterEntity();
                    setModel(airfreighterEntity);
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            addAirfreighter();
        }
    }

    private static void addAirliner() {
        logger.info("FOR RETURN BACK ENTER 0 \n ENTER MODEL (STRING)");
        try {
            switch (getIn()){
                case "0":
                    addAirplane();
                    break;
                default:
                    AirlinerEntity airlinerEntity = new AirlinerEntity();
                    setModel(airlinerEntity);
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            addAirliner();
        }
    }

    private static void setModel (AirplaneEntity airplaneEntity) {
        try {
            String in = getIn();
            airplaneEntity.setModel(in);
            setRange(airplaneEntity);
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            addAirplane();
        }
    }

    private static void setRange (AirplaneEntity airplaneEntity) {
        logger.info("FOR RETURN BACK ENTER 0 \n ENTER RANGE (km), MAX - 10.000km!");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirfreighter();
                    break;
                default:
                    if (new Integer(in)<=15000) {
                        try {
                            airplaneEntity.setRange(new Integer(in));
                            setFuelConsumption(airplaneEntity);
                        } catch (IllegalArgumentException e) {
                            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                            setRange(airplaneEntity);
                        }
                    } else {
                        logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        setRange(airplaneEntity);
                    }
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            setRange(airplaneEntity);
        }
    }

    private static void setFuelConsumption (AirplaneEntity airplaneEntity){
        logger.info("FOR RETURN BACK ENTER 0 \n ENTER FUEL CONSUMPTION (kg/hour)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirplane();
                    break;
                default:
                    try {
                        airplaneEntity.setKgFuelPerHour(new Integer(in));
                    } catch (IllegalArgumentException e){
                        logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        setFuelConsumption(airplaneEntity);
                    }
                    if (airplaneEntity instanceof AirfreighterEntity)
                        setCargo((AirfreighterEntity) airplaneEntity);
                    else
                    if (airplaneEntity instanceof  AirlinerEntity)
                        setSeating((AirlinerEntity) airplaneEntity);
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            setFuelConsumption(airplaneEntity);
        }
    }

    private static void setCargo (AirfreighterEntity airfreighterEntity){
        logger.info("FOR RETURN BACK ENTER 0 \n ENTER CARGO (kg)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirfreighter();
                    break;
                default:
                    try {
                        airfreighterEntity.setCargo(new Integer(in));
                        AirplaneLogic.addAirplane(airfreighterEntity);
                        addAirplane();
                    } catch (IllegalArgumentException e){
                        logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        setCargo(airfreighterEntity);
                    }
                    break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            setCargo(airfreighterEntity);
        }
    }

    private static void setSeating (AirlinerEntity airlinerEntity){
        logger.info("FOR RETURN BACK ENTER 0 \n ENTER SEATING (km)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirliner();
                    break;
                default:
                    try {
                        airlinerEntity.setSeating(new Integer(in));
                        AirplaneLogic.addAirplane(airlinerEntity);
                        addAirplane();
                    } catch (IllegalArgumentException e){
                        logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        setSeating(airlinerEntity);
                    }
                break;
            }
        } catch (IOException e) {
            logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            setSeating(airlinerEntity);
        }
    }

    private static void deleteAirplane() {
        AirplaneLogic.printAirplanes();
        logger.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 0. BACK \n 1. DELETE AIRPLANE (ENTER NUMBER OF AIRPLANE)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    manageAirplanes();
                    break;
                default:
                    try {
                        AirplaneLogic.removeAirplane(new Integer(in) - 1);
                        deleteAirplane();
                    } catch (IllegalArgumentException e){
                        logger.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        deleteAirplane();
                    }
                    break;
            }
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            deleteAirplane();
        }
    }

    private static void showAirlineInfo() {
        logger.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. SHOW OVERALL CAPACITY \n 2. SORT AIRPLANES BY RANGE \n 3. SHOW AIRPLANES WITH REQUIRED FUEL CONSUMPTION \n 4. BACK");
        try {
            switch (getIn()){
                case "1":
                    showOverallCapacity();
                    break;
                case "2":
                    sortAirplanesByRange();
                    break;
                case "3":
                    getAirplanesWithRequiredFuelConsumption();
                    break;
                case "4":
                    mainMenu();
                    break;
                default:
                    logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    showAirlineInfo();
                    break;
            }
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            showAirlineInfo();
        }
    }

    private static void showOverallCapacity() {
        logger.info("Overall cargo = "+AirplaneLogic.getOverallCargo()+", overall seating = "+AirplaneLogic.getOverallSeating());
        logger.info("FOR RETURN BACK ENTER ANY VALUE");
        try {
            if (getIn()!=null){
                showAirlineInfo();
            }
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            showOverallCapacity();
        }
    }

    private static void sortAirplanesByRange() {
        AirplaneLogic.printRangeSortedAirplanes();
        logger.info("FOR RETURN BACK ENTER ANY VALUE");
        try {
            if (getIn()!=null){
                showAirlineInfo();
            }
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            sortAirplanesByRange();
        }
    }

    private static void getAirplanesWithRequiredFuelConsumption () {
        logger.info("ENTER MIN VALUE");
        try {
            min = new Integer(getIn());
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            getAirplanesWithRequiredFuelConsumption();
        }
        logger.info("ENTER MAX VALUE");
        try {
            max = new Integer(getIn());
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            getAirplanesWithRequiredFuelConsumption();
        }
        AirplaneLogic.printAirplanesWithRequiredFuelConsumption(min, max);
        logger.info("FOR RETURN BACK ENTER ANY VALUE");
        try {
            if (getIn()!=null){
                showAirlineInfo();
            }
        } catch (IOException e) {
            logger.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            getAirplanesWithRequiredFuelConsumption();
        }
    }

}
