package Pacotes.bicicleta;

/*
 * Especialização da BicicletaBasica.
 */
public class MountainBike extends BicicletaBasica {

    private int marcha;

    public MountainBike(int marcha) {
        this.marcha = marcha;
    }

    public void trocarMarcha(int novaMarcha) {
        this.marcha = novaMarcha;
        System.out.println("Marcha alterada para: " + marcha);
    }
}