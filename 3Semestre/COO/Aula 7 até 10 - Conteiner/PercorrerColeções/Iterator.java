public interface Iterator <E> {
    boolean hasNext();
    E next();
    void remove(); // opcional
}

/*
- Um Iterador é um objeto que permite que você percorra uma
coleção.
- Também permite remover elementos seletivamente da coleção
(se você quiser).
- Você pode obter uma instância de um iterador (do tipo
Iterator) chamando o método iterator().
*/

// Exemplo de aplicação.

static void filer(Collection<?> c) {
    // O for tem mesmo formato de C, for (uma variavel, enquanto, incrementa)
    for (Iterator<?> it = c.iterator(); it,hasNext();) {
        if (!cond(it.next())) {
            it.remove();
        }
    }
}
