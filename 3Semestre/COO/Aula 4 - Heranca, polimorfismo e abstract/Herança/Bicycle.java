public class Bicycle {
    // a classe Bicycle tem três campos
    public int cadence, gear, speed;
    // a classe Bicycle tem um construtor
    public Bicycle(int startCadence,
                    int startSpeed,
                    int startGear) {
        gear = startGear;
        cadence = startCadence;
        speed = startSpeed;
    }
    // a classe Bicycle tem quatro métodos
    public void setCadence(int newValue) {
        cadence = newValue;
    }
    public void setGear(int newValue) {
        gear = newValue;
    }
    public void applyBrake(int decrement) {
        speed -= decrement;
    }
    public void speedUp(int increment) {
        speed += increment;
    }
}