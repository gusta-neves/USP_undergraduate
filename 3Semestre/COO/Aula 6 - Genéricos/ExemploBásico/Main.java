public class Main {
    public static void main(String[] args) {
        CaixaGenérica<Integer> caixaDeInteiros = new CaixaGenérica<>();
        CaixaGenérica<String> caixaDeStrings = new CaixaGenérica<>();

        caixaDeInteiros.guardar(123);
        // caixaDeInteiros.guardar("oi");
        System.out.println(caixaDeInteiros.obter()); // Saída: 123
        caixaDeStrings.guardar("Olá, mundo!");

        System.out.println(caixaDeStrings.obter()); // Saída: Olá, mundo!

        CaixaGenéricaMaior<Integer, String> caixaMaior = new CaixaGenéricaMaior<>();
        caixaMaior.guardar(456, "Outro exemplo");
        System.out.println(caixaMaior.obterObjeto1()); // Saída: 456
        System.out.println(caixaMaior.obterObjeto2()); // Saída: Outro
    }
}
