package game;

public class Car {
    public final String nameCar;
    public final int speed;
    public final int maxSpeed = 250;
    public final int minSpeed = 0;
    private int mileage;

    public Car(String nameCar, int speed){
        this.nameCar = nameCar;
        this.speed = speed;
    }

    public void move(int speed){
        mileage += speed;
    }

    public int getMileage() {
        return mileage;
    }
}
