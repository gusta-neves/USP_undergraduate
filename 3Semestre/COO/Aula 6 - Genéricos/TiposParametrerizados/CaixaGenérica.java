public class CaixaGenérica <T> {
    private T objeto;

    public void guardar(T objeto) {
        this.objeto = objeto;
    }

    public T obter() {
        return objeto;
    }
}
