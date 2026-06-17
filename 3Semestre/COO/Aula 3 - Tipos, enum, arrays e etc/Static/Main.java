public class Main {
    public static void main(String[] args) {
        Bicycle bike1 = new Bicycle(10, 2, 20);
        Bicycle bike2 = new Bicycle(20, 3, 30);

        System.out.println("Bike 1 ID: " + bike1.getId());
        System.out.println("Bike 2 ID: " + bike2.getId());
        // System.out.println("Total number of bicycles: " + bike1.getNumberOfBicycles()); -> saida correta porem warning por causa do static
        System.out.println("Total number of bicycles: " + Bicycle.getNumberOfBicycles());
    }
}