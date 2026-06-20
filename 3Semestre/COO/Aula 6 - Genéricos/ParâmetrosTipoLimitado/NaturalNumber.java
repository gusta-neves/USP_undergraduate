/*
- Os parâmetros de tipo podem ou não ser limitados
- O limite de um parâmetro de tipo restringe os tipos que podem
ser usados como argumento. O limite pode ser uma classe e/ou
várias interfaces
- O parâmetro de tipo limitado dá acesso aos métodos do “tipo
limitante”
*/

// Nesse caso limitamos T a variáveis que são Number, isso é, Number ou classes que "extends" Number

public class NaturalNumber<T extends Number> {
    private T n;
    
    public NaturalNumber(T n) { 
        this.n = n; 
    }

    public boolean isEven() {
        return(n.intValue() % 2 == 0);
    }
}
