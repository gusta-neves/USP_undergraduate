public class Main {
    public static void main(String[] args) {
        // Um tipo parametrizado é um tipo como outro qualquer. Em
        // particular, você pode substituir um parâmetro de tipo (i.e., K ou V)
        // por um outro tipo parametrizado (i.e., List<String>)
        OrderedPair <String, CaixaGenérica<Integer>> p = new OrderedPair<>("olá", new CaixaGenérica<Integer>());

        // Note que para acessar a caixa, ela é "Value" do par ordenado, ou seja basta fazer

        p.getValue().guardar(10);
    }
}