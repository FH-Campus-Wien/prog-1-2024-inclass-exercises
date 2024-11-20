package at.ac.fhcampuswien.cars;

public class Wheel {

    int pressure;

    public int getPressure() {
        return pressure;
    }

    public void setPressure(int pressure) {
        this.pressure=pressure;
    }

    public Wheel(int pressure) {
        this.pressure = pressure;
    }
}
