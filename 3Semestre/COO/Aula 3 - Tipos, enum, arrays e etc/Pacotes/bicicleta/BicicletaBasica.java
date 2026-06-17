package Pacotes.bicicleta;

/*
 * Implementação simples da interface Bicicleta.
 */
public class BicicletaBasica implements Bicicleta {

    public void pedalar() {
        System.out.println("Pedalando...");
    }

    public void frear() {
        System.out.println("Freando...");
    }
}