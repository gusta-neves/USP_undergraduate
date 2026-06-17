public class Bicycle {
    private int cadence;
    private int gear;
    private int speed;
    // adiciona uma variável de instância para o ID do objeto
    private int id;

    public Bicycle(int cadence, int gear, int speed) {
        this.cadence = cadence;
        this.gear = gear;
        this.speed = speed;
        // incrementa o número de bicicletas e atribui o ID
        numberOfBicycles++;
        this.id = numberOfBicycles;
    }

    // adiciona uma variável de classe para o número de
    // objetos Bicycle instanciados, ou seja é como se
    // fosse um contador de objetos, ou uma variável global para a classe
    private static int numberOfBicycles = 0;

    // como esse método é estático, ele pertence à classe e pode ser chamado sem a necessidade de criar um objeto da classe
    // ex: Math.sqrt(4) ou Bicycle.getNumberOfBicycles()
    public static int getNumberOfBicycles() {
        return numberOfBicycles;
    }

    public int getId() {
        return id;
    }
}