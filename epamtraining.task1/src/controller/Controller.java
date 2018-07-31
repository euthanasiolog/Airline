package controller;

import logic.AirplaneLogic;
import entity.Airfreighter;
import entity.Airliner;
import entity.Airplane;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.util.Scanner;


/**
 * Created by piatr on 17.07.18.
 */
public class Controller {
    private static final Logger LOGGER = Logger.getLogger(Controller.class);

    private static String getIn ()throws IOException{
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
    public static void main(String[] args) throws IOException {
        mainMenu();
    }

    private static void mainMenu (){
        LOGGER.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. MANAGE AIRLINE \n 2. AIRLINE INFO \n 3. EXIT");
        try {
            switch (getIn()){
                case "1":
                    manageAirplanes();
                    break;
                case "2":
                    showAirlineInfo();
                    break;
                case "3":
                    LOGGER.info("THANK YOU FOR CHOOSING OUR AIRLINES!");
                    break;
                default:
                    LOGGER.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    mainMenu();
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            mainMenu();
        }
    }

    private static void manageAirplanes(){
        LOGGER.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. SHOW ALL AIRPLANES/DELETE AIRPLANE \n 2. ADD AIRPLANE \n 3. BACK");
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
                    LOGGER.error("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    manageAirplanes();
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            manageAirplanes();
        }
    }

    private static void addAirplane() {
        LOGGER.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. ADD AIRFREIGHTER \n 2. ADD AIRLINER \n 3. BACK");
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
                    LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    addAirplane();
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            addAirplane();
        }
    }

    private static void addAirfreighter() {
        LOGGER.info("FOR RETURN BACK ENTER 0 \n ENTER MODEL (STRING)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirplane();
                    break;
                default:
                    Airfreighter airfreighter = new Airfreighter();
                    setModel(airfreighter, in);
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            addAirfreighter();
        }
    }

    private static void addAirliner() {
        LOGGER.info("FOR RETURN BACK ENTER 0 \n ENTER MODEL (STRING)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirplane();
                    break;
                default:
                    Airliner airliner = new Airliner();
                    setModel(airliner, in);
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            addAirliner();
        }
    }

    private static void setModel (Airplane airplane, String model) {
        airplane.setModel(model);
        setRange(airplane);
    }

    private static void setRange (Airplane airplane) {
        LOGGER.info("FOR RETURN BACK ENTER 0 \n ENTER RANGE (km), MAX - 10.000km!");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirfreighter();
                    break;
                default:
                    try {
                        if (new Integer(in)<=15000) {
                            airplane.setRange(new Integer(in));
                            setFuelConsumption(airplane);
                        } else {
                            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                            setRange(airplane);
                        }
                    } catch (IllegalArgumentException e) {
                        LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        LOGGER.error(e);
                        setRange(airplane);
                    }
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            setRange(airplane);
        }
    }

    private static void setFuelConsumption (Airplane airplane){
        LOGGER.info("FOR RETURN BACK ENTER 0 \n ENTER FUEL CONSUMPTION (kg/hour)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirplane();
                    break;
                default:
                    try {
                        airplane.setKgFuelPerHour(new Integer(in));
                    } catch (IllegalArgumentException e){
                        LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        LOGGER.error(e);
                        setFuelConsumption(airplane);
                    }
                    if (airplane instanceof Airfreighter)
                        setCargo((Airfreighter) airplane);
                    else
                    if (airplane instanceof Airliner)
                        setSeating((Airliner) airplane);
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            setFuelConsumption(airplane);
        }
    }

    private static void setCargo (Airfreighter airfreighter){
        LOGGER.info("FOR RETURN BACK ENTER 0 \n ENTER CARGO (kg)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirfreighter();
                    break;
                default:
                    try {
                        airfreighter.setCargo(new Integer(in));
                        AirplaneLogic.addAirplane(airfreighter);
                        addAirplane();
                    } catch (IllegalArgumentException e){
                        LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        LOGGER.error(e);
                        setCargo(airfreighter);
                    }
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            setCargo(airfreighter);
        }
    }

    private static void setSeating (Airliner airliner){
        LOGGER.info("FOR RETURN BACK ENTER 0 \n ENTER SEATING (km)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    addAirliner();
                    break;
                default:
                    try {
                        airliner.setSeating(new Integer(in));
                        AirplaneLogic.addAirplane(airliner);
                        addAirplane();
                    } catch (IllegalArgumentException e){
                        LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        LOGGER.error(e);
                        setSeating(airliner);
                    }
                break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            setSeating(airliner);
        }
    }

    private static void deleteAirplane() {
        AirplaneLogic.printAirplanes();
        LOGGER.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 0. BACK \n 1. DELETE AIRPLANE (ENTER NUMBER OF AIRPLANE)");
        try {
            String in = getIn();
            switch (in){
                case "0":
                    manageAirplanes();
                    break;
                default:
                    try {
                        AirplaneLogic.removeAirplane(new Integer(in));
                        deleteAirplane();
                    } catch (IllegalArgumentException e){
                        LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                        LOGGER.error(e);
                        deleteAirplane();
                    }
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            deleteAirplane();
        }
    }

    private static void showAirlineInfo() {
        LOGGER.info("CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. SHOW OVERALL CAPACITY \n 2. SORT AIRPLANES BY RANGE \n 3. SHOW AIRPLANES WITH REQUIRED FUEL CONSUMPTION \n 4. BACK");
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
                    LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
                    showAirlineInfo();
                    break;
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            showAirlineInfo();
        }
    }

    private static void showOverallCapacity() {
        LOGGER.info("Overall cargo = "+AirplaneLogic.getOverallCargo()+", overall seating = "+AirplaneLogic.getOverallSeating());
        LOGGER.info("FOR RETURN BACK ENTER ANY VALUE");
        try {
            if (getIn()!=null){
                showAirlineInfo();
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            showOverallCapacity();
        }
    }

    private static void sortAirplanesByRange() {
        AirplaneLogic.printRangeSortedAirplanes();
        LOGGER.info("FOR RETURN BACK ENTER ANY VALUE");
        try {
            if (getIn()!=null){
                showAirlineInfo();
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            sortAirplanesByRange();
        }
    }

    private static void getAirplanesWithRequiredFuelConsumption () {
        AirplaneLogic.printAirplanesWithRequiredFuelConsumption(getInt("MIN"), getInt("MAX"));
        LOGGER.info("FOR RETURN BACK ENTER ANY VALUE");
        try {
            if (getIn()!=null){
                showAirlineInfo();
            }
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            getAirplanesWithRequiredFuelConsumption();
        }
    }

    private static int getInt(String name) {
        LOGGER.info("ENTER "+name+" VALUE");
        try {
            int i = new Integer(getIn());
            return i;
        } catch (IOException e) {
            LOGGER.info("!!!------->PLEASE, ENTER THE CORRECT VALUE!");
            LOGGER.error(e);
            getAirplanesWithRequiredFuelConsumption();
        }
        return 0;
    }

}
