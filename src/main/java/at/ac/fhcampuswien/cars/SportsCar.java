package at.ac.fhcampuswien.cars;

public class SportsCar extends Car
{

    @Override
    public void accelerate() {
        speed+=15;
    }

    public int accelerate(int limit) {
        this.accelerate();
        if(this.speed > limit+5) {
            this.speed = limit + 5;
        }
        return this.speed;
    }

    public SportsCar(int speed) {
        super(speed);
    }

    public void pimpFrontWheels() {
        Wheel[] wheels = super.getWheels();
        wheels[0].setPressure(wheels[0].getPressure()+5);
        wheels[1].setPressure(wheels[1].getPressure()+5);
    }

}
