public class CaixaGenérica <T> {
    private T objeto;

    public void guardar(T objeto) {
        this.objeto = objeto;
    }

    public T obter() {
        return objeto;
    }
}

// O tipo T é um tipo genérico, que pode ser substituído por qualquer tipo de dado (Integer, String, etc.) 
// quando a classe for instanciada. Isso permite que a classe seja reutilizada para diferentes tipos de 
// dados sem a necessidade de criar uma nova classe para cada tipo.
// Exemplo de uso na Main.java
