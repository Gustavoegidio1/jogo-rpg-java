public class Guerreiro extends Personagem{

    public Guerreiro(String nome, int vidaMaxima, int ataque1, int ataque2, int recurso) {
        super(nome, vidaMaxima, ataque1, ataque2, "Golpe de Aço", "Investida Brutal", "Armadura", recurso);
    }

    @Override
    public void receberDano(int dano) {
        if (getRecursoAtual() >= dano) {
            gastarRecurso(dano);
        }
        else {
            dano -= getRecursoAtual();
            zerarRecurso();
            super.receberDano(dano);
        }

    }
}
