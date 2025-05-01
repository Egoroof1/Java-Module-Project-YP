package game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameRace {
    public static final String nameGame = "24 часа Ле-Мана";
    public static ArrayList<Car> cars = new ArrayList<Car>();


    public static void start(){
        Car winner = null;
        for (Car c : cars){
            if(winner==null) winner = c;
            if(winner.speed < c.speed) winner = c;
        }
        for (int i = 1; i <= 24; i++) {
            try {
                Thread.sleep(300);
                System.out.println("Прошло "+i+"/24 часть гонки");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.println("Финиш\n");
        System.out.println("------------------------------------------------------");

        System.out.println(String.format("Победил %s, проехав %d километров за 24 часа.", winner.nameCar, winner.speed * 24));
    }

    public static void preparation(Scanner sc){


        for (int i = 1; i <= 3; i++) {
            System.out.print(i + "-ая машина: ");

            String input = sc.nextLine();

            while (true){
                if (isValidInputManual(input)) {
                    cars.add(new Car(getCarName(input), getCarSpeed(input)));
                    break;
                } else {
                    System.out.println("Введите название в формате: Название-скорость");
                    System.out.println("Название - может быть любым");
                    System.out.println("Скорость - целое число от 1 до 250");
                    System.out.print(i + "-ая машина: ");
                    input = sc.nextLine();
                }
            }
        }
    }

    public static int getCarSpeed(String input){
        return Integer.parseInt(input.split("-")[1].trim());
    }

    public static String getCarName(String input){
        return input.split("-")[0].trim();
    }

    public static void welcome(){
        try {
            System.out.println("Welcome to " + GameRace.nameGame);
            Thread.sleep(2000);
            System.out.println("Введите название и скорость трёх машин\n" +
                    "В формате: Название-скорость");
            System.out.println("Название - может быть любым");
            System.out.println("Скорость - целое число от 1 до 250");
            Thread.sleep(1000);
            System.out.println("Начнём!");
        } catch (InterruptedException e) {
            e.getStackTrace();
        }
    }

    public static boolean isValidInputManual(String input){
        if (input == null && input.isEmpty()) return false;

        String[] param = input.split("-");
        if (param.length != 2) return false;

        String carName = param[0].trim();
        String speedStr = param[1].trim();

        if (carName.isEmpty()) return false;

        try {
            int speed = Integer.parseInt(speedStr);
            if (speed < 0 || speed > 250) {
                return false;
            }
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }

}
