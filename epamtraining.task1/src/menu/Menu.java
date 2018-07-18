package menu;

import airplane.*;
import company.AirplaneLogic;

import java.io.IOException;

/**1
 * Created by piatr on 18.07.18.
 */
public final class Menu {

    private static final String INCORRECT_IN = "!!!------->PLEASE, ENTER THE CORRECT VALUE!";
    private static final String EXIT = "THANK YOU FOR CHOOSING OUR AIRLINES!";
    private static final String MAIN_MENU = "CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. MANAGE AIRLINE \n 2. AIRLINE INFO \n 3. EXIT";
    private static final String MENU_1 = "CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1.  SHOW ALL AIRPLANES/DELETE AIRPLANE \n 2. ADD AIRPLANE \n 3. BACK";
    private static final String MENU_1_1 = "CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 0. BACK \n 1. DELETE AIRPLANE (ENTER NUMBER OF AIRPLANE)";
    private static final String MENU_1_2 = "CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. ADD AIRFREIGHTER \n 2. ADD REGIONAL LINER \n 3. ADD NARROW BODY LINER \n 4. ADD WIDE BODY LINER \n 5. BACK";
    private static final String MENU_1_2_11 = "ENTER MODEL (STRING)";
    private static final String MENU_1_2_12 = "ENTER FUEL CONSUMPTION (kg per hour)";
    private static final String MENU_1_2_13 = "ENTER RANGE (km)";
    private static final String MENU_1_2_14 = "ENTER CARGO (kg)";
    private static final String MENU_1_2_24 = "ENTER SEATING (persons)";
    private static final String MENU_2 = "CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. SHOW OVERALL CAPACITY \n 2. SORT AIRPLANES BY RANGE \n 3. SHOW AIRPLANES WITH REQUIRED FUEL CONSUMPTION \n 4. BACK";
    private static final String MENU_2_123 = "CHOOSE ACTION (ENTER NUMBER OF MENU POINT): \n 1. BACK";
    private static final String MENU_2_3_1 = "ENTER MIN VALUE";
    private static final String MENU_2_3_2 = "ENTER MAX VALUE";
    private static Integer min;
    private static Integer max;



    public static void mainMenu(){
        System.out.println(MAIN_MENU);
    }
    public static void mainMenu(String in) throws IOException{
        switch (in) {
            case "1":
                menu_1();
                menu_1(MenuHelper.getIn());
                break;
            case "2":
                menu_2();
                menu_2(MenuHelper.getIn());
                break;
            case "3":
                System.out.println(EXIT);
                System.exit(0);
                break;
            default:
                System.out.println(INCORRECT_IN);
                mainMenu();
                mainMenu(MenuHelper.getIn());
                break;
        }
        }

     public static void menu_1 (){
         System.out.println(MENU_1);
     }
     public static void menu_1(String in) throws IOException{
         switch (in) {
             case "1":
                 menu_1_1();
                 menu_1_1(MenuHelper.getIn());
                 break;
             case "2":
                 menu_1_2();
                 menu_1_2(MenuHelper.getIn());
                 break;
             case "3":
                 mainMenu();
                 mainMenu(MenuHelper.getIn());
                 break;
             default:
                 System.out.println(INCORRECT_IN);
                 menu_1();
                 menu_1(MenuHelper.getIn());
                 break;
         }
     }

    public static void menu_1_1 (){
        System.out.println(MENU_1_1);
        AirplaneLogic.printAirplanes();
    }
    public static void menu_1_1(String in) throws IOException{
               if (in.equals("0"))
               {
                menu_1();
                menu_1(MenuHelper.getIn());
               }else {
                   try {
                       int index = new Integer(in);
                       AirplaneLogic.removeAirplane(index-1);
                       menu_1_1();
                       menu_1_1(MenuHelper.getIn());
                   } catch (IllegalArgumentException e){
                       System.out.println(INCORRECT_IN);
                       menu_1_1();
                       menu_1_1(MenuHelper.getIn());
                   }

               }
    }

    public static void menu_1_2 (){
        System.out.println(MENU_1_2);
    }
    public static void menu_1_2(String in) throws IOException{
        switch (in) {
            case "1":
                Airfreighter airfreighter = new Airfreighter();
                menu_1_2_11();
                menu_1_2_11(MenuHelper.getIn(), airfreighter);
                menu_1_2_12();
                menu_1_2_12(MenuHelper.getIn(), airfreighter);
                menu_1_2_13();
                menu_1_2_13(MenuHelper.getIn(), airfreighter);
                menu_1_2_14();
                menu_1_2_14(MenuHelper.getIn(), airfreighter);
                AirplaneLogic.addAirplane(airfreighter);
                menu_1_2();
                menu_1_2(MenuHelper.getIn());
                break;
            case "2":
                RegionalAirliner regionalAirliner = new RegionalAirliner();
                menu_1_2_21();
                menu_1_2_21(MenuHelper.getIn(), regionalAirliner);
                menu_1_2_22();
                menu_1_2_22(MenuHelper.getIn(), regionalAirliner);
                menu_1_2_23();
                menu_1_2_23(MenuHelper.getIn(), regionalAirliner);
                menu_1_2_24();
                menu_1_2_24(MenuHelper.getIn(), regionalAirliner);
                AirplaneLogic.addAirplane(regionalAirliner);
                menu_1_2();
                menu_1_2(MenuHelper.getIn());
                break;
            case "3":
                NarrowBodyAirliner narrowBodyAirliner = new NarrowBodyAirliner();
                menu_1_2_31();
                menu_1_2_31(MenuHelper.getIn(), narrowBodyAirliner);
                menu_1_2_32();
                menu_1_2_32(MenuHelper.getIn(), narrowBodyAirliner);
                menu_1_2_33();
                menu_1_2_33(MenuHelper.getIn(), narrowBodyAirliner);
                menu_1_2_34();
                menu_1_2_34(MenuHelper.getIn(), narrowBodyAirliner);
                AirplaneLogic.addAirplane(narrowBodyAirliner);
                menu_1_2();
                menu_1_2(MenuHelper.getIn());
                break;
            case "4":
                WideBodyAirliner wideBodyAirliner = new WideBodyAirliner();
                menu_1_2_41();
                menu_1_2_41(MenuHelper.getIn(), wideBodyAirliner);
                menu_1_2_42();
                menu_1_2_42(MenuHelper.getIn(), wideBodyAirliner);
                menu_1_2_43();
                menu_1_2_43(MenuHelper.getIn(), wideBodyAirliner);
                menu_1_2_44();
                menu_1_2_44(MenuHelper.getIn(), wideBodyAirliner);
                AirplaneLogic.addAirplane(wideBodyAirliner);
                menu_1_2();
                menu_1_2(MenuHelper.getIn());
                break;
            case "5":
                menu_1();
                menu_1(MenuHelper.getIn());
                break;
            default:
                System.out.println(INCORRECT_IN);
                menu_1_2();
                menu_1_2(MenuHelper.getIn());
                break;
        }
    }

    public static void menu_1_2_11 (){
        System.out.println(MENU_1_2_11);
    }
    public static void menu_1_2_11(String in, Airfreighter airfreighter) throws IOException {
        try {
            airfreighter.setModel(in);
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_12 (){
        System.out.println(MENU_1_2_12);
    }
    public static void menu_1_2_12(String in, Airfreighter airfreighter) throws IOException{
        try {
            airfreighter.setKgFuelPerHour(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }

    }

    public static void menu_1_2_13 (){
        System.out.println(MENU_1_2_13);
    }
    public static void menu_1_2_13(String in, Airfreighter airfreighter) throws IOException {
        try {
            airfreighter.setRange(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_14 (){
        System.out.println(MENU_1_2_14);
    }
    public static void menu_1_2_14(String in, Airfreighter airfreighter) throws IOException {
        try {
            airfreighter.setCargo(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_21 (){
        System.out.println(MENU_1_2_11);
    }
    public static void menu_1_2_21(String in, RegionalAirliner regionalAirliner) throws IOException {
        try {
            regionalAirliner.setModel(in);
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_22 (){
        System.out.println(MENU_1_2_12);
    }
    public static void menu_1_2_22(String in, RegionalAirliner regionalAirliner) throws IOException {
        try {
            regionalAirliner.setKgFuelPerHour(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_23 (){
        System.out.println(MENU_1_2_13);
    }
    public static void menu_1_2_23(String in, RegionalAirliner regionalAirliner) throws IOException {
        try {
            regionalAirliner.setRange(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_24 (){
        System.out.println(MENU_1_2_24);
    }
    public static void menu_1_2_24(String in, RegionalAirliner regionalAirliner) throws IOException {
        try {
            regionalAirliner.setSeating(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_31 (){
        System.out.println(MENU_1_2_11);
    }
    public static void menu_1_2_31(String in, NarrowBodyAirliner narrowBodyAirliner) throws IOException {
        try {
            narrowBodyAirliner.setModel(in);
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_32 (){
        System.out.println(MENU_1_2_12);
    }
    public static void menu_1_2_32(String in, NarrowBodyAirliner narrowBodyAirliner) throws IOException {
        try {
            narrowBodyAirliner.setKgFuelPerHour(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_33 (){
        System.out.println(MENU_1_2_13);
    }
    public static void menu_1_2_33(String in, NarrowBodyAirliner narrowBodyAirliner) throws IOException {
        try {
            narrowBodyAirliner.setRange(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_34 (){
        System.out.println(MENU_1_2_24);
    }
    public static void menu_1_2_34(String in, NarrowBodyAirliner narrowBodyAirliner) throws IOException {
        try {
            narrowBodyAirliner.setSeating(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }


    public static void menu_1_2_41 (){
        System.out.println(MENU_1_2_11);
    }
    public static void menu_1_2_41(String in, WideBodyAirliner wideBodyAirliner) throws IOException {
        try {
            wideBodyAirliner.setModel(in);
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_42 (){
        System.out.println(MENU_1_2_12);
    }
    public static void menu_1_2_42(String in, WideBodyAirliner wideBodyAirliner) throws IOException {
        try {
            wideBodyAirliner.setKgFuelPerHour(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_43 (){
        System.out.println(MENU_1_2_13);
    }
    public static void menu_1_2_43(String in, WideBodyAirliner wideBodyAirliner) throws IOException {
        try {
            wideBodyAirliner.setRange(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_1_2_44 (){
        System.out.println(MENU_1_2_24);
    }
    public static void menu_1_2_44(String in, WideBodyAirliner wideBodyAirliner) throws IOException {
        try {
            wideBodyAirliner.setSeating(new Integer(in));
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_1_2();
            menu_1_2(MenuHelper.getIn());
        }
    }

    public static void menu_2 (){
        System.out.println(MENU_2);
    }
    public static void menu_2(String in) throws IOException {
        switch (in) {
            case "1":
            menu_2_1();
            menu_2_1(MenuHelper.getIn());
                break;
            case "2":
                menu_2_2();
                menu_2_2(MenuHelper.getIn());
                break;
            case "3":
                menu_2_3();
                menu_2_3(MenuHelper.getIn());
                menu_2_3_1();
                menu_2_3_1(MenuHelper.getIn());
                menu_2_3_2();
                menu_2_3_2(MenuHelper.getIn());
                break;
            case "4":
                mainMenu();
                mainMenu(MenuHelper.getIn());
                break;
            default:
                System.out.println(INCORRECT_IN);
                menu_2();
                menu_2(MenuHelper.getIn());
                break;
        }
    }

    public static void menu_2_1 (){
        int cargo = AirplaneLogic.getOverallCargo();
        int seating = AirplaneLogic.getOverallSeating();
        System.out.println("Overall cargo = "+cargo+"\n"+"Overall seating = "+seating);
        System.out.println(MENU_2_123);
    }
    public static void menu_2_1(String in) throws IOException {
            if (in.equals("1")){
                menu_2();
                menu_2(MenuHelper.getIn());
            } else {
                System.out.println(INCORRECT_IN);
                menu_2_1();
                menu_2_1(MenuHelper.getIn());
            }
    }

    public static void menu_2_2 (){
        AirplaneLogic.printRangeSortedAirplanes();
        System.out.println(MENU_2_123);
    }
    public static void menu_2_2(String in) throws IOException {
        if (in.equals("1")){
            menu_2();
            menu_2(MenuHelper.getIn());
        } else {
            System.out.println(INCORRECT_IN);
            menu_2_2();
            menu_2_2(MenuHelper.getIn());
        }
    }


    public static void menu_2_3 (){
        System.out.println(MENU_2_3_1);
    }
    public static void menu_2_3(String in) throws IOException {
        try {
            min = new Integer(in);
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_2_3();
            menu_2_3(MenuHelper.getIn());
        }

    }

    public static void menu_2_3_1 (){
        System.out.println(MENU_2_3_1);
    }
    public static void menu_2_3_1(String in) throws IOException {
        try {
            max = new Integer(in);
        }catch (IllegalArgumentException e){
            System.out.println(INCORRECT_IN);
            menu_2_3();
            menu_2_3(MenuHelper.getIn());
        }
    }

    public static void menu_2_3_2 (){
        AirplaneLogic.printAirplanesWithfRequiredFuelConsumption(min, max);
        System.out.println(MENU_2_123);
    }

    public static void menu_2_3_2(String in) throws IOException {
        if (in.equals("1")){
            menu_2();
            menu_2(MenuHelper.getIn());
        } else {
            System.out.println(INCORRECT_IN);
            menu_2_3();
            menu_2_3(MenuHelper.getIn());
        }
    }

}




