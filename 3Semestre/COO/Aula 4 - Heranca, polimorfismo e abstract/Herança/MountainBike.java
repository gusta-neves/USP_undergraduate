/*
Toda classe:
- herda os campos e métodos visíveis de sua(s) superclasse(s)
- pode sobrescrever (override) métodos para mudar seu
comportamento
*/

public class MountainBike extends Bicycle {
    // Campo da subclasse MountainBike, não de Bicycle
    protected int seatHeight;

    // a subclasse MountainBike tem um construtor
    public MountainBike(int startHeight,
                        int startCadence,
                        int startSpeed,
                        int startGear) {
        // reutiliza o construtor da classe superior
        super(startCadence, startSpeed, startGear);
        seatHeight = startHeight;
    }

    // a subclasse MountainBike adiciona um método
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
}