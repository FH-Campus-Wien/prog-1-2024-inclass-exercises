package at.ac.fhcampuswien.cars;

public class CarApp {

    public static void main(String[] args)
    {
        Car c1= new Taxi(80);
        System.out.println(c1.accelerate(100));
        Car c2= new Taxi(99);
        System.out.println(c2.accelerate(100)); // 100

        Car c3= new SportsCar(99);
        System.out.println(c3.accelerate(100)); // 105
    }
}
