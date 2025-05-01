import java.util.Scanner;

import game.Car;
import game.GameRace;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        GameRace.welcome();

        GameRace.preparation(sc);

        GameRace.start();

    }
}