public class CaixaGenéricaMaior <T1, T2> {
    private T1 objeto1;
    private T2 objeto2;

    public void guardar(T1 objeto1, T2 objeto2) {
        this.objeto1 = objeto1;
        this.objeto2 = objeto2;
    }

    public T1 obterObjeto1() {
        return objeto1;
    }

    public T2 obterObjeto2() {
        return objeto2;
    }
}
