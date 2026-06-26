/*
 * T possui TRÊS limitantes:
 *
 * 1) T deve ser um Animal
 * 2) T deve implementar Corredor
 * 3) T deve implementar Nadador
 *
 * Em outras palavras:
 *
 * T extends Animal & Corredor & Nadador
 *
 * Todo tipo que eu usar como T precisa ser um Animal, implementar Corredor e implementar Nadador.
*/

class Competidor<T extends Animal & Corredor & Nadador> {

    private T participante;

    public Competidor(T participante) {
        this.participante = participante;
    }

    public void demonstrarHabilidades() {
        participante.respirar(); // vem de Animal
        participante.correr();   // vem de Corredor
        participante.nadar();    // vem de Nadador
    }
}
