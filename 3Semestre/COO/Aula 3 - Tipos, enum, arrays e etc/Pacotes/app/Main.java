package Pacotes.app;

/*
 * Importa os tipos do pacote bicicleta.
 */
import Pacotes.bicicleta.Bicicleta;
import Pacotes.bicicleta.BicicletaBasica;
import Pacotes.bicicleta.MountainBike;

public class Main {

    public static void main(String[] args) {

        Bicicleta bike = new BicicletaBasica();

        bike.pedalar();
        bike.frear();

        System.out.println();

        MountainBike mtb = new MountainBike(3);

        mtb.pedalar();
        mtb.trocarMarcha(5);
    }
}
