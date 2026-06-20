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
// Quanto T não é especificado, o tipo genérico é tratado como Object, ou seja, a classe pode armazenar 
// qualquer tipo de dado, mas o tipo de dado armazenado não é conhecido em tempo de compilação, o que pode 
// levar a erros em tempo de execução. Por isso, é recomendado sempre especificar o tipo genérico ao instanciar a classe.
