package at.ac.fhcampuswien.cars;

public class Car
{
        private Wheel[] frontWheels= new Wheel[2];
        private Wheel[] backWheels= new Wheel[2];
        int speed=10;

        public void accelerate() {
            speed+=5;
        }

        public int accelerate(int limit) {
            this.accelerate();
            if(this.speed>limit) {
                this.speed = limit;
            }
            return this.speed;
        }

        public Wheel[] getWheels() {
            return new Wheel[]{frontWheels[0], frontWheels[1],
                backWheels[0], backWheels[1]};
        }

        public Car(int speed)
        {
            this.speed = speed;

            this.frontWheels[0]= new Wheel(15);
            this.frontWheels[1]= new Wheel(15);
            this.backWheels[0]= new Wheel(10);
            this.backWheels[1]= new Wheel(10);
        }
}
